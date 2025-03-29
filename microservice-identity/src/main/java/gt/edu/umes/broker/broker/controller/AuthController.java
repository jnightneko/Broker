package gt.edu.umes.broker.broker.controller;

import gt.edu.umes.broker.broker.dto.AuthRequest;
import gt.edu.umes.broker.broker.entity.UserCredential;
import gt.edu.umes.broker.broker.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserCredential userCredential){
        authService.saveUser(userCredential);
        return "Usuario registrado";
    }

    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        if (authentication.isAuthenticated()){
            return authService.generateToken(authRequest.getEmail());
        }
        else {
            throw new RuntimeException("Acceso invalido");
        }
    }

    @PostMapping("/validate")
    public String validateToken(@RequestParam("token") String token){
        String confirmacion;

        authService.validateToken(token);
        return confirmacion = "Token valido";
    }
}
