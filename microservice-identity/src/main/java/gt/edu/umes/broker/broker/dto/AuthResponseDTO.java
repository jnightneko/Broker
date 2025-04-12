package gt.edu.umes.broker.broker.dto;

import java.util.List;

public class AuthResponseDTO {
    private String broker_session_token;
    private Long userId;
    private String nombre;
    private String email;
    private List<String> roles;

    public AuthResponseDTO(String broker_session_token, Long userId, String nombre, String email, List<String> roles) {
        this.broker_session_token = broker_session_token;
        this.userId = userId;
        this.nombre = nombre;
        this.email = email;
        this.roles = roles;
    }

    public String getBroker_session_token() {
        return broker_session_token;
    }

    public void setBroker_session_token(String broker_session_token) {
        this.broker_session_token = broker_session_token;
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
