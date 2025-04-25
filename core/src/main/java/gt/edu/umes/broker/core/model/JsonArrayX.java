/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.core.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Clase encargada de gestionar una lista JSON.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class JsonArrayX implements Iterable<Object> {
    
    public static JsonArrayX wrap() {
        return new JsonArrayX();
    }
    public static JsonArrayX wrap(Object object) {
        return new JsonArrayX(object);
    }

    private final List<Object> array;
    
    protected JsonArrayX() {
        this.array = new ArrayList<>();
    }
    
    protected JsonArrayX(Object object) {
        if (object instanceof List list) {
            this.array = list;
        } else {
            this.array = new ArrayList<>();
        }
    }
    
    protected JsonArrayX(List<Object> array) {
        this.array = array;
    }
    
    public JsonArrayX add(Object o) {
        array.add(o);
        return this;
    }
    
    public String getString(int i) {
        Object o = array.get(i);
        if (o == null) {
            return null;
        }
        return String.valueOf(o);
    }
    
    public JsonObjectX getObject(int i) {
        Object o = array.get(i);
        if (o instanceof Map) {
            return JsonObjectX.wrap(o);
        }
        if (o instanceof JsonObjectX ox) {
            return ox;
        }
        return null;
    }
    
    public JsonArrayX getArray(int i) {
        Object o = array.get(i);
        if (o instanceof List list) {
            return wrap(list);
        }
        if (o instanceof JsonArrayX ax) {
            return ax;
        }
        return null;
    }
    
    public List<Object> toList() {
        return array;
    }
    
    public int length() {
        return array.size();
    }
    
    @Override
    public Iterator<Object> iterator() {
        return array.iterator();
    }    
}
