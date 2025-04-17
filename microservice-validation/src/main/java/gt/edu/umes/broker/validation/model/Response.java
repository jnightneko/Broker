/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.validation.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Optional;

/**
 * Clase encargado de modelar (asbtracción) de un objeto JSON utilizado por el broker
 * para gestionar las consultas entre servicios externo.
 * <p>
 * Objeto serializado:
 * <pre><code>
 * "response": {
 *     "data": {
 *         ...
 *     },
 *     “_broker_session_token”: “xgd29d”,
 *     “_broker_status”: 200,
 *     “_broker_message”: “OK”
 * }
 * </code></pre>
 * </p>
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Response {

    /** El objeto resultado de la petición (respueta del servicio externo) */
    @JsonProperty("data")
    private Object data;
    /** Estado de la petición (dependiente del broker ). */
    @JsonProperty("_broker_status")
    private int status;
    /** Mensage o respueta por pare del servicios del broler. */
    @JsonProperty("_broker_message")
    private String message;

    /**
     * El toker que se genera para las sesiones de usuarios, esta propiedad es
     * opcional en la respueta del broker y solo es utilizada cuando se hace una
     * autenticación.
     */
    @JsonProperty( "_broker_session_token")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Optional<String> token;

    /**
     * Genere un nuevo objeto <code>Response</code> 
     */
    public Response() {
    }

    // Setters
    /*(non-Javadoc) */public void setData(Object data)        { this.data = data; }
    /*(non-Javadoc) */public void setStatus(int status)       { this.status = status; }
    /*(non-Javadoc) */public void setMessage(String message)  { this.message = message; }
    /*(non-Javadoc) */public void setToken(String token)      { this.token = Optional.of(token); }

    // Getters
    /*(non-Javadoc) */public Object getData() { return data; }
    /*(non-Javadoc) */public int getStatus() { return status; }
    /*(non-Javadoc) */public String getMessage() { return message; }
    /*(non-Javadoc) */public Optional<String> getToken() { return token; }
}
