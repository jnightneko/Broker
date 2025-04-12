package gt.edu.umes.broker.broker.client;
import gt.edu.umes.broker.broker.dto.AuthRequest;
import gt.edu.umes.broker.broker.dto.EmpleadoRegistroDTO;
import gt.edu.umes.broker.broker.dto.EmpleadoResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "microservice-administracion", url = "http://localhost:5173/admin")
public interface AdministracionCliente {
    @PostMapping
    EmpleadoResponseDTO validarEmpleado(@RequestBody AuthRequest authRequest);

    @PostMapping("/usuarios/registrar")
    boolean registrarUsuario(@RequestBody EmpleadoRegistroDTO registroDTO);

    @GetMapping("/usuarios/por-email/{email}")
    EmpleadoResponseDTO obtenerUsuarioPorEmail(@PathVariable String email);

    @GetMapping("/usuarios/existe/{email}")
    boolean existeUsuario(@PathVariable String email);
}
