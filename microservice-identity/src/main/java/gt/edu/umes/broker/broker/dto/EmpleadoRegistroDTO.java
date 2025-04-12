package gt.edu.umes.broker.broker.dto;

import java.util.List;

public class EmpleadoRegistroDTO {
    private String email;
    private String contraseñaEncriptada;
    private String nombre;
    private List<String> roles;

    public EmpleadoRegistroDTO(String email, String contraseñaEncriptada, String nombre, List<String> roles) {
        this.email = email;
        this.contraseñaEncriptada = contraseñaEncriptada;
        this.nombre = nombre;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseñaEncriptada() {
        return contraseñaEncriptada;
    }

    public void setContraseñaEncriptada(String contraseñaEncriptada) {
        this.contraseñaEncriptada = contraseñaEncriptada;
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
