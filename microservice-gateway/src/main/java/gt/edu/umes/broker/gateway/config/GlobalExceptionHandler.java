package gt.edu.umes.broker.gateway.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gt.edu.umes.broker.core.model.BKErrorResponseModel;

import java.nio.charset.Charset;

import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;

import reactor.core.publisher.Mono;

/**
 * @author wil
 */
@Component
@Order(-99)
public class GlobalExceptionHandler implements WebExceptionHandler {

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        ServerHttpResponse response = exchange.getResponse();
        HttpStatusCode status = determineHttpStatus(ex);
        
        response.setStatusCode(status);
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        
        BKErrorResponseModel model = new BKErrorResponseModel(ex.getMessage(), status.value());
        ObjectMapper mapper = new ObjectMapper();
        
        DataBuffer db;
        try {
            db = response.bufferFactory().wrap(mapper.writeValueAsString(model).getBytes(Charset.forName("UTF-8")));
        } catch (JsonProcessingException e) {
            db = response.bufferFactory().wrap(("Error en el servidor" + e.getMessage()).getBytes(Charset.forName("UTF-8")));
        }
        return response.writeWith(Mono.just(db));
    }

    private HttpStatusCode determineHttpStatus(Throwable throwable) {
        if (throwable instanceof ResponseStatusException) {
            return ((ResponseStatusException) throwable).getStatusCode();
        } else if (throwable instanceof RuntimeException) {
            return HttpStatus.UNAUTHORIZED;
        } else {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}