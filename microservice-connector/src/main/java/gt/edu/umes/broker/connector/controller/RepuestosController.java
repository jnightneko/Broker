/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.controller;

import gt.edu.umes.broker.connector.http.WebObject;
import static gt.edu.umes.broker.connector.client.RepuestosClient.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import gt.edu.umes.broker.connector.client.RepuestosClient;

/**
 * Clase encargado de gestionar el redireccionamiento de las peticiones a las direcciones correctas.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/broker/__connection__/")
public class RepuestosController {
    @Autowired
    private RepuestosClient client;
    /*
        Enalce al end-pointe
    */
    @PostMapping(HTTP_CLIENTES_GET)
    public WebObject getClientesGet() {
        return client.nClientesGet();
    }
    
    /*
        Enalce al end-pointe
    */
    @PostMapping(HTTP_CLIENTES_POST)
    public WebObject getClientesPost(@RequestBody WebObject o) {
        return client.nClientesPost(o);
    }
    
    /*
        Enalce al end-pointe
    */
    @PostMapping(HTTP_CLIENTES_PUT)
    public WebObject getClientesPut(@PathVariable("id") Long id, @RequestBody WebObject o) {
        return client.nClientesPut(id, o);
    }
    
    /*
        Enalce al end-pointe
    */
    @GetMapping(HTTP_PRODUCTOS_GET)
    public WebObject getProductosGet() {
        return client.nProductosGet();
    }
    
    /*
        Enalce al end-pointe
    */
    @PostMapping(HTTP_PRODUCTOS_POST)
    public WebObject getProductosPost(@RequestBody WebObject o) {
        return client.nProductosPost(o);
    }
    
    /*
        Enalce al end-pointe
    */
    @PostMapping(HTTP_PRODUCTOS_PUT)
    public WebObject getProductosPut(@PathVariable("id") Long id, @RequestBody WebObject o) {
        return client.nProductosPut(id, o);
    }
    
    /*
        Enalce al end-pointe
    */
    @PostMapping(HTTP_VEHICULOS_GET)
    public WebObject getVehiculosGet() {
        return client.nVehiculosGet();
    }
    
    /*
        Enalce al end-pointe
    */
    @PostMapping(HTTP_VEHICULOS_POST)
    public WebObject getVehiculosPost(@RequestBody WebObject o) {
        return client.nVehiculosPost(o);
    }
    
    /*
        Enalce al end-pointe
    */
    @PostMapping(HTTP_VEHICULOS_PUT)
    public WebObject getVehiculosPut(@PathVariable("id") Long id, @RequestBody WebObject o) {
        return client.nVehiculosPut(id, o);
    }
    
    /*
        Enalce al end-pointe
    */
    @PostMapping(HTTP_SERVICIOS_GET)
    public WebObject getServicioGet() {
        return client.nServicioGet();
    }
    
    /*
        Enalce al end-pointe
    */
    @PostMapping(HTTP_SERVICIOS_POST)
    public WebObject getServicioPost(@RequestBody WebObject o) {
        return client.nServicioPost(o);
    }
    
    /*
        Enalce al end-pointe
    */
    @PostMapping(HTTP_INVENTARIO_GET)
    public WebObject getInventarioGet() {
        return client.nInventarioGet();
    }
    
    /*
        Enalce al end-pointe
    */
    @PostMapping(HTTP_VENTAS_GET)
    public WebObject getVentasGet() {
        return client.nVentasGet();
    }
    
    /*
        Enalce al end-pointe
    */
    @PostMapping(HTTP_VENTAS_POST)
    public WebObject getVentasPost(@RequestBody WebObject o) {
        return client.nVentasPost(o);
    }
    
    /*
        Enalce al end-pointe
    */
    @PostMapping(HTTP_VENTAS_PUT)
    public WebObject getVentasPut(@PathVariable("id") Long id, @RequestBody WebObject o) {
        return client.nVentasPut(id, o);
    }
}
