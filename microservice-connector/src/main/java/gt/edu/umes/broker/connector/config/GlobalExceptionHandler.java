/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.config;

import feign.FeignException;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.util.Optional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Clase encargada de gestionar la excepciones que puedan darse con los clientes, para ser
 * porcedade por un microservicio interno del broker.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.1
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(FeignException.class)
    public void handleFeignStatusException(FeignException e, HttpServletResponse response) {
        response.setStatus(e.status());
        if (e.hasRequest()) {
            try (PrintWriter writer = response.getWriter()) {
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                Optional<ByteBuffer> r = e.responseBody();
                if (r != null && r.isPresent()) {
                    StringBuilder buffer = new StringBuilder();
                    String read;

                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(r.get().array())))) {
                        while ((read = reader.readLine()) != null) {
                            buffer.append(read);
                        }
                        writer.print(String.valueOf(buffer));
                    }

                } else {
                    writer.print("{}");
                }
                writer.flush();
            } catch (IOException ex) {
                System.err.println("[ERROR] :" + ex.getMessage());
            }
        }
    }
}