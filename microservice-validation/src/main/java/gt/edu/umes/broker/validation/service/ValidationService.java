/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.validation.service;

import gt.edu.umes.broker.validation.model.AbstractBKModel;
import gt.edu.umes.broker.validation.model.MetaData;
import static gt.edu.umes.broker.validation.Validation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase encargada de validar las peticiones para finalmente realizar las redirecciones
 * de peticiones a sus respectivos destinos.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class ValidationService {
    /** Servicios de logs. */
    @Autowired
    private LogService logService;
    
    /**
     * Método encargado de validar el cuerpo de la petición, esta validación depende
     * a que servicios este destinado.
     * 
     * @param model objeto recibido
     * @param logs oyente de logs
     * @return boolean
     */
    public boolean isValid(AbstractBKModel<Object> model, LogListener<AbstractBKModel<Object>, Object> logs) {
        if (model == null || model.getMetaData() == null) {
            logs.log(logService, model, "Error al procesar los datos, verifique el protocolo de comunicación con SFPB", true);
            return false;
        }
        
        if (! bkCheckRequest(model)) {
            logs.log(logService, model, "Violación de redireccionamiento [" 
                    + model.getMetaData().getEndPoint() 
                    + "], verifique el protocolo de comunicación con SFPB "
                    + ">> https://github.com/jnightneko/Broker/blob/master/assets/docs/PROTOCOLO.md ", true);
            return false;
        }
        if (isServicePagos(model.getMetaData())) {
            /* validación de pagos */
        }
        
        logs.log(logService, model, "Petición solicitada: " + model.getMetaData().getEndPoint(), false);
        return true;
    }
    
    /**
     * Determina si el destinos es para el servicio externo de pagos.
     * 
     * @param data los meta datos
     * @return boolean
     */
    public boolean isServicePagos(MetaData data) {
        String uri = data.getEndPoint().toLowerCase();
        return uri.startsWith("/PAGOS") || uri.startsWith("PAGOS");
    }
}
