/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.core;

import java.net.InetSocketAddress;

/**
 * Clase encargada de mapear las direcciones (IP|hostname) de los servicios externos utilizadas
 * por la organización.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Microservice {
    //**************************************************************************************************************
    //** SERVICIOS EXTERBOS UTIIZADAS POR LA ORGANIZACIÓN
    //
    /** Direcciones pública del servicios: administración. */
    public static final String MICROSERVICE_ADMIN       = "http://64.23.169.22:3000/";
    /** Direcciones pública del servicios: pagos. */
    public static final String MICROSERVICE_PAGOS       = "http://localhost:3001/";
    /** Direcciones pública del servicios: gasolinera. */
    public static final String MICROSERVICE_GAS         = "http://64.23.169.22:3002/";
    /** Direcciones pública del servicios: tineda de conveniencia. */
    public static final String MICROSERVICE_TIENDA      = "http://64.23.169.22:3003/";
    /** Direcciones pública del servicios: teller y repuestos. */
    public static final String MICROSERVICE_REPUESTOS   = "http://64.23.169.22:4000/";
    /** Direcciones pública del servicios: taller y pintutra. */
    public static final String MICROSERVICE_PINTURA     = "http://64.23.169.22:8000/";
    
    //**************************************************************************************************************
    //** SERVICIOS INTERNOS DEL BROKER
    //    
    /** Microservicio conector. */
    public static final String INTERNAL_MICROSERVICE_CONNECTOR = "http://${HOST_NAME_CONNECTOR}:8090";
    /** Microservicio de logs. */
    public static final String INTERNAL_MICROSERVICE_LOGS      = "http://${HOST_NAME_LOGS}:8095";
    
    /**
     * Determina si una ip es válida o bien es conocido y es de confinza para permitirle
     * el acceso al broker.
     * 
     * @param address dirección ip
     * @return boolean
     */
    public static boolean bkAllowAddress(InetSocketAddress address) {
        String ipAddress = address.getAddress().getHostAddress();
        if (ipAddress.equals("0:0:0:0:0:0:0:1") || ipAddress.equals("127.0.0.1")) {
            ipAddress = address.getHostName();
        }
        
        return bkAllowAddress(ipAddress);
    }
    
    /**
     * Determina si una ip es válida o bien es conocido y es de confinza para permitirle
     * el acceso al broker.
     * 
     * @param address dirección ip
     * @return boolean
     */
    public static boolean bkAllowAddress(String address) {
        Server[] servers = Server.values();
        for (Server host : servers) {
            //if (host == Server.Null) {
            //    continue;
            //}
            if (host.getAddress().equals(address)) {
                return true;
            }
        }
        return false;
    }
}
