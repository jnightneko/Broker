/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import gt.edu.umes.broker.connector.client.TiendaClient;
import static gt.edu.umes.broker.core.endpoints.MCSVTienda.*;

/**
 * Clase encargado de gestionar el redireccionamiento de las peticiones a las direcciones correctas.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/broker/__connection__/")
public class TiendaController {
    @Autowired
    private TiendaClient client;
    /*(non-Javadoc)*/
    @PostMapping(HTTP_VENTAS_GET)
    public Object getVentaGet() {
        return client.nVentaGet();
    }
    /*(non-Javadoc)*/
    @PostMapping(HTTP_VENTAS_COMPLETO_GET)
    public Object getVentasGetCompleto() {
        return client.nVentasGetCompleto();
    }
    /*(non-Javadoc)*/
    @PostMapping(HTTP_VENTAS_ID_GET)
    public Object getVentasGetId(@PathVariable("id") Object id) {
        return client.nVentasGetId(id);
    }
    /*(non-Javadoc)*/
    @PostMapping(HTTP_VENTAS_POST)
    public Object getVentasPost(@RequestBody Object o) {
        return client.nVentasPost(o);
    }
    /*(non-Javadoc)*/
    @PostMapping(HTTP_VENTAS_PUT)
    public Object getVentasPut(@PathVariable("id") Object id, @RequestBody Object o) {
        return client.nVentasPut(id, o);
    }
    /*(non-Javadoc)*/
    @PostMapping(HTTP_VENTAS_DELETE)
    public Object getVentaDelete(@PathVariable("id") Object id) {
        return client.nVentaDelete(id);
    }
    /*(non-Javadoc)*/
    @PostMapping(HTTP_DEVOLUCIONES_GET)
    public Object getDevolucionesGet() {
        return client.nDevolucionesGet();
    }
    /*(non-Javadoc)*/
    @PostMapping(HTTP_DEVOLUCIONES_ID_GET)
    public Object getDevolucionesGetId(@PathVariable("id") Object id) {
        return client.nDevolucionesGetId(id);
    }
    /*(non-Javadoc)*/
    @PostMapping(HTTP_DEVOLUCIONES_VENTA_GET)
    public Object getDevolucionesVentaGet(@PathVariable("id") Object id) {
        return client.nDevolucionesVentaGet(id);
    }
    /*(non-Javadoc)*/
    @PostMapping(HTTP_DEVOLUCIONES_PENDIENTE_GET)
    public   Object getDevolucionesPendienteGet() {
        return client.nDevolucionesPendienteGet();
    }
    /*(non-Javadoc)*/
    @PostMapping(HTTP_DEVOLUCIONES_POST)
    public Object getDevolucionesPost(@RequestBody Object o) {
        return client.nDevolucionesPost(o);
    }
    /*(non-Javadoc)*/
    @PostMapping(HTTP_DEVOLUCIONES_PUT)
    public Object getDevolcionesPut(@PathVariable("id") Object id, @RequestBody Object o) {
        return client.nDevolcionesPut(id, o);
    }
}
