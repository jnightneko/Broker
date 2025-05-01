/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.client;

import gt.edu.umes.broker.core.Microservice;
import static gt.edu.umes.broker.core.endpoints.MCSVTienda.*;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Clase encargado de gestionar la conexión con el servicio de 'Tienda', objeto encargado de implementar los
 * enlaces a los endpoints de dicho servicio.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(value = "MCSV-TiendaConveniencia", url = Microservice.MICROSERVICE_TIENDA)
public interface TiendaClient {
    /*(non-Javadoc)*/
    @GetMapping(HTTP_VENTAS_GET)
    public Object nVentaGet();
    /*(non-Javadoc)*/
    @GetMapping(HTTP_VENTAS_COMPLETO_GET)
    public Object nVentasGetCompleto();
    /*(non-Javadoc)*/
    @GetMapping(HTTP_VENTAS_ID_GET)
    public Object nVentasGetId(@PathVariable("id") Object id);
    /*(non-Javadoc)*/
    @PostMapping(HTTP_VENTAS_POST)
    public Object nVentasPost(@RequestBody Object o);
    /*(non-Javadoc)*/
    @PutMapping(HTTP_VENTAS_PUT)
    public Object nVentasPut(@PathVariable("id") Object id, @RequestBody Object o);
    /*(non-Javadoc)*/
    @DeleteMapping(HTTP_VENTAS_DELETE)
    public Object nVentaDelete(@PathVariable("id") Object id);
    /*(non-Javadoc)*/
    @GetMapping(HTTP_DEVOLUCIONES_GET)
    public Object nDevolucionesGet();
    /*(non-Javadoc)*/
    @GetMapping(HTTP_DEVOLUCIONES_ID_GET)
    public Object nDevolucionesGetId(@PathVariable("id") Object id);
    /*(non-Javadoc)*/
    @GetMapping(HTTP_DEVOLUCIONES_VENTA_GET)
    public Object nDevolucionesVentaGet(@PathVariable("id") Object id);
    /*(non-Javadoc)*/
    @GetMapping(HTTP_DEVOLUCIONES_PENDIENTE_GET)
    public Object nDevolucionesPendienteGet();
    /*(non-Javadoc)*/
    @PostMapping(HTTP_DEVOLUCIONES_POST)
    public Object nDevolucionesPost(@RequestBody Object o);
    /*(non-Javadoc)*/
    @PutMapping(HTTP_DEVOLUCIONES_PUT)
    public Object nDevolcionesPut(@PathVariable("id") Object id, @RequestBody Object o);
}
