package gt.edu.umes.broker.logs.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Token")
public class Token {

    @Id
    private String id;

    private String token;
    private Boolean estado;
    private String idU; // _id del usuario

    public Token() {}

    public Token(String token, Boolean estado, String idU) {
        this.token = token;
        this.estado = estado;
        this.idU = idU;
    }

    // Getters y setters
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getToken() { return token; }

    public void setToken(String token) { this.token = token; }

    public Boolean getEstado() { return estado; }

    public void setEstado(Boolean estado) { this.estado = estado; }

    public String getIdU() { return idU; }

    public void setIdU(String idU) { this.idU = idU; }
}
