/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.identity.service;

import gt.edu.umes.broker.core.model.JsonArrayX;
import gt.edu.umes.broker.core.model.JsonObjectX;
import gt.edu.umes.broker.core.system.SFPBSystem;
import gt.edu.umes.broker.identity.client.ClientLogs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wil
 */
@Service
public class LogsService {
    public static final Logger logger = LoggerFactory.getLogger(LogsService.class);

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
    
    public JsonArrayX obtenerTokenActivoPorRol(String rol) {
        return JsonArrayX.wrap(clientLogs.obtenerTokenActivoPorRol(rol));
    }

    private String extractUserIdFromToken(String token) {
        if (token == null || token.isEmpty()) {
            return null;
        }

        try {
            String[] parts = token.split("\\.");
            if (parts.length != 3) {
                logger.debug("Token no tiene formato JWT válido");
                return null;
            }

            // Decodificar payload
            String payload = new String(
                    Base64.getUrlDecoder().decode(parts[1]),
                    StandardCharsets.UTF_8
            );

            logger.debug("Payload decodificado: {}", payload);

            // Buscar el userId en el payload
            int subIndex = payload.indexOf("\"sub\":");
            if (subIndex < 0) {
                logger.debug("Campo 'sub' no encontrado en el payload");
                return null;
            }

            int start = payload.indexOf("\"", subIndex + 6) + 1;
            int end = payload.indexOf("\"", start);

            if (start < 0 || end < 0) {
                logger.debug("Formato del campo 'sub' inválido");
                return null;
            }

            return payload.substring(start, end);
        } catch (IllegalArgumentException e) {
            logger.warn("Error decodificando Base64Url: {}", e.getMessage());
            return null;
        } catch (Exception e) {
            logger.warn("Error procesando token: {}", e.getMessage());
            return null;
        }
    }
}
