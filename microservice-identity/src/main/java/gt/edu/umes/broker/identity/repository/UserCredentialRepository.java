package gt.edu.umes.broker.identity.repository;

import gt.edu.umes.broker.identity.entity.UserCredential;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialRepository extends UserCredentialRepositoryCustom {
    /*private String searchUsuario(String username){
         /*return
    }*/

    /*public String saveUser(UserCredential userCredential){

    }*/
    public
    boolean existsByCorreo(String email);

    Optional<UserCredential> findByCorreo(String username);
}
