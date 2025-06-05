package gt.edu.umes.broker.validation.service;

import gt.edu.umes.broker.validation.handler.SpringSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceHardware {

    @Autowired
    private SpringSocketHandler socketHandler;

    /** Envía un comando a través del WebSocket */
    public void enviarComando(String comando) {
        socketHandler.enviarComando(comando);
    }
}
