package gt.edu.umes.broker.identity.client;
import gt.edu.umes.broker.identity.dto.AuthRequest;
import gt.edu.umes.broker.identity.dto.EmpleadoRegistroDTO;
import gt.edu.umes.broker.identity.dto.EmpleadoResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "microservice-connector", url = "http://localhost:5173/administracion")
public interface AuthAdminClient {
    @PostMapping("/empleados")
    EmpleadoResponseDTO validarEmpleado(@RequestBody AuthRequest authRequest);

    @PostMapping("/usuarios/registrar")
    boolean registrarUsuario(@RequestBody EmpleadoRegistroDTO registroDTO);

    @GetMapping("/usuarios/por-email/{email}")
    EmpleadoResponseDTO obtenerUsuarioPorEmail(@PathVariable String email);

    @GetMapping("/usuarios/existe/{email}")
    boolean existeUsuario(@PathVariable String email);
}
