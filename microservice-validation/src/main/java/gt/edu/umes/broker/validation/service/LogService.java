/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.validation.service;

import gt.edu.umes.broker.core.model.EstadoPeticion;
import gt.edu.umes.broker.core.model.JsonObjectX;
import gt.edu.umes.broker.core.system.Configuration;
import gt.edu.umes.broker.validation.client.ClientLogs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase encargada de gestionar el servicio de los logs, este objeto es el encargado
 * de comunicarse con el microservicio correspondiente.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class LogService {
    /** Cliente de los logs. */
    @Autowired
    private ClientLogs clientLogs;
    
    /**
     * Busca el nombre de usuario en la base de datos del broker
     * 
     * @param id id
     * @return string
     */
    public String findUserName(String id) {
        Object object = clientLogs.obtenerPorId(id);
        if (object == null) {
            return null;
        }
        JsonObjectX userModel = JsonObjectX.wrap(object);
        return userModel.getString("nombreUsuario");
    }
    
    /**
     * Método encargado de comunicarse con el microservicios de <strong>logs</strong>
     * para almacenar dicho registro en la base de datos NOSQL.
     * 
     * @param msg mensaje|cuerpo de log
     * @param method método de la peticiión
     * @param endpoint endpoint
     * @param id id cliente
     * @param type tipo de log
     */
    public void log(String msg, String method, String endpoint, String id, EstadoPeticion type) {
        // mensaje a guardar en la DB
        String message = LogService.logFormatted(msg, method, type);
        if (Configuration.ENABLE_DEBUGGER_LOGS.get(false)) {
            clientLogs.crearLog(JsonObjectX.wrap()
                .set("descripcion", message)
                .set("fecha", new Date())
                .set("metodo", method)
                .set("endPoint", endpoint)
                .set("idU", id)
                .set("idEP", type.getUuid())
                .toMap()
            );
        } else {
            System.out.println("[ DEBUGGER ]" + message);
        }
    }
    
    /**
     * Método encargado de formatear el log a gestionar|almacenar.
     * 
     * @param msg mensaje en crudo
     * @param methdo método HTTP
     * @param type el tipo
     * @return string|log
     */
    public static String logFormatted(String msg, String methdo, EstadoPeticion type) {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        
        
        int len = methdo.length() % 2 == 0 ? methdo.length() : methdo.length() + 1;
        int offset = (10 - len) / 2;
        
        methdo =  String.format("%" + offset + "s", " ") 
                + String.format("%" + len    + "s", methdo) 
                + String.format("%" + offset + "s", " ");
        
        StringBuilder buffer= new StringBuilder();
        return String.valueOf(
                buffer.append('[').append(myDateObj.format(myFormatObj)).append(']')
                      .append('[').append(methdo).append("] :")
                      .append(" <").append(type).append("> ").append(msg));
    }

    public boolean isTokenLoggedOut(String token){
        try {
            return clientLogs.isTokenLoggedOut(token);
        } catch (Exception e){
            System.err.println("Error al verificar token: " + e.getMessage());
            return true;
        }
    }
}
