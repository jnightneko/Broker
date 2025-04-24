package gt.edu.umes.broker.logs.repository;

import gt.edu.umes.broker.logs.models.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LogRepository extends MongoRepository<Log, String> {
    List<Log> findByIdU(String idU);
    List<Log> findByIdEP(String idEP);
}
