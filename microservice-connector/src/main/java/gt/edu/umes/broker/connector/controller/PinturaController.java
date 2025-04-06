/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.controller;

import gt.edu.umes.broker.connector.http.WebObject;
import static gt.edu.umes.broker.connector.client.PinturaClient.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import gt.edu.umes.broker.connector.client.PinturaClient;
/**
 * Clase encargado de gestionar el redireccionamiento de las peticiones a las direcciones correctas.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/broker/__connection__/")
public class PinturaController {
    @Autowired
    private PinturaClient client;
    /**
     * Obtener todos los servicios disponibles
     * @return objeto json
     */
    @GetMapping(PINTURA_SERVICIO_GET)
    public WebObject getPServicio() {
        return client.nPServicio();
    }
    
    /**
     * Crear un nuevo servicio
     * @param value object
     * 
     * @return objeto json
     */
    @PostMapping(PINTURA_SERVICIO_POST)
    public WebObject getPServicio(@RequestBody WebObject value) {
        return client.nPServicio(value);
    }
    
    /**
     * Acutalizar un servicio
     * 
     * @param id number|object id
     * @param value object
     * 
     * @return objeto json
     */
    @PutMapping(PINTURA_SERVICIO_PUT)
    public WebObject getPServicio(@PathVariable("idServicio") Long id, @RequestBody WebObject value) {
        return client.nPServicio(id, value);
    }
    
    /**
     * Obtener todos los tipos de servicio
     * @return objeto json
     */
    @GetMapping(PINTURA_TIPOSERVICIO_GET)
    public WebObject getPTipoServicio() {
        return client.nPTipoServicio();
    }
    
    /**
     * Actualizar un tipo de servicio
     * 
     * @param id number|object id
     * @param value object
     * 
     * @return objeto json
     */
    @PutMapping(PINTURA_TIPOSERVICIO_PUT)
    public WebObject getPTipoServicio(@PathVariable("idTipoServicio") Long id, @RequestBody WebObject value) {
        return client.nPTipoServicio(id, value);
    }
    
    /**
     * Crear un nuevo tipo de servicio
     * @param value object
     * 
     * @return objeto json
     */
    @PostMapping(PINTURA_TIPOSERVICIO_POST)
    public WebObject getPTipoServicio(@RequestBody WebObject value) {
        return client.nPTipoServicio(value);
    }
    
    /**
     * Obtener todos los tipos de vehículo
     * @return objeto json
     */
    @GetMapping(PINTURA_TIPOVEHICULO_GET)
    public WebObject getPTipoVehiculo() {
        return client.nPTipoVehiculo();
    }
    
    /**
     * Crear un nuevo tipo de vehículo
     * @param value object
     * 
     * @return objeto json
     */
    @PostMapping(PINTURA_TIPOVEHICULO_POST)
    public WebObject getPTipoVehiculo(@RequestBody WebObject value) {
        return client.nPTipoVehiculo(value);
    }
    
    /**
     * Actualizar un tipo de vehículo específico
     * 
     * @param id number|object id
     * @param value object
     * 
     * @return objeto json
     */
    @PutMapping(PINTURA_TIPOVEHICULO_PUT)
    public WebObject getPTipoVehiculo(@PathVariable("idTipoVehiculo") Long id, @RequestBody WebObject value) {
        return client.nPTipoVehiculo(id, value);
    }
    
    /**
     * Obtener todos los tipos de pintura disponibles
     * @return objeto json
     */
    @GetMapping(PINTURA_TIPOPINTURA_GET)
    public WebObject getPTipoPintura() {
        return client.nPTipoPintura();
    }
    
    /*
        Crear un nuevo tipo de pintura
    */
    @PostMapping(PINTURA_TIPOPINTURA_POST)
    public WebObject getPTipoPintura(@RequestBody WebObject value) {
        return client.nPTipoPintura(value);
    }
    
    /*
        Actualizar un tipo de pintura
    */
    @PutMapping(PINTURA_TIPOPINTURA_PUT)
    public WebObject getPTipoPintura(@PathVariable("idTipoPintura") Long id, @RequestBody WebObject value) {
        return client.nPTipoPintura(id, value);
    }
    
    /*
        Obtener todos los inventarios
    */
    @GetMapping(PINTURA_INVENTARIO_GET)
    public WebObject getPInvetario() {
        return client.nPInvetario();
    }
    
    /*
        Crear un nuevo inventario
    */
    @PostMapping(PINTURA_INVENTARIO_POST)
    public WebObject getPInventario(@RequestBody WebObject value) {
        return client.nPInventario(value);
    }
    
    /*
        Actualizar un tipo de inventario
    */
    @PutMapping(PINTURA_INVENTARIO_PUT)
    public WebObject getPInventario(@PathVariable("idInventario") Long id, @RequestBody WebObject value) {
        return client.nPInventario(id, value);
    }
    
    /*
        Obtener todos los movimientos de inventario
    */
    @GetMapping(PINTURA_MOVIMIENTO_GET)
    public WebObject getPMovimiento() {
        return client.nPMovimiento();
    }
    
    /*
        Crear un nuevo movimiento de inventarios
    */
    @PostMapping(PINTURA_MOVIMIENTO_POST)
    public WebObject getPMovimiento(@RequestBody WebObject o) {
        return client.nPMovimiento(o);
    }
    
    /*
        Actualizar un movimiento de inventario
    */
    @PutMapping(PINTURA_MOVIMINEOT_PUT)
    public WebObject getPMovimientoPut(@RequestBody WebObject o) {
        return client.nPMovimientoPut(o);
    }
    
    /*
        Crear una nueva venta
    */
    @PostMapping(PINTURA_VENTAS_POST)
    public WebObject getPVentas(@RequestBody WebObject o) {
        return client.nPVentas(o);
    }
    
    /*
        Obtener todas las ventas
    */
    @GetMapping(PINTURA_VENTAS_GET)
    public WebObject nPVentas() {
        return client.nPVentas();
    }
    
    /*
        Actualizar una venta
    */
    @PutMapping(PINTURA_VENTAS_PUT)
    public WebObject getPVentas(@PathVariable("idVenta") Long id, @RequestBody WebObject o) {
        return client.nPVentas(id, o);
    }
    
    /*
        Obtener el detalle de una venta específica
    */
    @GetMapping(PINTURA_DETALLE_VENTA_GET)
    public WebObject getPDetallVenta(@PathVariable("idVenta") Long id) {
        return client.nPDetallVenta(id);
    }
    
    /*
        rear un nuevo detalle de venta
    */
    @PostMapping(PINTURA_DETALLE_VENTA_POST)
    public WebObject getPDetalleVenta(@RequestBody WebObject o) {
        return client.nPDetalleVenta(o);
    }
    
    /*
        Actualizar un detalle de venta
    */
    @PutMapping(PINTURA_DETALLE_VENTA_PUT)
    public WebObject getPDetalleVenta(@PathVariable("idDetalleVenta") Long l, @RequestBody WebObject o) {
        return client.nPDetalleVenta(l, o);
    }
    
    /*
        Obtener todas las devoluciones
    */
    @GetMapping(PINTURA_DEVOLUCION_GET)
    public WebObject getPVecolucion() {
        return client.nPVecolucion();
    }
    
    /*
        Crear una nueva devlución
    */
    @PostMapping(PINTURA_DEVOLUCION_POST)
    public WebObject getPDevolucion(@RequestBody WebObject o) {
        return client.nPDevolucion(o);
    }
    
    /*
        Obtener todos los inventarios de vehiculo
    */
    @GetMapping(PINTURA_VEHICULO_INVENTARIO_GET)
    public WebObject getPVehiculoInventario() {
        return client.nPVehiculoInventario();
    }
    
    /*
        Crear un nuevo inventario de vehiculo
    */
    @PostMapping(PINTURA_VEHICULO_INVENTARIO_POST)
    public WebObject getPVehiculoInventario(@RequestBody WebObject o) {
        return client.nPVehiculoInventario(o);
    }
    
    /*
        Actualizar un inventario de vehiculo
    */
    @PutMapping(PINTURA_VEHICULO_INVENTARIO_PUT)
    public WebObject getPVehiculoInventarioPut(@RequestBody WebObject o) {
        return client.nPVehiculoInventarioPut(o);
    }
}
