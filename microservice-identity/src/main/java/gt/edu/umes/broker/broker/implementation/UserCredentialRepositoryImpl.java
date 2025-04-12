package gt.edu.umes.broker.broker.implementation;

import gt.edu.umes.broker.broker.client.AdministracionCliente;
import gt.edu.umes.broker.broker.entity.UserCredential;
import gt.edu.umes.broker.broker.repository.UserCredentialRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserCredentialRepositoryImpl implements UserCredentialRepositoryCustom {
    @Autowired
    private AdministracionCliente administracionCliente;

    @Override
    public boolean existsByCorreo(String email) {
        return false;
    }

    @Override
    public Optional<UserCredential> findByCorreo(String username) {
        return Optional.empty();
    }
}
