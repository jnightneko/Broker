/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clase encargado de modelar (asbtracción) de un objeto JSON utilizado por el broker
 * para gestionar las consultas entre servicios externo.
 * <p>
 * Objeto serializado:
 * <pre><code>
 * "metadata": {
 *     "uri": "myservice/methdo/path",
 *     "_broker_client_id": 1,
 *     "_broker_client_name": "client"
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
    
    /**  Id del cliente. */
    @JsonProperty("_broker_client_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String clientId;
    
    /** Nombre del cliente. */
    @JsonProperty("_broker_client_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String clientName;

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
     * Establece el id del cliente
     * @param clientId string
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * Establece el nombre del cliente
     * @param clientName string
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * Devuele la ruta de conexión del servicio externo.
     * @return string
     */
    public String getEndPoint() {
        return endPoint;
    }

    /**
     * Devuelve el id del cliente
     * @return string
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * Devuelve el nombre del cliente
     * @return string
     */
    public String getClientName() {
        return clientName;
    }
}
