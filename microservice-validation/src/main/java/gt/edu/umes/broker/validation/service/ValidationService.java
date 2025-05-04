/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.validation.service;

import gt.edu.umes.broker.core.endpoints.MCSVPagos;
import gt.edu.umes.broker.core.model.AbstractBKModel;
import gt.edu.umes.broker.core.model.MetaData;
import gt.edu.umes.broker.core.model.BKRequestModel;
import gt.edu.umes.broker.core.model.BKResponseModel;
import gt.edu.umes.broker.core.model.EstadoPeticion;
import gt.edu.umes.broker.core.model.Response;
import static gt.edu.umes.broker.validation.Validation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase encargada de validar las peticiones para finalmente realizar las redirecciones
 * de peticiones a sus respectivos destinos.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class ValidationService {
    /** Servicios de logs. */
    @Autowired
    private LogService logService;
    /** Microservicio de conexión (redireccionamiento)*/
    @Autowired
    private ConnectorService connectorService;

    @Autowired
    private ArduinoSocketSender arduinoSocketSender;


    /**
     * Método encargado de validar el cuerpo de la petición, esta validación depende
     * a que servicios este destinado.
     * 
     * @param model objeto recibido
     * @param logs oyente de logs
     * @return boolean
     */
    public boolean isValid(AbstractBKModel<Object> model, LogListener<AbstractBKModel<Object>, Object> logs) {
        if (model == null || model.getMetaData() == null) {
            logs.log(logService, model, "Error al procesar los datos, verifique el protocolo de comunicación con SFPB", EstadoPeticion.Rechazada);
            arduinoSocketSender.notificar("RECHAZADA");
            return false;
        }
        
        if (! bkCheckRequest(model)) {
            logs.log(logService, model, "Violación de redireccionamiento [" 
                    + model.getMetaData().getEndPoint() 
                    + "], verifique el protocolo de comunicación con SFPB "
                    + ">> https://github.com/jnightneko/Broker/blob/master/assets/docs/PROTOCOLO.md ", EstadoPeticion.Rechazada);
            arduinoSocketSender.notificar("RECHAZADA");
            return false;
        }
        
        // validación de métodos de pagos a travez de sus ID's
        if (isServicePagos(model.getMetaData())) {            
            if (isCrearTransaccion(model.getMetaData())) {
                Map<String, Object> map = (Map<String, Object>) model.getBody();
                List<Object> metosPagos = (List<Object>) map.get("MetodosPago");

                boolean metodoNoValido = true;
                List<Map<String, Object>> metosValidos = getListMetodoPago();
                
                for (int i = 0; i < metosPagos.size(); i++) {
                    Map<String, Object> item = (Map<String, Object>) metosPagos.get(i);

                    for (int j = 0; j < metosValidos.size(); j++) {
                        Map<String, Object> element = metosValidos.get(j);                        
                        if (String.valueOf(item.get("IdMetodo")).equals(String.valueOf(element.get("idMetodo")))) {
                            metodoNoValido = false;
                            break;
                        }
                    }
                }

                if (metodoNoValido) {
                    logs.log(logService, model, "Métodos de pagos inválidos: " + model.getMetaData().getEndPoint() + ":" + metosPagos, EstadoPeticion.Rechazada);
                    arduinoSocketSender.notificar("RECHAZADA");
                    return false;
                }
            }
        }
        
        logs.log(logService, model, "Petición solicitada: " + model.getMetaData().getEndPoint(), EstadoPeticion.Aprobada);
        arduinoSocketSender.notificar("VALIDA");
        return true;
    }
    
    /**
     * Determin si la petición (endpoint) es para realizar una transacción
     * 
     * @param metaData metadatos
     * @return boolean
     */
    public boolean isCrearTransaccion(MetaData metaData) {
        String uri = metaData.getEndPoint();
        if (! uri.startsWith("/")) {
            uri = '/' + uri;
        }
        if (uri.endsWith("/")) {
            uri = uri.substring(0, uri.length() - 1);
        }
        return uri.toLowerCase().equals(MCSVPagos.PAGOS_TRANSACCION_CREAR);
    }
    
    /**
     * Lista todo los métodos de pagos soportados por el servicios
     * @return list|pagos
     */
    public List<Map<String, Object>> getListMetodoPago() {
        BKRequestModel request = new BKRequestModel(new MetaData(MCSVPagos.PAGOS_METODO_OBTENER), BKRequestModel.EMPTY_BODY);
        Object htttObject = connectorService.send(request);
        logService.log("Obtención de pagos", "GET", "BROKER", null, EstadoPeticion.Aprobada);
        
        if (htttObject instanceof BKResponseModel responseModel) {
            Response response = responseModel.getBody();
            
            if (response.getData() instanceof List myArray) {
                if (!myArray.isEmpty() && (myArray.get(0) instanceof Map)) {
                    return myArray;
                }
            }
        }
        return new ArrayList<>();
    }
    
    /**
     * Determina si el destinos es para el servicio externo de pagos.
     * 
     * @param data los meta datos
     * @return boolean
     */
    public boolean isServicePagos(MetaData data) {
        String uri = data.getEndPoint().toUpperCase();
        return uri.startsWith("/PAGOS") || uri.startsWith("PAGOS");
    }
}
