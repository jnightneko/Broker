/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.identity.dto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wil
 */
public final class JsonObjectDTO {

    private static final Logger LOGGER = Logger.getLogger(JsonObjectDTO.class.getName());
    
    private Map<String, Object> object;

    public JsonObjectDTO() {
        this(new HashMap<>());
    }
    public JsonObjectDTO(Object object) {
        if (object instanceof Map map) {
            this.object = map;
        } else {
            LOGGER.log(Level.WARNING, "No se puede convertir el objeto {0} en un mapa JSON", object);
        }
    }
    public JsonObjectDTO(Map<String, Object> object) {
        this.object = object;
    }
    
    public JsonObjectDTO block() {
        if (object == null) {
            return null;
        }
        return this;
    }
    
    public Map<String, Object> toMap() {
        return Collections.unmodifiableMap(object);
    }
    
    public JsonObjectDTO put(String key, Object value) {
        object.put(key, value);
        return this;
    }
    
    public String getString(String key) {
        return String.valueOf(object.get(key));
    }
    
    public JsonObjectDTO getObjec(String key) {
        return new JsonObjectDTO(object.get(key)).block();
    }
    
    public int getInt(String key, int def) {
        try {
            return Integer.parseInt(getString(key));
        } catch (NumberFormatException e) {
            return def;
        }
    }
    
    public long getLong(String key, long def) {
        try {
            return Long.parseLong(getString(key));
        } catch (NumberFormatException e) {
            return def;
        }
    }
}
