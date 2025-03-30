package gt.edu.umes.broker.gateway.model.dto;

import java.util.HashMap;
import java.util.Map;

public class DTOObject extends HashMap<String, Object> {
    public DTOObject() {}
    public DTOObject(Map<? extends String, ?> m) {
        super(m);
    }

    public DTOObject add(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public  DTOObject getObject(String key) {
        Object o = get(key);
        if (o instanceof DTOObject dto) {
            return dto;
        }
        if (o instanceof Map dto) {
            return new DTOObject(dto);
        }
        return null;
    }

    public String getString(String key) {
        Object o = get(key);
        if (o instanceof String str) {
            return str;
        }
        return String.valueOf(o);
    }
}
