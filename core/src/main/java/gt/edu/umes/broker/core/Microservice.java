/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.core;

import java.net.InetSocketAddress;

/**
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Microservice {
    
    public static final String MICROSERVICE_ADMIN       = "http://localhost:3000/";
    public static final String MICROSERVICE_PAGOS       = "http://localhost:3001/";
    public static final String MICROSERVICE_GAS         = "http://localhost:3002/";
    public static final String MICROSERVICE_TIENDA      = "http://localhost:3003/";
    public static final String MICROSERVICE_REPUESTOS   = "http://localhost:4000/";
    public static final String MICROSERVICE_PINTURA     = "http://localhost:8000/";
    
    public static final String INTERNAL_MICROSERVICE_CONNECTOR = "http://localhost:8090";
    
    public static boolean bkAllowAddress(InetSocketAddress address) {
        String ipAddress = address.getAddress().getHostAddress();
        if (ipAddress.equals("0:0:0:0:0:0:0:1") || ipAddress.equals("127.0.0.1")) {
            ipAddress = address.getHostName();
        }
        
        return bkAllowAddress(ipAddress);
    }
    
    public static boolean bkAllowAddress(String address) {
        Server[] servers = Server.values();
        for (Server host : servers) {
            if (host == Server.Null) {
                continue;
            }
            if (host.getAddress().equals(address)) {
                return true;
            }
        }
        return false;
    }
}
