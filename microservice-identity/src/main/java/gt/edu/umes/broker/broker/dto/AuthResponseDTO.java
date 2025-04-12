package gt.edu.umes.broker.broker.dto;

import java.util.List;

public class AuthResponseDTO {
    private String token;
    private Long userId;
    private String nombre;
    private String email;
    private List<String> roles;

    public AuthResponseDTO(String token, Long userId, String nombre, String email, List<String> roles) {
        this.token = token;
        this.userId = userId;
        this.nombre = nombre;
        this.email = email;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
