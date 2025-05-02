/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.config;

import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase encargada de gestionar el clinete de {@code feing} para dar soporte a todos
 * los métodos HTTP.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration 
public class FeignConfiguration {
    /**
     * Devuelve el cliente OkHtpp
     * @return cliente http
     */
    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    } 
}