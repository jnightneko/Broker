package gt.edu.umes.broker.logs.services;

import gt.edu.umes.broker.logs.models.Log;
import gt.edu.umes.broker.logs.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public List<Log> obtenerTodos() {
        return logRepository.findAll();
    }

    public Optional<Log> obtenerPorId(String id) {
        return logRepository.findById(id);
    }

    public List<Log> obtenerPorIdUsuario(String idU) {
        return logRepository.findByIdU(idU);
    }

    public List<Log> obtenerPorIdEstadoPeticion(String idEP) {
        return logRepository.findByIdEP(idEP);
    }

    public Log crearLog(Log log) {
        log.setFecha(new Date()); // establece fecha actual
        return logRepository.save(log);
    }

    public void eliminarLog(String id) {
        logRepository.deleteById(id);
    }
}
