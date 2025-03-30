/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.http;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase encargado de gestionar un objeto HTTP/JSON
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class WebObject extends HashMap<String, Object> {
    public WebObject() { }
    public WebObject(Map<String, Object> m) {
        super(m);
    }
}
