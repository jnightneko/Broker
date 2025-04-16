package gt.edu.umes.broker.identity.repository;

import gt.edu.umes.broker.identity.entity.UserCredential;

import java.util.Optional;

public interface UserCredentialRepositoryCustom {
    boolean existsByCorreo(String email);

    Optional<UserCredential> findByCorreo(String username);

}
