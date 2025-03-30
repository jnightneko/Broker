package gt.edu.umes.broker.gateway.controller;

import gt.edu.umes.broker.gateway.model.dto.DTOObject;
import gt.edu.umes.broker.gateway.service.APIConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/broker/api/rest")
public final class APIConnectionController {
    @Autowired
    private APIConnectionService service;

    @GetMapping
    public DTOObject requestGET(@RequestBody DTOObject object) {
        return service.send(object);
    }

    @PostMapping
    public DTOObject requestPOST(@RequestBody DTOObject object) {
        return service.send(object);
    }

    @PutMapping
    public DTOObject requestPUT(@RequestBody DTOObject object) {
        return service.send(object);
    }

    @PatchMapping
    public void requestPATCH(@RequestBody DTOObject object) {
        service.send(object);
    }

    @DeleteMapping
    public DTOObject requestDELETE(@RequestBody DTOObject object) {
        return service.send(object);
    }
}
