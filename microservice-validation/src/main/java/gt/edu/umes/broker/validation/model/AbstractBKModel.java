/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.validation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clase abstracta encargado de generar la plantilla de las respuetas, así como
 * el objeto requerido por el broker cuando se interactura con los servicios
 * externo.
 * 
 *  @param <T> tipo de dato
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class AbstractBKModel<T> {
    
    /** Objeto donde se alojan los metadatos. */
    @JsonProperty("metadata")
    private MetaData metaData;
    
    /** Cuerpo de la petición requerida por el broker*/
    private T body;
    
    /**
     * Genera un nuevo objeto de la clase <code>AbstractBKModel</code>
     * @param metaData el objeto
     * @param body el cuerpo
     */
    public AbstractBKModel(MetaData metaData, T body) {
        this.metaData = metaData;
        this.body = body;
    }

    /**
     * Devuelve los metadatos de la petición
     * @return objeto
     */
    public MetaData getMetaData() {
        return metaData;
    }

    /**
     * Establece los metadatos de la petición
     * @param metaData objeto
     */
    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    /**
     * Establece el cuerpo de la respueta.
     * @param body el cuerpo
     */
    public void setBody(T body) {
        this.body = body;
    }

    /**
     * Devuelve el cuerpo de la respuetas
     * @return el cuerpo
     */
    public T getBody() {
        return body;
    }
}
