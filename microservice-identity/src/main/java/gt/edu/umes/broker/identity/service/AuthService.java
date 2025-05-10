package gt.edu.umes.broker.identity.service;

import com.google.common.hash.Hashing;
import gt.edu.umes.broker.core.model.BKResponseModel;
import gt.edu.umes.broker.core.model.JsonArrayX;
import gt.edu.umes.broker.core.model.JsonObjectX;
import gt.edu.umes.broker.core.model.MetaData;
import gt.edu.umes.broker.core.model.Response;
import gt.edu.umes.broker.core.system.SFPBSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

import java.nio.charset.StandardCharsets;
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

            return new BKResponseModel(new MetaData(), response);
        }

        String userId = empleados.getString("userId");
        if (userId == null || userId.isEmpty()) {
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("message", "ID de usuario no proporcionado");
            responseData.put("success", false);

            Response response = new Response();
            response.setData(responseData);
            response.setMessage("ID de usuario no proporcionado");
            response.setStatus(HttpStatus.BAD_REQUEST.value());

            return new BKResponseModel(new MetaData(), response);
        }

        // Lógica para invalidar tokens previos
        JsonArrayX tokensActivos = logService.obtenerTokenUsuario(userId);
        if (tokensActivos != null && tokensActivos.length() > 0) {
            for (int i = 0; i < tokensActivos.length(); i++) {
                JsonObjectX token = tokensActivos.getObject(i);
                if (token != null) {
                    Boolean loggedOut = token.getBoolean("loggedOut");
                    if (loggedOut == null || !loggedOut) {
                        token.set("loggedOut", true);
                        token.set("updatedAt", new Date());
                        logService.saveToken(token, null);
                    }
                }
            }
        }

        Map<String, Object> userData = new HashMap<>();
        userData.put("userId", userId);
        userData.put("nombre", empleados.getString("nombre"));
        userData.put("usuario", empleados.getString("usuario"));
        userData.put("Rol", Collections.singletonList(obtenerRol(empleados)));

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("success", true);
        responseData.put("message", "Inicio de sesión exitoso");
        responseData.put("userData", userData);

        JwtService.JwtToken token = jwtService.generateToken(userId);

        Response response = new Response();
        response.setToken(token.getToke());
        response.setData(responseData);
        response.setMessage("Acceso autorizado...");
        response.setStatus(HttpStatus.OK.value());
        
        guardarToken(token, empleados.getLong("userId"));
        return new BKResponseModel(new MetaData(), response);
    }
    
    private void guardarToken(JwtService.JwtToken token, Long userId) {
        try {
            String hashToken = Hashing.sha256().hashString(token.getToke(), StandardCharsets.UTF_8).toString();

            JsonObjectX obj = JsonObjectX.wrap()
                    .set("token", hashToken)
                    .set("fechaInicio", token.getIssuedAt())
                    .set("fechaExpiracion", token.getExpirarion())
                    .set("idU", userId)
                    .set("loggedOut", false);

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
        } catch (Exception e){
            throw new RuntimeException("Error al encriptar el token", e);
        }
    }

    public void cerrarSesion(String token) {
        String id = SFPBSystem.extractUsername(SFPBSystem.extractBearerToken(token), (e) -> {
            System.out.println("[ERROR][TOKEN]: " + e.getMessage());
        });

        if(id == null){
            return;
        }

        JsonArrayX tokens = logService.obtenerTokenUsuario(id);
        if(token == null || tokens.isEmpty()){
            System.out.println("[DEBUG] :NO HAY TOKEN GUARDADO");
            return;
        }

        for (int i = 0; i < tokens.length(); i++){
            JsonObjectX tk = tokens.getObject(i);

            if(tk.getString("token").equals(SFPBSystem.extractBearerToken(token))){
                tk.set("fechaExpiracion", tk.getDate("fechaInicio"))
                        .set("loggedOut", true);

                logService.saveToken(tk, tk.getString("id"));

                JsonArrayX sesiones = logService.obtenerSesionPorUsuario(tk.getLong("idU"));
                for (int l = 0; l < sesiones.length(); i++){
                    JsonObjectX item = sesiones.getObject(l);

                    if(item.getBoolean("estadoSesion")) {
                        logService.actualizarEstadoSesion(item.getString("id"), false);
                        break;
                    }
                    break;
                }
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
