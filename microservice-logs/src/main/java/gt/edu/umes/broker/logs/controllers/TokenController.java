package gt.edu.umes.broker.logs.controllers;

import gt.edu.umes.broker.logs.models.Token;
import gt.edu.umes.broker.logs.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/activos/{rol}")
    public List<Token> obtenerActivoPorRol(@PathVariable String rol) {
        return tokenService.obtenerActivoPorRol(rol);
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

    @GetMapping("/logged-out/{token}")
    public boolean isTokenLoggedOut(@PathVariable String token){
        return tokenService.isTokenLoggedOut(token);
    }

    @PutMapping("/actualizar-estado/{token}")
    public ResponseEntity<Token> actualizarEstadoToken(@PathVariable String token, @RequestParam boolean loggedOut){
        Token tokenActualizado = tokenService.actualizarToken(token, loggedOut);

        if(tokenActualizado != null){
            return ResponseEntity.ok(tokenActualizado);
        }

        return ResponseEntity.notFound().build();
    }
}
