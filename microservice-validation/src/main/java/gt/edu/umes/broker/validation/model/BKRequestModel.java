/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.validation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clase encargada de modelar (abstraer) el objeto 'respueta' que proprociona el
 * servicio del broker cuando interactura con otros servicios (externos).
 * <pre><code>
 * { 
 *     “metadata”: { 
 *         “uri”: URL
 *     }, 
 *     “reques”: { 
 *         -- TODO LO QUE SE ENVÍA AL SERVICIO A COMUNICARSE (CUERPO --
 *     } 
 * }
 * </code></pre>
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class BKRequestModel extends AbstractBKModel<Object> {
    
    /** Genera un nuevo objeto de la clase <code>BKRequestModel</code> */
    public BKRequestModel() {
        this(new MetaData(), null);
    }
    /**
     * Genera un nuevo objeto de la clase <code>BKRequestModel</code>
     * @param metaData los metadatos
     * @param body el cuerpo
     */
    public BKRequestModel(MetaData metaData, Object body) {
        super(metaData, body);
    }

    /* (non-Javadoc)
     * @see AbstractBKModel#getBody() 
     */
    @Override
    @JsonProperty("request")
    public Object getBody() {
        return super.getBody();
    }
}
