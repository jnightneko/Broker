package gt.edu.umes.broker.logs.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Usuario")
public class Usuario {

    @Id
    private String id; // MongoDB genera este ID automáticamente

    private String nombreUsuario;
    private Boolean estado;
    private String servicio;

    public Usuario() {}

    public Usuario(String nombreUsuario, Boolean estado, String servicio) {
        this.nombreUsuario = nombreUsuario;
        this.estado = estado;
        this.servicio = servicio;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
}
