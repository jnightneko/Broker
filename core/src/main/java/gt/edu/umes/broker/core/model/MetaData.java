/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clase encargado de modelar (asbtracción) de un objeto JSON utilizado por el broker
 * para gestionar las consultas entre servicios externo.
 * <p>
 * Objeto serializado:
 * <pre><code>
 * "metadata": {
 *     "uri": "myservice/methdo/path"
 * }
 * </code></pre>
 * </p>
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class MetaData {
    
    /** La rura (endpoint) del servicios externo. */
    @JsonProperty("uri")
    private String endPoint;

    /** Genere un nuevo objeto <code>Metadata</code> */
    public MetaData() { }
    /**
     * Genere un nuevo objeto <code>Metadata</code>
     * @param endpoint ruta
     */
    public MetaData(String endpoint) {
        this.endPoint = endpoint;
    }

    /**
     * Devuele la ruta de conexión del servicio externo.
     * @return string
     */
    public String getEndPoint() {
        return endPoint;
    }
}
