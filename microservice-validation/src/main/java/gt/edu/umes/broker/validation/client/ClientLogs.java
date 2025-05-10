/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.validation.client;

import static gt.edu.umes.broker.core.Microservice.*;
import static gt.edu.umes.broker.core.endpoints.MCSVBroker.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author wil
 */
@FeignClient(value = "MCSV-Logs", url = INTERNAL_MICROSERVICE_LOGS)
public interface ClientLogs {
    
    /**
     * Conexión con el microservicios logs: crearLog()
     * @param o objeto web
     * @return objeto we
     */
    @PostMapping(BK_LOGS)
    public Object crearLog(@RequestBody Object o);
    
    /**
     * Conexión con el microservicios logs: crearLog()
     * @param id uuid|string
     * @return objeto we
     */
    @GetMapping(BK_USUARIO_OBTENER_POR_ID)
    public Object obtenerPorId(@PathVariable("id") String id);

    @GetMapping("/broker/tokens/logged-out/{token}")
    boolean isTokenLoggedOut(@PathVariable("token") String token);
}
