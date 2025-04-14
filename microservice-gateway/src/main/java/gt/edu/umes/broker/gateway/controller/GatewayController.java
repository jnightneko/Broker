/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.gateway.controller;

import gt.edu.umes.broker.gateway.model.BKRequestModel;
import gt.edu.umes.broker.gateway.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/broker/api/rest")
public final class GatewayController {
    @Autowired
    private GatewayService service;

    @GetMapping
    public Object requestGET(@RequestBody BKRequestModel object) {
        return service.send(object);
    }

    @PostMapping
    public Object requestPOST(@RequestBody BKRequestModel object) {
        return service.send(object);
    }

    @PutMapping
    public Object requestPUT(@RequestBody BKRequestModel object) {
        return service.send(object);
    }

    @PatchMapping
    public void requestPATCH(@RequestBody BKRequestModel object) {
        service.send(object);
    }

    @DeleteMapping
    public Object requestDELETE(@RequestBody BKRequestModel object) {
        return service.send(object);
    }
}
