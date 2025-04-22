package gt.edu.umes.broker.logs.services;

import gt.edu.umes.broker.logs.models.Sesion;
import gt.edu.umes.broker.logs.repository.SesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SesionService {

    @Autowired
    private SesionRepository sesionRepository;

    public List<Sesion> obtenerTodas() {
        return sesionRepository.findAll();
    }

    public Optional<Sesion> obtenerPorId(String id) {
        return sesionRepository.findById(id);
    }

    public List<Sesion> obtenerPorIdUsuario(String idU) {
        return sesionRepository.findByIdU(idU);
    }

    public Sesion crearOSobrescribirSesion(Sesion nuevaSesion) {
        List<Sesion> sesiones = sesionRepository.findByIdU(nuevaSesion.getIdU());

        if (!sesiones.isEmpty()) {
            // Solo debe existir una sesión por usuario
            Sesion existente = sesiones.get(0);
            existente.setEstadoSesion(nuevaSesion.getEstadoSesion());
            return sesionRepository.save(existente);
        }

        return sesionRepository.save(nuevaSesion);
    }

    public Sesion actualizarEstado(String id, Boolean nuevoEstado) {
        Optional<Sesion> sesionOpt = sesionRepository.findById(id);
        if (sesionOpt.isPresent()) {
            Sesion sesion = sesionOpt.get();
            sesion.setEstadoSesion(nuevoEstado);
            return sesionRepository.save(sesion);
        }
        return null;
    }

    public void eliminarSesion(String id) {
        sesionRepository.deleteById(id);
    }
}
