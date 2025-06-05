package gt.edu.umes.broker.validation.handler;

import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpringSocketHandler extends TextWebSocketHandler {

    private static final List<WebSocketSession> sessions = new ArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session);
        System.out.println(" Cliente conectado: " + session.getId());
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        System.out.println(" Mensaje recibido del cliente: " + message.getPayload());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessions.remove(session);
        System.out.println("Cliente desconectado: " + session.getId());
    }

    /**
     * Enviar un comando a todos los clientes conectados
     */
    public void enviarComando(String comando) {
        for (WebSocketSession session : sessions) {
            try {
                session.sendMessage(new TextMessage(comando));
                System.out.println("Comando enviado: " + comando);
            } catch (IOException e) {
                System.err.println("Error enviando comando: " + e.getMessage());
            }
        }
    }
}
