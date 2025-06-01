/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.validation;

import gt.edu.umes.broker.core.Microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import static java.lang.System.setProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Clase principal del microservicio {@code microservice-validation}.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@EnableDiscoveryClient
@EnableFeignClients
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
        ConfigurableApplicationContext context = SpringApplication.run(MicroserviceValidationApplication.class, args);
        ConfigurableEnvironment env = context.getEnvironment();

        /* SETTERS */
        setProperty("msvc.connector.host", "http://" + env.getProperty("HOST_NAME_CONNECTOR") + ":8090");
        setProperty("broker.logs.debug",env.getProperty("broker.logs.debug"));
    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        config.setAllowedMethods(Arrays.stream(HttpMethod.values()).map(HttpMethod::name).collect(Collectors.toList()));
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
