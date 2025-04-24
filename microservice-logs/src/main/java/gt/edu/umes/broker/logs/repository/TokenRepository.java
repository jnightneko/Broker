package gt.edu.umes.broker.logs.repository;

import gt.edu.umes.broker.logs.models.Token;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends MongoRepository<Token, String> {
    Optional<Token> findByToken(String token);
    List<Token> findByIdU(String idU);
}
