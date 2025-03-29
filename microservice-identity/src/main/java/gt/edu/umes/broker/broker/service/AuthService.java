package gt.edu.umes.broker.broker.service;

import gt.edu.umes.broker.broker.entity.UserCredential;
import gt.edu.umes.broker.broker.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserCredentialRepository userCredentialRepository;

    public String saveUser(@RequestBody UserCredential userCredential){
        if(userCredentialRepository.existsByEmail(userCredential.getEmail())){
            /*throw new RuntimeException("El usuario " + userCredential.getEmail() + " ya existe");*/
            return "El usuario ya existe";
        }
        userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));

        userCredentialRepository.save(userCredential);
        return "Usuario registrado exitosamente";
    }

    public String generateToken(String username){
        return jwtService.generateToken(username);
    }

    public void validateToken(String token){
        jwtService.validateToken(token);
    }
    /*public String authUser(UserCredential userCredential){

    }*/
}
