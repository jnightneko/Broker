/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.validation.controller;

import gt.edu.umes.broker.validation.model.AbstractBKModel;
import gt.edu.umes.broker.validation.model.BKRequestModel;
import gt.edu.umes.broker.validation.service.ConnectorService;
import gt.edu.umes.broker.validation.service.LogService;
import gt.edu.umes.broker.validation.service.ValidationService;
import static gt.edu.umes.broker.validation.Validation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Clase encargada de controlar las peticiones HTTP para las validaciones de cada
 * petición hacia los servicios externos de la organización.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/broker/api/rest")
public final class ValidationController {
    @Autowired
    private ConnectorService service;
    @Autowired
    private ValidationService valService;
    
    private String error = null;
    private Object requestAll(BKRequestModel model, final String method) {        
        if (valService.isValid(model, (LogService logs, AbstractBKModel<Object> request, String msg, boolean err) -> {
            if (err) {
                error = "El servicio no puede ser prestado en este momento.";
            }
            logs.log(msg, method, LogService.Type.ERROR);
        }));
        if (error == null) {
            return service.send(model);
        } else {
            Object res = bkNewError(error, 422);
            error = null;
            return res;
        }
    }

    /**
     * Petición por el método {@code GET} con el formtado estandar.
     * 
     * @param object objeto web
     * @return respueta
     */
    @GetMapping
    public Object requestGET(@RequestBody BKRequestModel object) {
        return requestAll(object, "GET");
    }

    /**
     * Petición por el método {@code POST} con el formtado estandar.
     * 
     * @param object objeto web
     * @return respueta
     */
    @PostMapping
    public Object requestPOST(@RequestBody BKRequestModel object) {
        return requestAll(object, "POST");
    }

    /**
     * Petición por el método {@code PUT} con el formtado estandar.
     * 
     * @param object objeto web
     * @return respueta
     */
    @PutMapping
    public Object requestPUT(@RequestBody BKRequestModel object) {
        return requestAll(object, "PUT");
    }

    /**
     * Petición por el método {@code PATH} con el formtado estandar.
     * 
     * @param object objeto web
     * @return respueta
     */
    @PatchMapping
    public Object requestPATCH(@RequestBody BKRequestModel object) {
        return requestAll(object, "PATCH");
    }

    /**
     * Petición por el método {@code DELETE} con el formtado estandar.
     * 
     * @param object objeto web
     * @return respueta
     */
    @DeleteMapping
    public Object requestDELETE(@RequestBody BKRequestModel object) {
        return requestAll(object, "DELETE");
    }
}
