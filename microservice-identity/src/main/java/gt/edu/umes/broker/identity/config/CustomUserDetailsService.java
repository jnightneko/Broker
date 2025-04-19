package gt.edu.umes.broker.identity.config;

import gt.edu.umes.broker.identity.client.AuthAdminClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final AuthAdminClient authAdminClient;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomUserDetailsService(AuthAdminClient authAdminClient, PasswordEncoder passwordEncoder) {
        this.authAdminClient = authAdminClient;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return User.builder()
                .username("test")
                /*.password(empleado.getPasswordEncriptada())*/
                .authorities("ADMIN")
                .accountExpired(false)
                .credentialsExpired(false)
                .disabled(true)
                .build();
    }
}
