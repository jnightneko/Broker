/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.client;

import gt.edu.umes.broker.core.Microservice;
import static gt.edu.umes.broker.core.endpoints.MCSVRepuestos.*;

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
@FeignClient(value = "MCSV-TallerRepuesto", url = Microservice.MICROSERVICE_REPUESTOS)
public interface RepuestosClient {
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
