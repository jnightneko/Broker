package gt.edu.umes.broker.logs.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Token")
public class Token {

    @Id
    private String id;

    private String token;
    private Date fechaInicio;
    private Date fechaExpiracion;
    private String idU; // _id del usuario
    private String rolU; // rol del usuario
    
    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    private boolean loggedOut;

    public Token() {}

    public Token(String id, String token, Date fechaInicio, Date fechaExpiracion, String idU, Date createdAt, Date updatedAt, boolean loggedOut) {
        this.id = id;
        this.token = token;
        this.fechaInicio = fechaInicio;
        this.fechaExpiracion = fechaExpiracion;
        this.idU = idU;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.loggedOut = loggedOut;
    }

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public String getIdU() { return idU; }
    public void setIdU(String idU) { this.idU = idU; }

    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    public Date getFechaExpiracion() { return fechaExpiracion; }
    public void setFechaExpiracion(Date fechaExpiracion) { this.fechaExpiracion = fechaExpiracion; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }

    public String getRolU() {
        return rolU;
    }

    public void setRolU(String rolU) {
        this.rolU = rolU;
    }

    public boolean isLoggedOut() {
        return loggedOut;
    }

    public void setLoggedOut(boolean loggedOut) {
        this.loggedOut = loggedOut;
    }
}
