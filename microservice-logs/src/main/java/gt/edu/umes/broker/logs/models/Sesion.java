package gt.edu.umes.broker.logs.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Sesion")
public class Sesion {

    @Id
    private String id; // MongoDB _id

    private Boolean estadoSesion;
    private String idU; // _id de Usuario

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    public Sesion() {}

    public Sesion(Boolean estadoSesion, String idU) {
        this.estadoSesion = estadoSesion;
        this.idU = idU;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getEstadoSesion() {
        return estadoSesion;
    }

    public void setEstadoSesion(Boolean estadoSesion) {
        this.estadoSesion = estadoSesion;
    }

    public String getIdU() {
        return idU;
    }

    public void setIdU(String idU) {
        this.idU = idU;
    }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
}
