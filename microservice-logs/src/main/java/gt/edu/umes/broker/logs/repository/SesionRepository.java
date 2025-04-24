package gt.edu.umes.broker.logs.repository;

import gt.edu.umes.broker.logs.models.Sesion;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SesionRepository extends MongoRepository<Sesion, String> {
    List<Sesion> findByIdU(String idU);
}
