/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.core.model;

/**
 * Clase encargado de modelar un mensaje de error.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class BKErrorResponseModel extends BKResponseModel {

    /**
     * Genera un objeto de la clase <code>BKErrorResponseModel</code>.
     * 
     * @param mesg mensaje de error
     * @param status estado del erro (protocolo HTTP)
     */
    public BKErrorResponseModel(String mesg, int status) {
        Response response = getBody();
        response.setMessage(mesg);
        response.setStatus(status);
    }
}
