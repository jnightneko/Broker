package gt.edu.umes.broker.logs.services;

import gt.edu.umes.broker.logs.models.Token;
import gt.edu.umes.broker.logs.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    public List<Token> obtenerTodos() {
        return tokenRepository.findAll();
    }

    public Optional<Token> obtenerPorId(String id) {
        return tokenRepository.findById(id);
    }

    public Optional<Token> obtenerPorToken(String token) {
        return tokenRepository.findByToken(token);
    }

    public List<Token> obtenerPorIdUsuario(String idU) {
        return tokenRepository.findByIdU(idU);
    }

    public Token guardarToken(Token nuevoToken) {
        // Buscar tokens activos del mismo usuario
        List<Token> tokensUsuario = tokenRepository.findByIdU(nuevoToken.getIdU());

        for (Token token : tokensUsuario) {
            if (Boolean.TRUE.equals(token.getEstado())) {
                token.setEstado(false);
                tokenRepository.save(token);
            }
        }

        // Guardar el nuevo token como activo
        nuevoToken.setEstado(true);
        return tokenRepository.save(nuevoToken);
    }

    public Token actualizarEstado(String id, Boolean nuevoEstado) {
        Optional<Token> optToken = tokenRepository.findById(id);
        if (optToken.isPresent()) {
            Token tokenExistente = optToken.get();
            tokenExistente.setEstado(nuevoEstado);
            return tokenRepository.save(tokenExistente);
        }
        return null;
    }

    public void eliminarToken(String id) {
        tokenRepository.deleteById(id);
    }
}
