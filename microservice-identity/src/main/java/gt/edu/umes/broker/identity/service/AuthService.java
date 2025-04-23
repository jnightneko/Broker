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

import java.util.*;

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
        JsonObjectDTO empleados = authRequest.getObjec("userData");
        if (empleados == null) {
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("message", "Credenciales invalidas");
            responseData.put("success", false);

            Response response = new Response();
            response.setData(responseData);
            response.setMessage("Credenciales invalidas");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());

            /*return new BKErrorResponseModel("No se puede procesar el usuario|empleado", HttpStatus.PROCESSING.value());*/
            return new BKResponseModel(new MetaData(), response);
        }

        Map<String, Object> userData = new HashMap<>();
        userData.put("userId", empleados.getLong("userId", 0L));
        userData.put("nombre", empleados.getString("nombre"));
        userData.put("usuario", empleados.getString("usuario"));
        userData.put("Rol", Collections.singletonList(obtenerRol(empleados)));


        /*Para incluir los datos en data*/
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("success", true);
        responseData.put("message", "Inicio de sesión exitoso");
        responseData.put("userData", userData);

        Response response = new Response();
        response.setToken(jwtService.generateToken(
                empleados.getString("userId")
        ));

        response.setData(responseData);
        response.setMessage("Acceso autorizado...");
        response.setStatus(HttpStatus.OK.value());
        return new BKResponseModel(new MetaData(), response);
    }

    public void validarToken(String token) {
        jwtService.validateToken(token);
    }

    private List<String> obtenerRol(JsonObjectDTO empleado) {
        if(empleado.toMap().containsKey("Rol")) {
            Object roles = empleado.toMap().get("Rol");

            if(roles instanceof List) {
                return (List<String>) roles;
            }
        }

        return Collections.singletonList("Usuario");
    }
}
