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
 * @version 2.0.0
 * @since 1.0.0
 */
@FeignClient(value = "MCSV-TiendaConveniencia", url = Microservice.MICROSERVICE_TIENDA)
public interface TiendaClient {
    
    @GetMapping(HTTP_PRODUCTOS_GET)
    Object func1();
    
    @PostMapping(HTTP_PRODUCTOS_POST)
    Object f2(@RequestBody Object o);
    
    @GetMapping(HTTP_PRODUCTOS_GET_ID)
    Object f3(@PathVariable("id") Object o);
    
    @PutMapping(HTTP_PRODUCTOS_PUT)
    Object f4(@PathVariable("id") Object o);
    
    @DeleteMapping(HTTP_PRODUCTO_DELETE)
    Object f5(@PathVariable("id") Object o);
    
    @GetMapping(HTTP_CATEGORIA_GET)
    Object f6();
    
    @PostMapping(HTTP_CATEGORIA_POST)
    Object f7(@RequestBody Object o);
    
    
    
    
    @GetMapping(HTTP_CATEGORIA_GET_ID)
    Object f8(@PathVariable("id") Object o);
    
    @PutMapping(HTTP_CATEGORIA_PUT)
    Object f9(@PathVariable("id") Object id,@RequestBody Object o);
    
    @DeleteMapping(HTTP_CATEGORIA_DELETE)
    Object f10(@PathVariable("id") Object id);
    
    @GetMapping(HTTP_MARCAS_GET)
    Object f11();
    
    @PostMapping(HTTP_MARCAS_POST)
    Object f12(@RequestBody Object o);
    
    @GetMapping(HTTP_MARCAS_GET_ID)
    Object f13(@PathVariable("id") Object o);
    
    @PutMapping(HTTP_MARCAS_PUT)
    Object f14(@PathVariable("id") Object o1, @RequestBody Object o);
    
    @DeleteMapping(HTTP_MARCAS_DELETE)
    Object f15(@PathVariable("id") Object i);
    
    
    
    
    @PostMapping(HTTP_LOTES_POST)
    Object f16(@RequestBody Object o);
    
    @GetMapping(HTTP_LOTES_GET)
    Object f17();
    
    @GetMapping(HTTP_LOTES_GET_PRODUCTO_ID)
    Object f18(@PathVariable("idProducto") Object id);
    
    @GetMapping(HTTP_LOTES_GET_ID)
    Object f19(@PathVariable("id") Object id);
    
    @PutMapping(HTTP_LOTES_PUT)
    Object f20(@PathVariable("id") Object o, @RequestBody Object h);
    
    @DeleteMapping(HTTP_LOTES_DELETE)
    Object f21(@PathVariable("id") Object id);
    
    @GetMapping(HTTP_VENTAS_GET)
    Object f22();
    
    @PostMapping(HTTP_VENTAS_POST)
    Object f23(@RequestBody Object s);
    
    @GetMapping(HTTP_VENTAS_ID_GET)
    Object f24(@PathVariable("id") Object id);
    
    @PutMapping(HTTP_VENTAS_PUT)
    Object f25(@PathVariable("id") Object s, @RequestBody Object o);
    
    @GetMapping(HTTP_RECETAS_GET)
    Object f26(@PathVariable("idProducto") Object id);
    
    @PutMapping(HTTP_RECETAS_PUT)
    Object f27(@PathVariable("idProducto") Object id, @RequestBody Object o);
    
    @PostMapping(HTTP_RECETAS_POST)
    Object f28(@RequestBody Object o);
    
    @DeleteMapping(HTTP_RECETAS_DELETE)
    Object f29(@PathVariable("idAsignacion") Object o);
    
    @PatchMapping(HTTP_RECETA_PATCH)
    Object f30(@PathVariable("idAsignacion") Object i, @RequestBody Object oi);
}
