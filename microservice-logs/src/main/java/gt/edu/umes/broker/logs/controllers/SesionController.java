package gt.edu.umes.broker.logs.controllers;

import gt.edu.umes.broker.logs.models.Sesion;
import gt.edu.umes.broker.logs.services.SesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sesiones")
public class SesionController {

    @Autowired
    private SesionService sesionService;

    @GetMapping
    public List<Sesion> obtenerTodas() {
        return sesionService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Optional<Sesion> obtenerPorId(@PathVariable String id) {
        return sesionService.obtenerPorId(id);
    }

    @GetMapping("/usuario/{idU}")
    public List<Sesion> obtenerPorUsuario(@PathVariable String idU) {
        return sesionService.obtenerPorIdUsuario(idU);
    }

    @PostMapping
    public Sesion crearSesion(@RequestBody Sesion sesion) {
        return sesionService.crearSesion(sesion);
    }

    @PutMapping("/{id}")
    public Sesion actualizarEstado(@PathVariable String id, @RequestBody Boolean nuevoEstado) {
        return sesionService.actualizarEstado(id, nuevoEstado);
    }

    @DeleteMapping("/{id}")
    public void eliminarSesion(@PathVariable String id) {
        sesionService.eliminarSesion(id);
    }
}
