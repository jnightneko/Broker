/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.identity.client;

import gt.edu.umes.broker.core.Microservice;
import static gt.edu.umes.broker.core.endpoints.MCSVBroker.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author wil
 */
@FeignClient(value = "MCSV-Logs", url = Microservice.INTERNAL_MICROSERVICE_LOGS)
public interface ClientLogs {
    //************************************************************************************************
    //***   USUARIOS
    /*(non-Javadoc)
     */
    @GetMapping(BK_USUARIO_OBTENER_POR_ID)
    public Object obtenerUsuarioPorId(@PathVariable String id);
    
    /*(non-Javadoc)
     */
    @PostMapping(BK_USUARIO_CREAR)
    public Object crearUsuario(@RequestBody Object usuario);
    
    //************************************************************************************************
    //***   TOKENS
    /*(non-Javadoc)
     */
    @PostMapping(BK_TOKEN_GUARDAR)
    public Object guardarToken(@RequestBody Object token);
    /*(non-Javadoc)
     */
    @GetMapping(BK_TOKEN_OBTENER_POR_USUARIO)
    public Object obtenerTokenPorUsuario(@PathVariable String idU);
    
    //************************************************************************************************
    //***   SESSIONS
    /*(non-Javadoc)
     */
    @GetMapping(BK_SESION_OBTENER_POR_USUARIO)
    public Object obtenerSesionPorUsuario(@PathVariable String idU);
    /*(non-Javadoc)
     */
    @PostMapping(BK_SESIONES_CREAR)
    public Object crearSesion(@RequestBody Object sesion);
    /*(non-Javadoc)
     */
    @PutMapping(BK_SESIONES_ACTUALIZAR_ESTADO)
    public Object actualizarEstadoSesion(@PathVariable String id, @RequestBody Boolean nuevoEstado);
}
