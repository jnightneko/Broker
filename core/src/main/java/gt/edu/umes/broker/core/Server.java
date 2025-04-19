/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.core;

/**
 *
 * @author wil
 */
public enum Server {
    
    Admin(Microservice.MICROSERVICE_ADMIN),
    Pagos(Microservice.MICROSERVICE_PAGOS),
    Gas(Microservice.MICROSERVICE_GAS),
    Tienda(Microservice.MICROSERVICE_TIENDA),
    Repuestos(Microservice.MICROSERVICE_REPUESTOS),
    Pintura(Microservice.MICROSERVICE_PINTURA),
    Null(null);
    
    private final String address;
    private final int port;
    
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
