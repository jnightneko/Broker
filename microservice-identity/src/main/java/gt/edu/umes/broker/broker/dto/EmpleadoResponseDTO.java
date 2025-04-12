package gt.edu.umes.broker.broker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoResponseDTO {
    private Long id;
    private String nombre;
    private String email;
    private List<String> roles;
    private String passwordEncriptada;
    private boolean activo;

    /*private boolean activo;*/

    public EmpleadoResponseDTO(Long id, String nombre, String email, List<String> roles, String passwordEncriptada, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.roles = roles;
        this.passwordEncriptada = passwordEncriptada;
        this.activo = activo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getPasswordEncriptada() {
        return passwordEncriptada;
    }

    public void setPasswordEncriptada(String passwordEncriptada) {
        this.passwordEncriptada = passwordEncriptada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
