/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.validation;

import gt.edu.umes.broker.core.Microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import static java.lang.System.setProperty;

/**
 * Clase principal del microservicio {@code microservice-validation}.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceValidationApplication {

    /* global */
    static  {
        setProperty("msvc.connector.host",          Microservice.INTERNAL_MICROSERVICE_CONNECTOR);
        setProperty("msvc.connector.host.endpoint", "/broker/__connection__/");
    }
    
    /**
     * Método principal encargada de gestionar las entradas y salidas del programas
     * @param args argumentos de la linea de comandos
     */
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceValidationApplication.class, args);
    }
}
