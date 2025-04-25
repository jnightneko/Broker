/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.core.model;

/**
 * Clase encargada de modelar los estados de las diferentes peticiones.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public enum EstadoPeticion {
    /** Aceptación */
    Aprobada("6806fa1d8cd3df899438f9a9"),
    /** Error. */
    Rechazada("6806fa288cd3df899438f9ab"),
    /** Error en ejecución */
    Pendiente("6806fa368cd3df899438f9ad");
    
    /** UUID dek estado. */
    private final String uuid;

    /**
     * Constructor de la clase <coede>EstadoPeticion</code
     * @param uuid string
     */
    private EstadoPeticion(String uuid) {
        this.uuid = uuid;
    }

    /**
     * Devuelve del UUIID
     * @return string
     */
    public String getUuid() {
        return uuid;
    }
}
