/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.http;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Clase encargado de gestionar una colección de datos HTTP/JSON
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class WebArray extends ArrayList<Object> {
    public WebArray() { }
    public WebArray(Collection<? extends Object> c) {
        super(c);
    }    
}
