package gt.edu.umes.broker.identity.dto;

import java.util.List;

public class AuthResponseDTO {
    private String brokerSessionToken;
    private Long userId;
    private String nombre;
    private String email;
    private List<String> roles;

    public AuthResponseDTO(String brokerSessionToken, Long userId, String nombre, String email, List<String> roles) {
        this.brokerSessionToken = brokerSessionToken;
        this.userId = userId;
        this.nombre = nombre;
        this.email = email;
        this.roles = roles;
    }

    public String getBrokerSessionToken() {
        return brokerSessionToken;
    }

    public void setBrokerSessionToken(String brokerSessionToken) {
        this.brokerSessionToken = brokerSessionToken;
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
