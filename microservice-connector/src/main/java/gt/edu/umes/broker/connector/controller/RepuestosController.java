/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import gt.edu.umes.broker.connector.client.RepuestosClient;
import static gt.edu.umes.broker.connector.client.RepuestosClient.*;

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
    public Object getClientesPut(@PathVariable("id") Long id, @RequestBody Object o) {
        return client.nClientesPut(id, o);
    }
    /* (non-Javadoc) */
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
    public Object getProductosPut(@PathVariable("id") Long id, @RequestBody Object o) {
        return client.nProductosPut(id, o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_VEHICULOS_GET)
    public Object getVehiculosGet() {
        return client.nVehiculosGet();
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_VEHICULOS_POST)
    public Object getVehiculosPost(@RequestBody Object o) {
        return client.nVehiculosPost(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_VEHICULOS_PUT)
    public Object getVehiculosPut(@PathVariable("id") Long id, @RequestBody Object o) {
        return client.nVehiculosPut(id, o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_SERVICIOS_GET)
    public Object getServicioGet() {
        return client.nServicioGet();
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_SERVICIOS_POST)
    public Object getServicioPost(@RequestBody Object o) {
        return client.nServicioPost(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_INVENTARIO_GET)
    public Object getInventarioGet() {
        return client.nInventarioGet();
    }
    /* (non-Javadoc) */
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
    public Object getVentasPut(@PathVariable("id") Long id, @RequestBody Object o) {
        return client.nVentasPut(id, o);
    }
}
