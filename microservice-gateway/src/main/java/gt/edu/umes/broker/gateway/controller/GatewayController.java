/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.gateway.controller;

import gt.edu.umes.broker.gateway.model.BKRequestModel;
import gt.edu.umes.broker.gateway.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Clase encargada el controlador de las peticiones, dichas peticiones provienen de los 
 * cliente que desean conectarse con los servicios de la organización.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/broker/api/rest")
public final class GatewayController {
    @Autowired
    private GatewayService service;

    /**
     * Petición por el método {@code GET} con el formtado estandar.
     * 
     * @param object objeto web
     * @return respueta
     */
    @GetMapping
    public Object requestGET(@RequestBody BKRequestModel object) {
        return service.send(object);
    }

    /**
     * Petición por el método {@code POST} con el formtado estandar.
     * 
     * @param object objeto web
     * @return respueta
     */
    @PostMapping
    public Object requestPOST(@RequestBody BKRequestModel object) {
        return service.send(object);
    }

    /**
     * Petición por el método {@code PUT} con el formtado estandar.
     * 
     * @param object objeto web
     * @return respueta
     */
    @PutMapping
    public Object requestPUT(@RequestBody BKRequestModel object) {
        return service.send(object);
    }

    /**
     * Petición por el método {@code PATH} con el formtado estandar.
     * 
     * @param object objeto web
     * @return respueta
     */
    @PatchMapping
    public Object requestPATCH(@RequestBody BKRequestModel object) {
        return service.send(object);
    }

    /**
     * Petición por el método {@code DELETE} con el formtado estandar.
     * 
     * @param object objeto web
     * @return respueta
     */
    @DeleteMapping
    public Object requestDELETE(@RequestBody BKRequestModel object) {
        return service.send(object);
    }
}
