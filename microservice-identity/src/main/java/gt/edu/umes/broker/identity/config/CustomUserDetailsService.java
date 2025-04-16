package gt.edu.umes.broker.identity.config;

import gt.edu.umes.broker.identity.client.AdministracionCliente;
import gt.edu.umes.broker.identity.dto.EmpleadoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final AdministracionCliente administracionCliente;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomUserDetailsService(AdministracionCliente administracionCliente, PasswordEncoder passwordEncoder) {
        this.administracionCliente = administracionCliente;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EmpleadoResponseDTO empleado = administracionCliente.obtenerUsuarioPorEmail(username);

        if (empleado == null) {
            throw new UsernameNotFoundException(" Usuario " + username + " no encontrado");
        }

        return User.builder()
                .username(empleado.getEmail())
                .password(empleado.getPasswordEncriptada())
                .authorities(empleado.getRoles().toArray(new String[0]))
                .accountExpired(false)
                .credentialsExpired(false)
                .disabled(!empleado.isActivo())
                .build();
    }
}
