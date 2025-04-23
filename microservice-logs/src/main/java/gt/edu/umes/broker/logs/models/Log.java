package gt.edu.umes.broker.logs.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Log")
public class Log {

    @Id
    private String id;

    private String descripcion;
    private Date fecha;
    private String metodo;
    private String endPoint;

    private String idU;  //_id de Usuario
    private String idEP; //_id de estadoPeticion

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    public Log() {}

    public Log(String descripcion, Date fecha, String metodo, String endPoint, String idU, String idEP) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.metodo = metodo;
        this.endPoint = endPoint;
        this.idU = idU;
        this.idEP = idEP;
    }

    // Getters y setters
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Date getFecha() { return fecha; }

    public void setFecha(Date fecha) { this.fecha = fecha; }

    public String getMetodo() { return metodo; }

    public void setMetodo(String metodo) { this.metodo = metodo; }

    public String getEndPoint() { return endPoint; }

    public void setEndPoint(String endPoint) { this.endPoint = endPoint; }

    public String getIdU() { return idU; }

    public void setIdU(String idU) { this.idU = idU; }

    public String getIdEP() { return idEP; }

    public void setIdEP(String idEP) { this.idEP = idEP; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
}
