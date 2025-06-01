/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

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

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Collections.singletonList("*"));
        config.setAllowedOriginPatterns(Collections.singletonList("*"));
        config.setAllowPrivateNetwork(true);
        config.setAllowedHeaders(Collections.singletonList("*"));
        config.setAllowedMethods(Arrays.stream(HttpMethod.values()).map(HttpMethod::name).collect(Collectors.toList()));
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
