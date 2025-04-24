package gt.edu.umes.broker.logs.controllers;

import gt.edu.umes.broker.logs.models.Log;
import gt.edu.umes.broker.logs.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/broker/logs")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping
    public List<Log> obtenerTodos() {
        return logService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Log> obtenerPorId(@PathVariable String id) {
        return logService.obtenerPorId(id);
    }

    @GetMapping("/usuario/{idU}")
    public List<Log> obtenerPorUsuario(@PathVariable String idU) {
        return logService.obtenerPorIdUsuario(idU);
    }

    @GetMapping("/estado/{idEP}")
    public List<Log> obtenerPorEstado(@PathVariable String idEP) {
        return logService.obtenerPorIdEstadoPeticion(idEP);
    }

    @PostMapping
    public Log crearLog(@RequestBody Log log) {
        return logService.crearLog(log);
    }

    @DeleteMapping("/{id}")
    public void eliminarLog(@PathVariable String id) {
        logService.eliminarLog(id);
    }
}
