/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Clase principal del microservicios <strong>connector</strong> encargado del
 * redireccionamiento de peticiones a los diferentes servicios (destinos).
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceConnectorApplication {
    /**
     * Método principla donde se inicializa el microservicios
     * @param args argumentos de la linea de comandos.
     */
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConnectorApplication.class, args);
    }
}
