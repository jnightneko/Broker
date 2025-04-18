/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.client;

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
    //******************************************************************************************************************
    //**    RUTA DE ELNLACES
    public static final String HTTP_CLIENTES_GET    = "/tallerrepuestos/GET/clientes";
    public static final String HTTP_CLIENTES_POST   = "/tallerrepuestos/POST/clientes";
    public static final String HTTP_CLIENTES_PUT    = "/tallerrepuestos/PUT/clientes/{id}";
    public static final String HTTP_PRODUCTOS_GET   = "/tallerrepuestos/GET/productos";
    public static final String HTTP_PRODUCTOS_POST  = "/tallerrepuestos/POST/productos";
    public static final String HTTP_PRODUCTOS_PUT   = "/tallerrepuestos/PUT/productos/{id}";
    public static final String HTTP_VEHICULOS_GET   = "/tallerrepuestos/GET/vehiculos";
    public static final String HTTP_VEHICULOS_POST  = "/tallerrepuestos/POST/vehiculos";
    public static final String HTTP_VEHICULOS_PUT   = "/tallerrepuestos/PUT/vehiculos/{id}";
    public static final String HTTP_SERVICIOS_GET   = "/tallerrepuestos/GET/servicios";
    public static final String HTTP_SERVICIOS_POST  = "/tallerrepuestos/POST/servicio";
    public static final String HTTP_INVENTARIO_GET  = "/tallerrepuestos/GET/inventarios";
    public static final String HTTP_VENTAS_GET      = "/tallerrepuestos/GET/ventas";
    public static final String HTTP_VENTAS_POST     = "/tallerrepuestos/POST/ventas";
    public static final String HTTP_VENTAS_PUT      = "/tallerrepuestos/PUT/ventas/{id}";    
    /**
     * Enalce al end-pointe
     * @return objeto web
     */
    @GetMapping(HTTP_CLIENTES_GET)
    public Object nClientesGet();    
    /**
     * Enalce al end-pointe
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(HTTP_CLIENTES_POST)
    public Object nClientesPost(@RequestBody Object o);
    /**
     * Enalce al end-pointe
     * @param id id|long
     * @param o objeto web
     * @return objeto web
     */
    @PutMapping(HTTP_CLIENTES_PUT)
    public Object nClientesPut(@PathVariable("id") Long id, @RequestBody Object o);
    /**
     * Enalce al end-pointe
     * @return objeto web
     */
    @GetMapping(HTTP_PRODUCTOS_GET)
    public Object nProductosGet();
    /**
     * Enalce al end-pointe
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(HTTP_PRODUCTOS_POST)
    public Object nProductosPost(@RequestBody Object o);
    /**
     * Enalce al end-pointe
     * @param id id|long
     * @param o objeto web
     * @return objeto web
     */
    @PutMapping(HTTP_PRODUCTOS_PUT)
    public Object nProductosPut(@PathVariable("id") Long id, @RequestBody Object o);
    /**
     * Enalce al end-pointe
     * @return objeto web
     */
    @GetMapping(HTTP_VEHICULOS_GET)
    public Object nVehiculosGet();
    /**
     * Enalce al end-pointe
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(HTTP_VEHICULOS_POST)
    public Object nVehiculosPost(@RequestBody Object o);
    /**
     * Enalce al end-pointe 
     * @param id di|long
     * @param o objeto web
     * @return objeto web
     */
    @PutMapping(HTTP_VEHICULOS_PUT)
    public Object nVehiculosPut(@PathVariable("id") Long id, @RequestBody Object o);
    /**
     * Enalce al end-pointe
     * @return objeto web
     */
    @GetMapping(HTTP_SERVICIOS_GET)
    public Object nServicioGet();
    /**
     * Enalce al end-pointe
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(HTTP_SERVICIOS_POST)
    public Object nServicioPost(@RequestBody Object o);
    /**
     * Enalce al end-pointe
     * @return objeto web
     */
    @GetMapping(HTTP_INVENTARIO_GET)
    public Object nInventarioGet();
    /**
     * Enalce al end-pointe
     * @return objeto web
     */
    @GetMapping(HTTP_VENTAS_GET)
    public Object nVentasGet();
    /**
     * Enalce al end-pointe
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(HTTP_VENTAS_POST)
    public Object nVentasPost(@RequestBody Object o);
    /**
     * Enalce al end-pointe
     * @param id id|long
     * @param o objeto web
     * @return objeto web
     */
    @PutMapping(HTTP_VENTAS_PUT)
    public Object nVentasPut(@PathVariable("id") Long id, @RequestBody Object o);     
}
