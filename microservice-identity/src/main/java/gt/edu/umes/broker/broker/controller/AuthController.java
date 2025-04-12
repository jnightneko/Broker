package gt.edu.umes.broker.broker.controller;

import gt.edu.umes.broker.broker.client.AdministracionCliente;
import gt.edu.umes.broker.broker.dto.*;
import gt.edu.umes.broker.broker.entity.UserCredential;
import gt.edu.umes.broker.broker.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/broker")
public class AuthController {
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final AdministracionCliente administracionCliente;

    @Autowired
    public AuthController(AuthService authService,
                          AuthenticationManager authenticationManager,
                          AdministracionCliente administracionCliente) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
        this.administracionCliente = administracionCliente;
    }

    @PostMapping("/auth/admin") /*probado*/
    public ResponseEntity<EmpleadoResponseDTO> validarEmpleado(@RequestBody AuthRequest authRequest) {
        EmpleadoResponseDTO empleado = administracionCliente.validarEmpleado(authRequest);
        return ResponseEntity.ok(empleado);
    }

    @PostMapping("/auth/register") /*probado*/
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequestDTO request) {
        String resultado = authService.registerUser(request);
        return ResponseEntity.ok(resultado);
    }

    @PostMapping("/auth/token") /*probado*/
    public ResponseEntity<AuthResponseDTO> getToken(@RequestBody AuthRequest authRequest) {
        EmpleadoResponseDTO empleado = administracionCliente.validarEmpleado(authRequest);

        if (empleado == null || !empleado.isActivo()) {
            throw new RuntimeException("Credencias invalidas o usuario inactivo");
        }

        AuthResponseDTO response = authService.authenticationUser(authRequest);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/auth/validate") /*probado*/
    public ResponseEntity<UserInfoDTO> validateToken(@RequestHeader("Authorization") String token) {
        String jwtToken = token.startsWith("Bearer ") ? token.substring(7) : token;

        authService.validarToken(jwtToken);
        UserInfoDTO userInfoDTO = authService.obtenerInfoUsuario(jwtToken);
        return ResponseEntity.ok(userInfoDTO);
    }

    @GetMapping("/auth/userinfo") /*probado*/
    public ResponseEntity<UserInfoDTO> getUserInfo(@RequestHeader("Authorization") String token) {
        String jwtToken = token.startsWith("Bearer ") ? token.substring(7) : token;
        UserInfoDTO userInfoDTO = authService.obtenerInfoUsuario(jwtToken);
        return ResponseEntity.ok(userInfoDTO);
    }
}
