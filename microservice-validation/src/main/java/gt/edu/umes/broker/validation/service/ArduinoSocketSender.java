package gt.edu.umes.broker.validation.service;

import gt.edu.umes.broker.validation.client.FastSocketClient;
import org.springframework.stereotype.Service;

import java.net.URI;

/** Servicio que se conecta al puerto donde escucha el websocket y envia el comando a python segun sea valida o rechazada
  la petición **/
@Service
public class ArduinoSocketSender {
    public void notificar(String comando) {
        try {
            URI uri = new URI("ws://localhost:8765"); // cambiar a ngrok cuando ya este en produccion
            FastSocketClient client = new FastSocketClient(uri);
            client.connectBlocking();
            client.send(comando); // VALIDA O RECHAZADA
            client.close();
        } catch (Exception e) {
            System.err.println("No se pudo comunicar con Arduino: " + e.getMessage());
        }
    }
}
