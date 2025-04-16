package gt.edu.umes.broker.identity.dto;

import java.util.List;

public class UserRegistrationRequestDTO {
    private String email;
    private String password;
    private String nombre;
    private List<String> roles;

    public UserRegistrationRequestDTO(String email, String password, String nombre, List<String> roles) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
