/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.client;

import gt.edu.umes.broker.connector.http.WebObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Clase encargado de gestionar la conexión con el servicio de 'Taller de Repuesto', objeto encargado de implementar los
 * enlaces a los endpoints de dicho servicio.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(value = "MCSV-TallerRepuesto", url = "http://localhost:4000/")
public interface RepuestosClient {
    
    /*
        Enalce al end-pointe
    */
    @GetMapping(HTTP_CLIENTES_GET)
    public WebObject nClientesGet();
    public static final String HTTP_CLIENTES_GET                    = "/tallerrepuestos/GET/clientes";
    
    /*
        Enalce al end-pointe
    */
    @PostMapping(HTTP_CLIENTES_POST)
    public WebObject nClientesPost(@RequestBody WebObject o);
    public static final String HTTP_CLIENTES_POST                   = "/tallerrepuestos/POST/clientes";
    
    /*
        Enalce al end-pointe
    */
    @PutMapping(HTTP_CLIENTES_PUT)
    public WebObject nClientesPut(@PathVariable("id") Long id, @RequestBody WebObject o);
    public static final String HTTP_CLIENTES_PUT                    = "/tallerrepuestos/PUT/clientes/{id}";
    
    /*
        Enalce al end-pointe
    */
    @GetMapping(HTTP_PRODUCTOS_GET)
    public WebObject nProductosGet();
    public static final String HTTP_PRODUCTOS_GET                   = "/tallerrepuestos/GET/productos";
    
    /*
        Enalce al end-pointe
    */
    @PostMapping(HTTP_PRODUCTOS_POST)
    public WebObject nProductosPost(@RequestBody WebObject o);
    public static final String HTTP_PRODUCTOS_POST                  = "/tallerrepuestos/POST/productos";
    
    /*
        Enalce al end-pointe
    */
    @PutMapping(HTTP_PRODUCTOS_PUT)
    public WebObject nProductosPut(@PathVariable("id") Long id, @RequestBody WebObject o);
    public static final String HTTP_PRODUCTOS_PUT                   = "/tallerrepuestos/PUT/productos/{id}";
    
    /*
        Enalce al end-pointe
    */
    @GetMapping(HTTP_VEHICULOS_GET)
    public WebObject nVehiculosGet();
    public static final String HTTP_VEHICULOS_GET                   = "/tallerrepuestos/GET/vehiculos";
    
    /*
        Enalce al end-pointe
    */
    @PostMapping(HTTP_VEHICULOS_POST)
    public WebObject nVehiculosPost(@RequestBody WebObject o);
    public static final String HTTP_VEHICULOS_POST                  = "/tallerrepuestos/POST/vehiculos";
    
    /*
        Enalce al end-pointe
    */
    @PutMapping(HTTP_VEHICULOS_PUT)
    public WebObject nVehiculosPut(@PathVariable("id") Long id, @RequestBody WebObject o);
    public static final String HTTP_VEHICULOS_PUT                   = "/tallerrepuestos/PUT/vehiculos/{id}";
    
    /*
        Enalce al end-pointe
    */
    @GetMapping(HTTP_SERVICIOS_GET)
    public WebObject nServicioGet();
    public static final String HTTP_SERVICIOS_GET                   = "/tallerrepuestos/GET/servicios";
    
    /*
        Enalce al end-pointe
    */
    @PostMapping(HTTP_SERVICIOS_POST)
    public WebObject nServicioPost(@RequestBody WebObject o);
    public static final String HTTP_SERVICIOS_POST                  = "/tallerrepuestos/POST/servicio";
    
    /*
        Enalce al end-pointe
    */
    @GetMapping(HTTP_INVENTARIO_GET)
    public WebObject nInventarioGet();
    public static final String HTTP_INVENTARIO_GET                  = "/tallerrepuestos/GET/inventarios";
    
    /*
        Enalce al end-pointe
    */
    @GetMapping(HTTP_VENTAS_GET)
    public WebObject nVentasGet();
    public static final String HTTP_VENTAS_GET                      = "/tallerrepuestos/GET/ventas";
    
    /*
        Enalce al end-pointe
    */
    @PostMapping(HTTP_VENTAS_POST)
    public WebObject nVentasPost(@RequestBody WebObject o);
    public static final String HTTP_VENTAS_POST                     = "/tallerrepuestos/POST/ventas";
    
    /*
        Enalce al end-pointe
    */
    @PutMapping(HTTP_VENTAS_PUT)
    public WebObject nVentasPut(@PathVariable("id") Long id, @RequestBody WebObject o);
    public static final String HTTP_VENTAS_PUT                      = "/tallerrepuestos/PUT/ventas/{id}";   
}
