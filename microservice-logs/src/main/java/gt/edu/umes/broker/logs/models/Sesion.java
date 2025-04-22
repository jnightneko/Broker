package gt.edu.umes.broker.logs.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Sesion")
public class Sesion {

    @Id
    private String id; // MongoDB _id

    private Boolean estadoSesion;
    private String idU; // _id de Usuario

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
}
