package gt.edu.umes.broker.broker.repository;

import gt.edu.umes.broker.broker.entity.UserCredential;

import java.util.Optional;

public interface UserCredentialRepositoryCustom {
    boolean existsByCorreo(String email);

    Optional<UserCredential> findByCorreo(String username);

}
