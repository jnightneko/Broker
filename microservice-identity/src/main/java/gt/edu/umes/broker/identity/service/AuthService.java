package gt.edu.umes.broker.identity.service;

import gt.edu.umes.broker.identity.client.AuthAdminClient;
import gt.edu.umes.broker.identity.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthAdminClient authAdminClient;

    @Autowired
    public AuthService(PasswordEncoder passwordEncoder,
                       JwtService jwtService,
                       AuthAdminClient authAdminClient) {
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authAdminClient = authAdminClient;
    }

    public AuthResponseDTO authenticationUser(AuthRequest authRequest) {
        EmpleadoResponseDTO empleado = authAdminClient.validarEmpleado(authRequest);

        if (empleado == null || empleado.getPasswordEncriptada() == null) {
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

        if(authAdminClient.existeUsuario(request.getEmail())) {
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
            boolean registroExitoso = authAdminClient.registrarUsuario(registroDTO);

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

        EmpleadoResponseDTO empleado = authAdminClient.validarEmpleado(
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
