package gt.edu.umes.broker.logs.repository;

import gt.edu.umes.broker.logs.models.Token;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends MongoRepository<Token, String> {
    Optional<Token> findByToken(String token);
    List<Token> findByIdU(String idU);

    /*nuevo metodo*/
    @Query("""
            { 'idU' : ?0, 'loggedOut': false }
            """)
    List<Token> findAllTokenByUser(String idU);
}
