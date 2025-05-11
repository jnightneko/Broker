package gt.edu.umes.broker.validation.config;

import gt.edu.umes.broker.validation.handler.SpringSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(socketHandler(), "/ws/arduino").setAllowedOrigins("*");

    }

    @Bean
    public SpringSocketHandler socketHandler() {
        return new SpringSocketHandler();
    }
}
