package gt.edu.umes.broker.identity.service;

import gt.edu.umes.broker.core.model.BKResponseModel;
import gt.edu.umes.broker.core.model.JsonArrayX;
import gt.edu.umes.broker.core.model.JsonObjectX;
import gt.edu.umes.broker.core.model.MetaData;
import gt.edu.umes.broker.core.model.Response;
import gt.edu.umes.broker.core.system.SFPBSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

import java.util.*;

@Service
public class AuthService {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private LogsService logService;


    public BKResponseModel authenticationUser(JsonObjectX authRequest) {
        JsonObjectX empleados = authRequest.getObject("userData");
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
        userData.put("userId", empleados.getLong("userId"));
        userData.put("nombre", empleados.getString("nombre"));
        userData.put("usuario", empleados.getString("usuario"));
        userData.put("Rol", Collections.singletonList(obtenerRol(empleados)));


        /*Para incluir los datos en data*/
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("success", true);
        responseData.put("message", "Inicio de sesión exitoso");
        responseData.put("userData", userData);

        JwtService.JwtToken token = jwtService.generateToken(
                empleados.getString("userId")
        );

        Response response = new Response();
        response.setToken(token.getToke());

        response.setData(responseData);
        response.setMessage("Acceso autorizado...");
        response.setStatus(HttpStatus.OK.value());
        
        guardarToken(token, empleados.getLong("userId"));
        return new BKResponseModel(new MetaData(), response);
    }
    
    private void guardarToken(JwtService.JwtToken token, Long userId) {
        JsonObjectX obj = JsonObjectX.wrap()
                                    .set("token", token.getToke())
                                    .set("fechaInicio", token.getIssuedAt())
                                    .set("fechaExpiracion", token.getExpirarion())
                                    .set("idU", userId);
        
        JsonArrayX sesiones = logService.obtenerSesionPorUsuario(userId);
        JsonObjectX sesionAbierta;
        if (sesiones != null && sesiones.length() > 0) {
            sesionAbierta = sesiones.getObject(0);
            logService.actualizarEstadoSesion(sesionAbierta.getString("id"), true);
        } else {
            sesionAbierta = JsonObjectX.wrap()
                                        .set("estadoSesion", true)
                                        .set("idU", userId);
            logService.crearSesion(sesionAbierta);
        }
        
        logService.saveToken(obj, null);
    }
    
    public void cerrarSesion(String token) {
        String id = SFPBSystem.extractUsername(SFPBSystem.extractBearerToken(token), (e) -> {
            System.out.println("[ERROR][TOKEN] :" + e.getMessage());
        });
        if (id == null) {
            return;
        }
        
        JsonArrayX tokens = logService.obtenerTokenUsuario(id);
        if (token == null || tokens.isEmpty()) {
            System.out.println("[DEBUG] :NO HAY TOKEN GUARDADO");
            return;
        }
        
        for (int i = 0; i < tokens.length(); i++) {
            JsonObjectX tk = tokens.getObject(i);
                        
            if (tk.getString("token").equals(SFPBSystem.extractBearerToken(token))) {
                tk.set("fechaExpiracion", tk.getDate("fechaInicio"));
                
                JsonArrayX sesiones = logService.obtenerSesionPorUsuario(tk.getLong("idU"));
                for (int l = 0; l < sesiones.length(); l++) {
                    JsonObjectX item = sesiones.getObject(l);
                    
                    if (item.getBoolean("estadoSesion")) {
                        logService.actualizarEstadoSesion(item.getString("id"), false);
                        break;
                    }
                }
                break;
            }
        }
    }

    private List<String> obtenerRol(JsonObjectX empleado) {
        if(empleado.toMap().containsKey("Rol")) {
            Object roles = empleado.toMap().get("Rol");

            if(roles instanceof List) {
                return (List<String>) roles;
            }
        }

        return Collections.singletonList("Usuario");
    }
}
