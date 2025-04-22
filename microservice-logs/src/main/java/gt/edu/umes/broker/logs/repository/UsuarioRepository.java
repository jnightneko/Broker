package gt.edu.umes.broker.logs.repository;

import gt.edu.umes.broker.logs.models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    //agregar métodos personalizados si se necesiatn
}
