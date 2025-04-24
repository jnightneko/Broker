/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.validation.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    
    /** Tipo de log (depende de los tipos manejados) */
    public static enum Type {
        ERROR,
        LOG
    }
    
    /**
     * Método encargado de comunicarse con el microservicios de <strong>logs</strong>
     * para almacenar dicho registro en la base de datos NOSQL.
     * 
     * @param msg mensaje|cuerpo de log
     * @param method método de la peticiión
     * @param type tipo de log
     */
    public void log(String msg, String method, Type type) {
        // mensaje a guardar en la DB
        String logMessage = LogService.logFormatted(msg, method);
        
        System.err.println(logMessage + " |=" + type);
    }
    
    /**
     * Método encargado de formatear el log a gestionar|almacenar.
     * 
     * @param msg mensaje en crudo
     * @param methdo método HTTP
     * @return string|log
     */
    public static String logFormatted(String msg, String methdo) {
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
                      .append(msg));
    }
}
