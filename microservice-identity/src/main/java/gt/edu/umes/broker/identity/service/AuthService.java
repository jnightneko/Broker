package gt.edu.umes.broker.identity.service;

import gt.edu.umes.broker.core.model.BKErrorResponseModel;
import gt.edu.umes.broker.core.model.BKResponseModel;
import gt.edu.umes.broker.core.model.MetaData;
import gt.edu.umes.broker.core.model.Response;
import gt.edu.umes.broker.identity.client.AuthAdminClient;
import gt.edu.umes.broker.identity.dto.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.http.HttpStatus;

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

    public BKResponseModel authenticationUser(JsonObjectDTO authRequest) {
        JsonObjectDTO empleados = authRequest.getObjec("empleado");
        if (empleados == null) {
            return new BKErrorResponseModel("No se puede procesar el usuario|empleado", HttpStatus.PROCESSING.value());
        }
        Response response = new Response();
        response.setToken(jwtService.generateToken(
                empleados.getString("nombres"), 
                empleados.getLong("dpi", 0L)
        ));
        
        response.setMessage("Acceso autorizado...");
        response.setStatus(HttpStatus.OK.value());
        return new BKResponseModel(new MetaData(), response);
    }

    public void validarToken(String token) {
        jwtService.validateToken(token);
    }
}
