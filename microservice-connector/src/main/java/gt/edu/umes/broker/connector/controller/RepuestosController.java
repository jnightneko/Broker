/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import gt.edu.umes.broker.connector.client.RepuestosClient;
import static gt.edu.umes.broker.core.endpoints.MCSVRepuestos.*;

/**
 * Clase encargado de gestionar el redireccionamiento de las peticiones a las direcciones correctas.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/broker/__connection__/")
public final class RepuestosController {
    @Autowired
    private RepuestosClient client;
    /* (non-Javadoc) */
    @PostMapping(HTTP_SERVICIOS_GET)
    public Object getServiciosGet() {
        return client.nServiciosGet();
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_SERVICIOS_POST)
    public Object getServiciosPost(@RequestBody Object o) {
        return client.nServiciosPost(o);
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_SERVICIOS_PUT)
    public Object getServiciosPut(@PathVariable("id") Object id, @RequestBody Object o) {
        return client.nServiciosPut(id, o);
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_SERVICIOS_DELETE)
    public Object getServiciosDelete(@PathVariable("id") Object id) {
        return client.nServiciosDelete(id);
    }

    @PostMapping(HTTP_TIPOSERVICIOS_GET)
    public Object getTipoServiciosGet() {
        return client.nTiposerviciosGet();
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_TIPOSERVICIOS_POST)
    public Object getTipoServiciosPost(@RequestBody Object o) {
        return client.nTiposerviciosPost(o);
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_TIPOSERVICIOS_PUT)
    public Object getTipoServiciosPut(@PathVariable("id") Object id, @RequestBody Object o) {
        return client.nTiposerviciosPut(id, o);
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_TIPOSERVICIOS_DELETE)
    public Object getTipoServiciosDelete(@PathVariable("id") Object id) {
        return client.nTiposerviciosDelete(id);
    }

    @PostMapping(HTTP_EMPLEADOS_GET)
    public Object getEmpleadosGet() {
        return client.nEmpleadosGet();
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_EMPLEADOS_POST)
    public Object getEmpleadosPost(@RequestBody Object o) {
        return client.nEmpleadosPost(o);
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_EMPLEADOS_PUT)
    public Object getEmpleadosPut(@PathVariable("id") Object id, @RequestBody Object o) {
        return client.nEmpleadosPut(id, o);
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_EMPLEADOS_DELETE)
    public Object getEmpleadosDelete(@PathVariable("id") Object id) {
        return client.nEmpleadosDelete(id);
    }

    @PostMapping(HTTP_CLIENTES_GET)
    public Object getClientesGet() {
        return client.nClientesGet();
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_CLIENTES_POST)
    public Object getClientesPost(@RequestBody Object o) {
        return client.nClientesPost(o);
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_CLIENTES_PUT)
    public Object getClientesPut(@PathVariable("id") Object id, @RequestBody Object o) {
        return client.nClientesPut(id, o);
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_CLIENTES_DELETE)
    public Object getClientesDelete(@PathVariable("id") Object id) {
        return client.nClientesDelete(id);
    }

    @PostMapping(HTTP_VENTAS_GET)
    public Object getVentasGet() {
        return client.nVentasGet();
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_VENTAS_POST)
    public Object getVentasPost(@RequestBody Object o) {
        return client.nVentasPost(o);
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_VENTAS_PUT)
    public Object getVentasPut(@PathVariable("id") Object id, @RequestBody Object o) {
        return client.nVentasPut(id, o);
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_VENTAS_DELETE)
    public Object getVentasDelete(@PathVariable("id") Object id) {
        return client.nVentasDelete(id);
    }

    @PostMapping(HTTP_CATEGORIAS_GET)
    public Object getCategoriasGet() {
        return client.nCategoriasGet();
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_CATEGORIAS_POST)
    public Object getCategoriasPost(@RequestBody Object o) {
        return client.nCategoriasPost(o);
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_CATEGORIAS_PUT)
    public Object getCategoriasPut(@PathVariable("id") Object id, @RequestBody Object o) {
        return client.nCategoriasPut(id, o);
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_CATEGORIAS_DELETE)
    public Object getCategoriasDelete(@PathVariable("id") Object id) {
        return client.nCategoriasDelete(id);
    }

    @PostMapping(HTTP_PRODUCTOS_GET)
    public Object getProductosGet() {
        return client.nProductosGet();
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_PRODUCTOS_POST)
    public Object getProductosPost(@RequestBody Object o) {
        return client.nProductosPost(o);
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_PRODUCTOS_PUT)
    public Object getProductosPut(@PathVariable("id") Object id, @RequestBody Object o) {
        return client.nProductosPut(id, o);
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_PRODUCTOS_DELETE)
    public Object getProductosDelete(@PathVariable("id") Object id) {
        return client.nProductosDelete(id);
    }

    @PostMapping(HTTP_INVENTARIOS_GET)
    public Object getInventariosGet() {
        return client.nInventariosGet();
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_INVENTARIOS_POST)
    public Object getInventariosPost(@RequestBody Object o) {
        return client.nInventariosPost(o);
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_INVENTARIOS_PUT)
    public Object getInventariosPut(@PathVariable("id") Object id, @RequestBody Object o) {
        return client.nInventariosPut(id, o);
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_INVENTARIOS_DELETE)
    public Object getInventariosDelete(@PathVariable("id") Object id) {
        return client.nInventariosDelete(id);
    }

    @PostMapping(HTTP_MOVIMIENTOS_GET)
    public Object getMovimientosGet() {
        return client.nMovimientosGet();
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_MOVIMIENTOS_POST)
    public Object getMovimientosPost(@RequestBody Object o) {
        return client.nMovimientosPost(o);
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_MOVIMIENTOS_PUT)
    public Object getMovimientosPut(@PathVariable("id") Object id, @RequestBody Object o) {
        return client.nMovimientosPut(id, o);
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_MOVIMIENTOS_DELETE)
    public Object getMovimientosDelete(@PathVariable("id") Object id) {
        return client.nMovimientosDelete(id);
    }

    @PostMapping(HTTP_PRECIO_HISTORIAL_GET)
    public Object getPrecioHistorialGet() {
        return client.nPrecioHistorialGet();
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_PRECIO_HISTORIAL_POST)
    public Object getPrecioHistorialPost(@RequestBody Object o) {
        return client.nPrecioHistorialPost(o);
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_PRECIO_HISTORIAL_PUT)
    public Object getPrecioHistorialPut(@PathVariable("id") Object id, @RequestBody Object o) {
        return client.nPrecioHistorialPut(id, o);
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_PRECIO_HISTORIAL_DELETE)
    public Object getPrecioHistorialDelete(@PathVariable("id") Object id) {
        return client.nPrecioHistorialDelete(id);
    }

    @PostMapping(HTTP_DEVOLUCION_GET)
    public Object getDevolucionGet() {
        return client.nDevolucionGet();
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_DEVOLUCION_GET_ID)
    public Object getDevolucionGetById(@PathVariable("id") Object id) {
        return client.nDevolucionGetById(id);
    }

    /* (non-Javadoc) */
    @PostMapping(HTTP_DEVOLUCION_POST)
    public Object getDevolucionPost(@RequestBody Object o) {
        return client.nDevolucionPost(o);
    }

}
