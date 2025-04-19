package gt.edu.umes.broker.identity.controller;

import gt.edu.umes.broker.core.model.BKErrorResponseModel;
import gt.edu.umes.broker.core.model.BKRequestModel;
import gt.edu.umes.broker.core.model.BKResponseModel;
import gt.edu.umes.broker.identity.client.AuthAdminClient;
import gt.edu.umes.broker.identity.dto.JsonObjectDTO;
import gt.edu.umes.broker.identity.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/broker")
public class AuthController {
    
    private final AuthService authService;
    private final AuthAdminClient authAdminClient;

    @Autowired
    public AuthController(
        AuthService authService,
        AuthAdminClient authAdminClient
    ) {
        this.authService = authService;
        this.authAdminClient = authAdminClient;
    }

    @PostMapping("/POST/registrar")
    public ResponseEntity<BKResponseModel> registerUser(@RequestBody BKRequestModel request) {
        return ResponseEntity.status(200)
                                 .body(new BKErrorResponseModel("Funcionalidad no implementada", 200));
    }
    
    @PostMapping("/POST/autenticacion")
    public ResponseEntity<BKResponseModel> getToken(@RequestBody BKRequestModel authRequest) {
        if (authRequest == null) {
            return ResponseEntity.status(402)
                                 .body(new BKErrorResponseModel("Formato inválido", 402));
        }
        
        Object object = authAdminClient.validarEmpleado(authRequest.getBody());
        JsonObjectDTO webObject = new JsonObjectDTO(object).block();
        if (webObject == null) {
            return ResponseEntity.status(402)
                                 .body(new BKErrorResponseModel("Credencias inválidas o usuario inactivo", 402));
        }
        
        BKResponseModel response = authService.authenticationUser(webObject);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/POST/salir")
    public ResponseEntity<BKResponseModel> logOutUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        
        System.out.println("log: token >> " + token);
        return ResponseEntity.status(200)
                                 .body(new BKErrorResponseModel("Funcionalidad no implementada", 200));
    }
}
