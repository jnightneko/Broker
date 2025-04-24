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

    public Sesion crearSesion(Sesion sesion) {
        //cierre de cualquier sesión activa existente del mismo usuario
        List<Sesion> sesionesExistentes = sesionRepository.findByIdU(sesion.getIdU());
        for (Sesion s : sesionesExistentes) {
            if (Boolean.TRUE.equals(s.getEstadoSesion())) {
                s.setEstadoSesion(false);
                sesionRepository.save(s);
            }
        }

        return sesionRepository.save(sesion);
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
