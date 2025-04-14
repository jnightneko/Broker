/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.gateway.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clase encargada de modelar (abstraer) el objeto 'respueta' que proprociona el
 * servicio del broker cuando interactura con otros servicios (externos).
 * <pre><code>
 * { 
 *     “metadata”: { 
 *         “uri”: URL
 *     }, 
 *     “response”: { 
 *         “data”: {
 *             -- LA RESPUESTA QUE DEVUELVE EL BROKER --
 *         }
 *         “_broker_session_token”: “xgd29d”, -- TOKEN QUE EL BROKER GENERA (SÓLO SI ES UN INICIO DE SESIÓN) --
 *         “_broker_status”: 200,	 -- Estado de la petición, el mismo estándar que utiliza HTTP --
 *         “_broker_message”: “OK”   --Mensaje por parte del Bróker --
 *     } 
 * }
 * </code></pre>
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class BKResponseModel extends AbstractBKModel<Response> {
    
    /** Genera un nuevo objeto de la clase <code>BKResponseModel</code> */
    public BKResponseModel() {
        this(new MetaData(), new Response());
    }
    /**
     * Genera un nuevo objeto de la clase <code>BKResponseModel</code> 
     * @param metaData metadatos
     * @param response respueta
     */
    public BKResponseModel(MetaData metaData, Response response) {
        super(metaData, response);
    }

    /* (non-Javadoc)
     * @see AbstractBKModel#getBody() 
     */
    @Override
    @JsonProperty("response")
    public Response getBody() {
        return super.getBody();
    }
}
