package gt.edu.umes.broker.logs.controllers;

import gt.edu.umes.broker.logs.models.Token;
import gt.edu.umes.broker.logs.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/broker/tokens")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @GetMapping
    public List<Token> obtenerTodos() {
        return tokenService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Token> obtenerPorId(@PathVariable String id) {
        return tokenService.obtenerPorId(id);
    }

    @GetMapping("/usuario/{idU}")
    public List<Token> obtenerPorUsuario(@PathVariable String idU) {
        return tokenService.obtenerPorIdUsuario(idU);
    }

    @GetMapping("/valor/{token}")
    public Optional<Token> obtenerPorToken(@PathVariable String token) {
        return tokenService.obtenerPorToken(token);
    }

    @PostMapping
    public Token guardarToken(@RequestBody Token token) {
        return tokenService.guardarToken(token);
    }

    @GetMapping("/validar/{token}")
    public boolean esTokenValido(@PathVariable String token) {
        return tokenService.esTokenValido(token);
    }

    @DeleteMapping("/{id}")
    public void eliminarToken(@PathVariable String id) {
        tokenService.eliminarToken(id);
    }
}
