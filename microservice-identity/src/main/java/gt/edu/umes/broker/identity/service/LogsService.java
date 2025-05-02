/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.identity.service;

import gt.edu.umes.broker.core.model.JsonArrayX;
import gt.edu.umes.broker.core.model.JsonObjectX;
import gt.edu.umes.broker.identity.client.ClientLogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wil
 */
@Service
public class LogsService {
    
    @Autowired
    private ClientLogs clientLogs;
    
    public void checkUser(JsonObjectX object) {
        JsonObjectX userData = object.getObject("userData");
        if (userData == null) {
            return;
        }        
        Long id        = userData.getLong("userId");
        String usuario = userData.getString("usuario");        
        if (id == null) {
            return;
        }
        
        JsonObjectX saveUser = JsonObjectX.wrap(clientLogs.obtenerUsuarioPorId(Long.toString(id)));
        if (saveUser == null) {            
            saveUser = JsonObjectX.wrap();
            saveUser.set("id", id)
                    .set("nombreUsuario", usuario)
                    .set("estado", true)
                    .set("servicio", "frontend");
            
            clientLogs.crearUsuario(saveUser.toMap());
        } else {
            String strUser = saveUser.getString("nombreUsuario");
            if ((strUser == null && usuario != null) || (strUser != null && !strUser.equals(usuario))) {
               saveUser.set("nombreUsuario", usuario);
               clientLogs.crearUsuario(saveUser.toMap());
            }
        }
    }
    
    public void saveToken(JsonObjectX object, Object session) {
        clientLogs.guardarToken(object.toMap());
    }
    
    public JsonArrayX obtenerSesionPorUsuario(Long idUsuario) {
        return JsonArrayX.wrap(clientLogs.obtenerSesionPorUsuario(String.valueOf(idUsuario)));
    }
    
    public JsonObjectX crearSesion(JsonObjectX sesion) {
        return JsonObjectX.wrap(clientLogs.crearSesion(sesion.toMap()));
    }
    
    public JsonObjectX actualizarEstadoSesion(String id, boolean nuevoEstado) {
        return JsonObjectX.wrap(clientLogs.actualizarEstadoSesion(id, nuevoEstado));
    }
    
    public JsonArrayX obtenerTokenUsuario(String id) {
        return JsonArrayX.wrap(clientLogs.obtenerTokenPorUsuario(id));
    }
}
