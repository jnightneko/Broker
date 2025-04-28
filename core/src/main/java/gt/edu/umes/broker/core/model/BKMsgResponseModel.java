/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.core.model;

/**
 * Clase encargado de modelar un mensaje
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class BKMsgResponseModel extends BKResponseModel{
    public static BKMsgResponseModel bkMessage(String msg) {
        return new BKMsgResponseModel(msg);
    }
    
    /**
     * Genera un objeto de la clase <code>BKMsgResponseModel</code>.
     * 
     * @param mesg mensaje de error
     */
    public BKMsgResponseModel(String mesg) {
        Response response = getBody();
        response.setMessage(mesg);
        response.setStatus(200);
    }
}
