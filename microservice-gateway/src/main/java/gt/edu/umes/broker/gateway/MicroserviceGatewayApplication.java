/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import static java.lang.System.setProperty;

/**
 * Clase principal del microservicios <strong>gateway</strong> encargado del
 * redireccionamiento de peticiones a los diferentes servicios internos del broker.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceGatewayApplication {
    
    /* global */
    static  {
        setProperty("msvc.connector.host",          "http://localhost:8090");
        setProperty("msvc.connector.host.endpoint", "/broker/__connection__/");
    }
    
    /**
     * Método principla donde se inicializa el microservicios
     * @param args argumentos de la linea de comandos.
     */
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceGatewayApplication.class, args);
    }
}
