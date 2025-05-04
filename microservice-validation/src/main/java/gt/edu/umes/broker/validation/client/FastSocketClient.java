package gt.edu.umes.broker.validation.client;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
/** Cliente que valida la conexion con el servidor websocket de py y envia el mensaje de valido o rechazado**/
public class FastSocketClient extends WebSocketClient {

    public FastSocketClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake handshake) {
        System.out.println("Conectado al servidor WebSocket");
    }

    @Override
    public void onMessage(String message) {
        System.out.println("📩 Mensaje del servidor: " + message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("Desconectado del servidor WebSocket");
    }

    @Override
    public void onError(Exception ex) {
        System.err.println("Error en WebSocket: " + ex.getMessage());
    }
}
