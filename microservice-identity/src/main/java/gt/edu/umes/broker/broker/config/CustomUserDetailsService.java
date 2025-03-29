package gt.edu.umes.broker.broker.config;

import gt.edu.umes.broker.broker.entity.UserCredential;
import gt.edu.umes.broker.broker.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    public UserCredentialRepository userCredentialRepository;

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException{
        Optional<UserCredential> credential = userCredentialRepository.findByEmail(email);
        return credential.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado" + email));
    }
}
