package gt.edu.umes.broker.broker.dto;

import java.util.List;

public class UserInfoDTO {
    private Long id;
    private String nombre;
    private String email;
    private List<String> roles;

    public UserInfoDTO(Long id, String nombre, String email, List<String> roles) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
