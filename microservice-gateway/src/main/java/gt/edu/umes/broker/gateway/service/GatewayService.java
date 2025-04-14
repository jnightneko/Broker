/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.gateway.service;


import gt.edu.umes.broker.gateway.Configuration;
import gt.edu.umes.broker.gateway.model.AbstractBKModel;
import gt.edu.umes.broker.gateway.model.BKResponseModel;
import gt.edu.umes.broker.gateway.model.MetaData;
import gt.edu.umes.broker.gateway.model.Response;
import static gt.edu.umes.broker.gateway.Gateway.*;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Clase servicio encargado de gestionar la conexión con el microservicios <strong>connector</strong> donde
 * se redireccionará la peticiona hacia un servicio externo.
 * 
 * @author wil
 * @version 1.0.0
 * @see 1.0.0
 */
@Service
public final class GatewayService {
    
    /**
     * Método encargado de enviar las peticiones a su destino atravez del microservicio 
     * <b>microservice-connector</b> que es el encargado de mapear las diferentes 
     * rutas ({@code end-point}) de cada servicio externo.
     * <p>
     * Aquí es donde se tiene que hacer las validaciones de las peticiones, tanto 
     * para la integridad de ellos, así como para gestionar las peticiones fraudulentas 
     * (en conjunto con los logs).
     * </p>
     * 
     * @param object objeto con la información de la conexión
     * @return datos devueltos.
     */
    public Object send(AbstractBKModel<Object> object) {
        if (object == null) {
            return bkNewError("No se puede procesar la petición.", 501);
        }
        
        if (! bkCheckRequest(object)) {
            return bkNewError("La petición es inválida (formato - broker).", 422);
        }
        MetaData metaData = object.getMetaData();
        try {
            StringBuilder URLBuilder = new StringBuilder();
            WebClient webClient = WebClient.create(Configuration.MSVC_CONNECTOR_HOST.get());
            
            Mono<ResponseEntity<Object>> mono =  webClient.post()
                    .uri(String.valueOf(
                            URLBuilder.append(Configuration.MSVC_CONNECTOT_PATH.get())
                                      .append(metaData.getEndPoint())))
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(object.getBody())
                    .retrieve()
                    .onStatus((t) -> t.is4xxClientError(), (t) ->  {
                        /* Guardar un log de una peticion fraudulenta. */
                        
                        return Mono.empty();
                    })
                    .onStatus((t) -> t.is5xxServerError(), (t) -> {
                        /* Guardar un long si hay un error con sel servidor destinatario (interno). */
                        
                        return Mono.empty();
                    })
                    .toEntity(Object.class);
            
            return mono.map((res) -> {
                Response bkResponse = new Response();                
                if (res.getStatusCode().is2xxSuccessful()) {
                    bkResponse.setData(res.getBody());
                    bkResponse.setMessage("La solicitud tuvo éxito ;)!");
                } else {
                    bkResponse.setMessage("Error de conexión con el servidor destino .(");
                }
                
                bkResponse.setStatus(res.getStatusCode().value());
                return new BKResponseModel(metaData, bkResponse);
            });
        } catch (Exception e) {
            return bkNewError(metaData, e.getMessage(), 404);
        }
    }
}
