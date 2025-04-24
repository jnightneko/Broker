/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.validation;

import gt.edu.umes.broker.core.model.AbstractBKModel;
import gt.edu.umes.broker.core.model.BKErrorResponseModel;
import gt.edu.umes.broker.core.model.MetaData;

/**
 * Clase encargado de proptocionar método utilizada para el redireccionamento de las peticiones
 * solicitada la broker.
 * s
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Validation {
    
    /**
     * Genera un mensaje (JSON) de error por incumplimiento de formato al solicitar un redireccionamiento
     * al broker.
     * 
     * @param msg mensaje de error
     * @param code estado del error
     * @return JSON
     */
    public static BKErrorResponseModel bkNewError(String msg, int code) { return bkNewError(null, msg, code); }
    
    /**
     * Genera un mensaje (JSON) de error por incumplimiento de formato al solicitar un redireccionamiento
     * al broker.
     * 
     * @param metaData metadatos
     * @param msg mensaje de error
     * @param code estado del error
     * @return JSON
     */
    public static BKErrorResponseModel bkNewError(MetaData metaData, String msg, int code) {
        assert msg != null || code < 0;
        BKErrorResponseModel error = new BKErrorResponseModel(msg, code);
        error.setMetaData(metaData);
        return error;
    }
    
    /**
     * Verifica si el objeto recibido por parte del cliente es correcta.
     * 
     * @param model objeto web
     * @return estado|boolean
     */
    public static boolean bkCheckRequest(AbstractBKModel<Object> model) {
        if (model == null) {
            return false;
        }
        
        MetaData data = model.getMetaData();
        if (data == null || (data.getEndPoint() == null || data.getEndPoint().isEmpty())) {
            return false;
        }
        return true;
    }
}
