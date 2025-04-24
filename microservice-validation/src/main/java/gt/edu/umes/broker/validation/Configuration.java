/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.validation;

import java.util.function.Function;

/**
 * Esta clase permite configurar programáticamente la configuración de ejecución 
 * del microservicio {@code Gateway}. Es una alternativa al uso de las propiedades
 * del sistema.
 * 
 * @param <T> el tipo de dato
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class Configuration<T> {
    
    /** 
     * El host/dirección (ip) interna del microservicios <strong>connector/</strong> encargado del
     * redireccionamieto de la peticiosnes hacia los servicios externiios solicitado a travéz de gateway. 
     */
    public static final Configuration<String> MSVC_CONNECTOR_HOST = new Configuration<>("msvc.connector.host", StateInit.STRING);
    
    /** El endpoint/ruta del microservicios de redireccionamiento. */
    public static final Configuration<String> MSVC_CONNECTOT_PATH = new Configuration<>("msvc.connector.host.endpoint", StateInit.STRING);
    
    private interface StateInit<T> extends Function<String, T> {
        StateInit<Boolean> BOOLEAN = property -> {
            String value = System.getProperty(property);
            return value == null ? null : Boolean.parseBoolean(value);
        };

        StateInit<Integer> INT = Integer::getInteger;

        StateInit<String> STRING = System::getProperty;
    }

    private final String property;

    private volatile T state;

    Configuration(String property, StateInit<? extends T> init) {
        this.property = property;
        this.state = init.apply(property);
    }

    /**
     * Devuelve la propiedad de la configuración
     * 
     * @return la propiedad
     */
    public String getProperty() {
        return property;
    }

    /**
     * Establece el valor de la opción.
     *
     * @param value el valor a establecer
     */
    public void set(T value) {
        this.state = value;
    }

    /**
     * Devuelve el valor de la opción.
     *
     * <p>Si no se ha establecido el valor de la opción, se devolverá nulo.</p>
     * @return valor-opción
     */
    public T get() {
        return state;
    }

    /**
     * Devuelve el valor de la opción.
     *
     * <p>Si no se ha establecido el valor de la opción, se devolverá el valor 
     * predeterminado especificado.</p>
     *
     * @param defaultValue el valor predeterminado
     * @return valor-opción
     */
    public T get(T defaultValue) {
        T nstate = this.state;
        if (nstate == null) {
            nstate = defaultValue;
        }
        return nstate;
    }
}
