package gt.edu.umes.broker.identity.service;

import com.google.common.hash.Hashing;
import gt.edu.umes.broker.core.model.BKErrorResponseModel;
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

        JsonArrayX roles = JsonArrayX.wrap(obtenerRol(empleados));
        
        Map<String, Object> userData = new HashMap<>();
        userData.put("userId", userId);
        userData.put("nombre", empleados.getString("nombre"));
        userData.put("usuario", empleados.getString("usuario"));
        userData.put("Rol", roles);

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("success", true);
        responseData.put("message", "Inicio de sesión exitoso");
        responseData.put("userData", userData);

        // Limitar los usuarios a 3 logueados, especialmente a los usuarios de
        // tienda o vehiculos
        boolean limitar = false;
        String miRol = null;
        if (roles != null) {
            for (Object e : roles) {
                JsonObjectX element = JsonObjectX.wrap(e);
                String idRol = String.valueOf(element.get("id_rol"));
                
                JsonArrayX activosRol = logService.obtenerTokenActivoPorRol(idRol);
                
                if (activosRol != null && activosRol.length() > 3 && esRolTiendaVehiculo(activosRol)) {
                    limitar = true;
                    break;
                }
            }
            
            if (! roles.isEmpty()) {
                miRol = String.valueOf(roles.getObject(0).get("id_rol"));
            }
        }
        
        if (limitar) {
            return new BKErrorResponseModel("No puede haber más de 3 usuarios logueados con el mismo rol", HttpStatus.UNAUTHORIZED.value());
        }
        
        JwtService.JwtToken token = jwtService.generateToken(userId);

        Response response = new Response();
        response.setToken(token.getToke());
        response.setData(responseData);
        response.setMessage("Acceso autorizado...");
        response.setStatus(HttpStatus.OK.value());
        
        
        guardarToken(token, empleados.getLong("userId"), miRol);
        return new BKResponseModel(new MetaData(), response);
    }
    
    private boolean esRolTiendaVehiculo(JsonArrayX o) {
        if (o == null) {
            return false;
        }
        for (int i = 0; i < o.length(); i++) {
            JsonObjectX or = o.getObject(i);
            if (or == null) 
                continue;
            
            String rol = String.valueOf(or.getString("rol")).toLowerCase();
            if (rol.contains("tienda") || rol.contains("vehiculo")) {
                return true;
            }
        }
        return false;
    }
    
    private void guardarToken(JwtService.JwtToken token, Long userId, String rol) {
        try {
            String hashToken = Hashing.sha256().hashString(token.getToke(), StandardCharsets.UTF_8).toString();

            JsonObjectX obj = JsonObjectX.wrap()
                    .set("token", hashToken)
                    .set("fechaInicio", token.getIssuedAt())
                    .set("fechaExpiracion", token.getExpirarion())
                    .set("idU", userId)
                    .set("loggedOut", false)
                    .set("rolU", rol);

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
        String extracToken = SFPBSystem.extractBearerToken(token);

        String hashToken = Hashing.sha256().hashString(extracToken, StandardCharsets.UTF_8).toString();

        String id = SFPBSystem.extractUsername(SFPBSystem.extractBearerToken(token), (e) -> {
            System.out.println("[ERROR][TOKEN]: " + e.getMessage());
        });

        if(id == null){
            return;
        }

        JsonArrayX tokens = logService.obtenerTokenUsuario(id);
        if(tokens == null || tokens.isEmpty()){
            System.out.println("[DEBUG] :NO HAY TOKEN GUARDADO");
            return;
        }

        for (int i = 0; i < tokens.length(); i++){
            JsonObjectX tk = tokens.getObject(i);

            if(tk.getString("token").equals(hashToken)){
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

    private List<Object> obtenerRol(JsonObjectX empleado) {
        if(empleado.toMap().containsKey("Rol")) {
            Object roles = empleado.toMap().get("Rol");

            if(roles instanceof List) {
                return (List<Object>) roles;
            }
        }

        return Collections.singletonList("Usuario");
    }
}
