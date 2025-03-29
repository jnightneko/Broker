package gt.edu.umes.broker.broker.repository;

import gt.edu.umes.broker.broker.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialRepository extends JpaRepository<UserCredential, Long> {
    /*private String searchUsuario(String username){
         /*return
    }*/

    /*public String saveUser(UserCredential userCredential){

    }*/
    public
    boolean existsByEmail(String email);

    Optional<UserCredential> findByEmail(String username);
}
