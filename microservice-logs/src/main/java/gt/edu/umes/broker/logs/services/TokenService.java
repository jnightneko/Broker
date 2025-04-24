package gt.edu.umes.broker.logs.services;

import gt.edu.umes.broker.logs.models.Token;
import gt.edu.umes.broker.logs.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        // puedes agregar aquí validaciones extra si deseas controlar duplicados
        return tokenRepository.save(nuevoToken);
    }

    public void eliminarToken(String id) {
        tokenRepository.deleteById(id);
    }

    public boolean esTokenValido(String token) {
        Optional<Token> tokenOpt = tokenRepository.findByToken(token);
        if (tokenOpt.isPresent()) {
            Token t = tokenOpt.get();
            return t.getFechaExpiracion().after(new Date());
        }
        return false;
    }
}
