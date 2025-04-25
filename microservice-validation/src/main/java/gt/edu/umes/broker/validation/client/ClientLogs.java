/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.validation.client;

import gt.edu.umes.broker.core.Microservice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wil
 */
@FeignClient(value = "MCSV-Logs", url = Microservice.INTERNAL_MICROSERVICE_LOGS)
public interface ClientLogs {
    
    /**
     * Conexión con el microservicios logs: crearLog()
     * @param o objeto web
     * @return objeto we
     */
    @PostMapping("/broker/logs")
    public Object crearLog(@RequestBody Object o);
    
    /**
     * Conexión con el microservicios logs: crearLog()
     * @param id uuid|string
     * @return objeto we
     */
    @GetMapping("/broker/usuarios/{id}")
    public Object obtenerPorId(@PathVariable("id") String id);
}
