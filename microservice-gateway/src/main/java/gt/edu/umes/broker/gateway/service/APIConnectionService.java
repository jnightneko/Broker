package gt.edu.umes.broker.gateway.service;

import gt.edu.umes.broker.gateway.model.dto.DTOObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public final class APIConnectionService {
    
    /**
     * Método encargado de enviar las peticiones a su destino atravez del microservicio <b>microservice-connector</b> que es el
     * encargado de mapear las diferentes rutas ({@code end-point}) de cada servicio externo.
     * <p>
     * Aquí es donde se tiene que hacer las validaciones de las peticiones, tanto para la integridad de ellos, así como para gestionar
     * las peticiones fraudulentas (en conjunto con los logs).
     * </p>
     * 
     * @param object objeto con la información de la conexión
     * @return datos devueltos.
     */
    public DTOObject send(DTOObject object) {
        RestTemplate connector = new RestTemplate();
        
        if (object == null) {
            return getNewError("No se puede procesar la petición. ", 501);
        }

        DTOObject metadata = object.getObject("metadata"),
                  request  = object.getObject("request");

        if (metadata == null) {
            return getNewError("La petición es inválida.", 422);
        }

        try {
            StringBuilder URLBuilder = new StringBuilder();
            ResponseEntity<DTOObject> res = connector.postForEntity(
                    String.valueOf(URLBuilder.append("http://localhost:8090")
                                             .append("/broker/__connection__/")
                                             .append(metadata.getString("uri"))), request, DTOObject.class);

            
            DTOObject response = getNewReponse(res.getBody(), metadata.getString("uri"));
            response.getObject("response")
                            .add("_broker_status", 200)
                            .add("_broker_message", "La solicitud tuvo éxito ;)!");
            return response;
        } catch (RestClientException e) {
            return getNewError(e.getMessage(), 404);
        }
    }
    
    private static DTOObject getNewReponse(DTOObject res, String uri) {
        return new DTOObject()
                    .add("metadata", new DTOObject().add("uri", uri))
                    .add("response", new DTOObject().add("data", res));
    }

    private static DTOObject getNewError(String msg, int code) {
        return new DTOObject().add("", code)
                              .add("", msg);
    }
}
