/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.core;

/**
 * Clase encargada de mapear una representación de los servicios externos utilizadas por
 * la organización en conjunto.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public enum Server {
    /** Administración */
    Admin(Microservice.MICROSERVICE_ADMIN),
    /** Pagos */
    Pagos(Microservice.MICROSERVICE_PAGOS),
    /** Gasolinea */
    Gas(Microservice.MICROSERVICE_GAS),
    /** Tienda de conveniencia */
    Tienda(Microservice.MICROSERVICE_TIENDA),
    /** Taller y repuestos */
    Repuestos(Microservice.MICROSERVICE_REPUESTOS),
    /** Pintura */
    Pintura(Microservice.MICROSERVICE_PINTURA),
    /** Valor predeterminado. */
    Null(null);
    
    /** La ip del servicios. */
    private final String address;
    /** Puerto de operación*/
    private final int port;
    
    /**
     * Contructor de la clase <code>Server</code>
     * @param url url de conexión
     */
    private Server(String url) {
        if (url == null) {
            this.address = "-";
            this.port    = 0;
        } else {
            if (url.startsWith("http")) {
                url = url.replaceAll("http:", "");
            }
            if (url.startsWith("https")) {
                url = url.replaceAll("https:", "");
            }
            String[] info = url.replaceAll("/", "").split(":");
            address = info[0];
            
            try {
                port = Integer.parseInt(info[1]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Error al obtener las direcciones IP: " + e.getMessage());
            }
        }
    }
    
    // Getters
    public String getAddress() {
        return address;
    }
    public int getPort() {
        return port;
    }
    @Override
    public String toString() {
        return address + ':' + port;
    }
}
