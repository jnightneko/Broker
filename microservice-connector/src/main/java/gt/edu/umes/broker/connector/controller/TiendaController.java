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
 * @version 1.2.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/broker/__connection__/")
public class TiendaController {
    @Autowired
    private TiendaClient client;
    
    
    @PostMapping(HTTP_PRODUCTOS_GET)
    public Object func1() {
        return client.func1();
    }
    
    @PostMapping(HTTP_PRODUCTOS_POST)
    public Object f2(@RequestBody Object o) {
        return client.f2(o);
    }
    
    @PostMapping(HTTP_PRODUCTOS_GET_ID)
    public Object f3(@PathVariable("id") Object o) {
        return client.f3(o);
    }
    
    @PostMapping(HTTP_PRODUCTOS_PUT)
    public Object f4(@PathVariable("id") Object o) {
        return client.f4(o);
    }
    
    @PostMapping(HTTP_PRODUCTO_DELETE)
    public Object f5(@PathVariable("id") Object o) {
        return client.f5(o);
    }
    
    @PostMapping(HTTP_CATEGORIA_GET)
    public Object f6() {
        return client.f6();
    }
    
    @PostMapping(HTTP_CATEGORIA_POST)
    public Object f7(@RequestBody Object o) {
        return client.f7(o);
    }
    
    @PostMapping(HTTP_CATEGORIA_GET_ID)
    public Object f8(@PathVariable("id") Object o) {
        return client.f8(o);
    }
    
    @PostMapping(HTTP_CATEGORIA_PUT)
    public Object f9(@PathVariable("id") Object id,@RequestBody Object o) {
        return client.f9(id, o);
    }
    
    @PostMapping(HTTP_CATEGORIA_DELETE)
    public Object f10(@PathVariable("id") Object id) {
        return client.f10(id);
    }
    
    @PostMapping(HTTP_MARCAS_GET)
    public Object f11() {
        return client.f11();
    }
    
    @PostMapping(HTTP_MARCAS_POST)
    public Object f12(@RequestBody Object o) {
        return client.f12(o);
    }
    
    @PostMapping(HTTP_MARCAS_GET_ID)
    public Object f13(@PathVariable("id") Object o) {
        return client.f13(o);
    }
    
    @PostMapping(HTTP_MARCAS_PUT)
    public Object f14(@PathVariable("id") Object o1, @RequestBody Object o) {
        return client.f14(o1, o);
    }
    
    @PostMapping(HTTP_MARCAS_DELETE)
    public Object f15(@PathVariable("id") Object i) {
        return client.f15(i);
    }
    
    @PostMapping(HTTP_LOTES_POST)
    public Object f16(@RequestBody Object o) {
        return client.f16(o);
    }
    
    @PostMapping(HTTP_LOTES_GET)
    public Object f17() {
        return client.f17();
    }
    
    @PostMapping(HTTP_LOTES_GET_PRODUCTO_ID)
    public Object f18(@PathVariable("idProducto") Object id) {
        return client.f18(id);
    }
    
    @PostMapping(HTTP_LOTES_GET_ID)
    public Object f19(@PathVariable("id") Object id) {
        return client.f19(id);
    }
    
    @PostMapping(HTTP_LOTES_PUT)
    public Object f20(@PathVariable("id") Object o, @RequestBody Object h) {
        return client.f20(o, h);
    }
    
    @PostMapping(HTTP_LOTES_DELETE)
    public Object f21(@PathVariable("id") Object id) {
        return client.f21(id);
    }
    
    @PostMapping(HTTP_VENTAS_GET)
    public Object f22() {
        return client.f22();
    }
    
    @PostMapping(HTTP_VENTAS_POST)
    public Object f23(@RequestBody Object s) {
        return client.f23(s);
    }
    
    @PostMapping(HTTP_VENTAS_ID_GET)
    public Object f24(@PathVariable("id") Object id) {
        return client.f24(id);
    }
    
    @PostMapping(HTTP_VENTAS_PUT)
    public Object f25(@PathVariable("id") Object s, @RequestBody Object o) {
        return client.f25(s, o);
    }
    
    @PostMapping(HTTP_RECETAS_GET)
    public Object f26(@PathVariable("idProducto") Object id) {
        return client.f26(id);
    }
    
    @PostMapping(HTTP_RECETAS_PUT)
    public Object f27(@PathVariable("idProducto") Object id, @RequestBody Object o) {
        return client.f27(id, o);
    }
    
    @PostMapping(HTTP_RECETAS_POST)
    public Object f28(@RequestBody Object o) {
        return client.f28(o);
    }
    
    @PostMapping(HTTP_RECETAS_DELETE)
    public Object f29(@PathVariable("idAsignacion") Object o) {
        return client.f29(o);
    }
    
    @PostMapping(HTTP_RECETA_PATCH)
    public Object f30(@PathVariable("idAsignacion") Object i, @RequestBody Object oi) {
        return client.f30(i, oi);
    }
}
