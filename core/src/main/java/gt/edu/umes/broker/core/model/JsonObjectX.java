/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.core.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase encargada de gestionar un objeto JSON.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class JsonObjectX {
    
    public static final JsonObjectX wrap() {
        return new JsonObjectX();
    }
    public static final JsonObjectX wrap(Object object) {
        if (object == null) {
            return null;
        }
        return new JsonObjectX(object);
    }
    
    private final Map<String, Object> map;

    protected JsonObjectX() {
        this(new HashMap<>());
    }
    protected JsonObjectX(Object object) {
        if (object instanceof Map toMap) {
            this.map = toMap;
        } else {
            this.map = new HashMap<>();
        }        
    }
    protected JsonObjectX(Map<String, Object> map) {
        this.map = map;
    }
    
    public JsonObjectX set(String key, Object value) {
        map.put(key, value);
        return this;
    }
    
    public String getString(String key) {
        Object object = map.get(key);
        if (object == null) {
            return null;
        }
        return String.valueOf(object);
    }
    
    public Integer getInteger(String key) {
        try {
            return Integer.valueOf(getString(key));
        } catch (NumberFormatException e) {
            return null;
        }
    }
    
    public Long getLong(String key) {
        try {
            return Long.valueOf(getString(key));
        } catch (NumberFormatException e) {
            return null;
        }
    }
    
    public Boolean getBoolean(String key) {
        return Boolean.valueOf(getString(key));
    }
    
    public Date getDate(String key) {
        Object o = map.get(key);
        if (o == null) {
            return null;
        }
        
        if (o instanceof Date date) {
            return date;
        }
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.parse(String.valueOf(o));
        } catch (ParseException e) {
            return null;
        }
    }
    
    public JsonObjectX getObject(String i) {
        Object o = map.get(i);
        if (o instanceof Map) {
            return wrap(o);
        }
        if (o instanceof JsonObjectX ox) {
            return ox;
        }
        return null;
    }
    
    public JsonArrayX getArray(String i) {
        Object o = map.get(i);
        if (o instanceof List list) {
            return JsonArrayX.wrap(list);
        }
        if (o instanceof JsonArrayX ax) {
            return ax;
        }
        return null;
    }
    
    public Map<String, Object> toMap() {
        return map;
    }
}
