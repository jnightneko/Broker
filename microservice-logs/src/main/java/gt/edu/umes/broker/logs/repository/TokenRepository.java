package gt.edu.umes.broker.logs.repository;

import gt.edu.umes.broker.logs.models.Token;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.Query;

public interface TokenRepository extends MongoRepository<Token, String> {
    @Query("""
    {$and: [
        {rolU: {$eq: ?0}},
        {loggedOut: {$eq: false}}
    ]}
    """)
    List<Token> findByRolToken(String rol);
    
    Optional<Token> findByToken(String token);
    List<Token> findByIdU(String idU);
}
