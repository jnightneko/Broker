package gt.edu.umes.broker.broker.service;

import gt.edu.umes.broker.broker.client.AdministracionCliente;
import gt.edu.umes.broker.broker.dto.*;
import gt.edu.umes.broker.broker.entity.UserCredential;
import gt.edu.umes.broker.broker.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AdministracionCliente administracionCliente;

    @Autowired
    public AuthService(PasswordEncoder passwordEncoder,
                       JwtService jwtService,
                       AdministracionCliente administracionCliente) {
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.administracionCliente = administracionCliente;
    }

    public AuthResponseDTO authenticationUser(AuthRequest authRequest) {
        EmpleadoResponseDTO empleado = administracionCliente.validarEmpleado(authRequest);

        if (empleado == null) {
            throw new RuntimeException("Credenciales invalidas");
        }

        if (!passwordEncoder.matches(authRequest.getPassword(), empleado.getPasswordEncriptada())) {
            throw new RuntimeException("Contrase;a incorrecta");
        }

        String token = jwtService.generateToken(empleado.getEmail());

        return new AuthResponseDTO(
                token,
                empleado.getId(),
                empleado.getNombre(),
                empleado.getEmail(),
                empleado.getRoles()
        );
    }

    public String registerUser(UserRegistrationRequestDTO request) {
        if(request.getEmail() == null || request.getEmail().isEmpty() || request.getPassword() == null || request.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Correo y contraseña son campos obligatorios");
        }

        if(administracionCliente.existeUsuario(request.getEmail())) {
            throw new RuntimeException("El usuario " + request.getEmail() + " ya existe");
        }

        String contraseñaEncriptada = passwordEncoder.encode(request.getPassword());

        EmpleadoRegistroDTO registroDTO = new EmpleadoRegistroDTO(
                request.getEmail(),
                contraseñaEncriptada,
                request.getNombre(),
                request.getRoles()
        );

        try{
            boolean registroExitoso = administracionCliente.registrarUsuario(registroDTO);

            if (!registroExitoso) {
                throw new RuntimeException("Error al registrar usuario en Administracion");
            }

            return "Usuario registrado correctamente";

        } catch (Exception e) {
            throw new RuntimeException("Error al comunicarse con Administracion " + e.getMessage());
        }
    }

    public void validarToken(String token) {
        jwtService.validateToken(token);
    }

    public UserInfoDTO obtenerInfoUsuario(String token) {
        String username = jwtService.extractUsername(token);

        EmpleadoResponseDTO empleado = administracionCliente.validarEmpleado(
                new AuthRequest(username, "")
        );

        return new UserInfoDTO(
                empleado.getId(),
                empleado.getNombre(),
                empleado.getEmail(),
                empleado.getRoles()
        );
    }
}
