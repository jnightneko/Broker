/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.client;

import gt.edu.umes.broker.core.Microservice;
import static gt.edu.umes.broker.core.endpoints.MCSVPintura.*;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Clase encargado de gestionar la conexión con el servicio de 'Pagos', objeto encargado de implementar los
 * enlaces a los endpoints de dicho servicios.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(value = "MCSV-TallerPinturaClient", url = Microservice.MICROSERVICE_PINTURA)
public interface PinturaClient {    
    /**
     * Obtener todos los servicios disponibles
     * @return objeto json
     */
    @GetMapping(PINTURA_SERVICIO_GET)
    public Object nPServicio();
    /**
     * Crear un nuevo servicio
     * @param value object
     * 
     * @return objeto json
     */
    @PostMapping(PINTURA_SERVICIO_POST)
    public Object nPServicio(@RequestBody Object value);
    /**
     * Acutalizar un servicio
     * 
     * @param id number|object id
     * @param value object
     * 
     * @return objeto json
     */
    @PutMapping(PINTURA_SERVICIO_PUT)
    public Object nPServicio(@PathVariable("idServicio") Object id, @RequestBody Object value);    
    /**
     * Obtener todos los tipos de servicio
     * @return objeto json
     */
    @GetMapping(PINTURA_TIPOSERVICIO_GET)
    public Object nPTipoServicio();    
    /**
     * Actualizar un tipo de servicio
     * 
     * @param id number|object id
     * @param value object
     * 
     * @return objeto json
     */
    @PutMapping(PINTURA_TIPOSERVICIO_PUT)
    public Object nPTipoServicio(@PathVariable("idTipoServicio") Object id, @RequestBody Object value);
    /**
     * Crear un nuevo tipo de servicio
     * @param value object
     * 
     * @return objeto json
     */
    @PostMapping(PINTURA_TIPOSERVICIO_POST)
    public Object nPTipoServicio(@RequestBody Object value);
    /**
     * Obtener todos los tipos de vehículo
     * @return objeto json
     */
    @GetMapping(PINTURA_TIPOVEHICULO_GET)
    public Object nPTipoVehiculo();    
    /**
     * Crear un nuevo tipo de vehículo
     * @param value object
     * 
     * @return objeto json
     */
    @PostMapping(PINTURA_TIPOVEHICULO_POST)
    public Object nPTipoVehiculo(@RequestBody Object value);
    /**
     * Actualizar un tipo de vehículo específico
     * 
     * @param id number|object id
     * @param value object
     * 
     * @return objeto json
     */
    @PutMapping(PINTURA_TIPOVEHICULO_PUT)
    public Object nPTipoVehiculo(@PathVariable("idTipoVehiculo") Object id, @RequestBody Object value);
    /**
     * Obtener todos los tipos de pintura disponibles
     * @return objeto json
     */
    @GetMapping(PINTURA_TIPOPINTURA_GET)
    public Object nPTipoPintura();
    /**
     * Crear un nuevo tipo de pintura
     * @param value objeto web
     * @return objeto web
     */
    @PostMapping(PINTURA_TIPOPINTURA_POST)
    public Object nPTipoPintura(@RequestBody Object value);
    /**
     * Actualizar un tipo de pintura
     * @param id id:long
     * @param value objeto web
     * @return objeto web
     */
    @PutMapping(PINTURA_TIPOPINTURA_PUT)
    public Object nPTipoPintura(@PathVariable("idTipoPintura") Object id, @RequestBody Object value);
    /**
     * Obtener todos los inventarios
     * @return objeto web
     */
    @GetMapping(PINTURA_INVENTARIO_GET)
    public Object nPInvetario();
    /**
     * Crear un nuevo inventario
     * @param value objeto web
     * @return objeto web
     */
    @PostMapping(PINTURA_INVENTARIO_POST)
    public Object nPInventario(@RequestBody Object value);
    /**
     * Actualizar un tipo de inventario
     * @param id id|long
     * @param value objeto web
     * @return objeto web
     */
    @PutMapping(PINTURA_INVENTARIO_PUT)
    public Object nPInventario(@PathVariable("idInventario") Object id, @RequestBody Object value);
    /**
     * Obtener todos los movimientos de inventario
     * @return objeto web
     */
    @GetMapping(PINTURA_MOVIMIENTO_GET)
    public Object nPMovimiento();
    /**
     * Crear un nuevo movimiento de inventarios
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(PINTURA_MOVIMIENTO_POST)
    public Object nPMovimiento(@RequestBody Object o);
    /**
     * Actualizar un movimiento de inventario
     * @param id objeto web
     * @param o objeto web
     * @return objeto web
     */
    @PutMapping(PINTURA_MOVIMINEOT_PUT)
    public Object nPMovimientoPut(@PathVariable("movimiento_id") Object id, @RequestBody Object o);
    /**
     * Crear una nueva venta
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(PINTURA_VENTAS_POST)
    public Object nPVentas(@RequestBody Object o);
    /**
     * Obtener todas las ventas
     * @return objeto web
     */
    @GetMapping(PINTURA_VENTAS_GET)
    public Object nPVentas();
    /**
     * Actualizar una venta
     * @param id id|long
     * @param o objeto web
     * @return objeto web
     */
    @PutMapping(PINTURA_VENTAS_PUT)
    public Object nPVentas(@PathVariable("venta_id") Object id, @RequestBody Object o);
    /**
     * Obtener el detalle de una venta específica
     * @param id id|long
     * @return objeto web
     */
    @GetMapping(PINTURA_DETALLE_VENTA_GET)
    public Object nPDetallVenta(@PathVariable("idVenta") Object id);
    /**
     * Crear un nuevo detalle de venta
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(PINTURA_DETALLE_VENTA_POST)
    public Object nPDetalleVenta(@RequestBody Object o);
    /**
     * Actualizar un detalle de venta
     * @param l id|long
     * @param o objeto web
     * @return objeto web
     */
    @PutMapping(PINTURA_DETALLE_VENTA_PUT)
    public Object nPDetalleVenta(@PathVariable("idDetalleVenta") Object l, @RequestBody Object o);
    /**
     * Obtener todas las devoluciones
     * @return objeto web
     */
    @GetMapping(PINTURA_DEVOLUCION_GET)
    public Object nPVecolucion();
    /**
     * Crear una nueva devlución
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(PINTURA_DEVOLUCION_POST)
    public Object nPDevolucion(@RequestBody Object o);
    /**
     * Obtener todos los inventarios de vehiculo
     * @return objeto web
     */
    @GetMapping(PINTURA_VEHICULO_INVENTARIO_GET)
    public Object nPVehiculoInventario();
    /**
     * Crear un nuevo inventario de vehiculo
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(PINTURA_VEHICULO_INVENTARIO_POST)
    public Object nPVehiculoInventario(@RequestBody Object o);
    /**
     * Actualizar un inventario de vehiculo
     * @param o objeto web
     * @return objeto web
     */
    @PutMapping(PINTURA_VEHICULO_INVENTARIO_PUT)
    public Object nPVehiculoInventarioPut(@RequestBody Object o);
    
    /**
     * Obtiene precios de servicios
     * @return objeto web
     */
    @GetMapping(PINTURA_PRECIOS_GET)
    public Object nPreciosGet();    
    /**
     * Ingresa precios de servicios
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(PINTURA_PRECIOS_POST)
    public Object nPreciosPost(@RequestBody Object o);
    
    /**
     * Actualizar precios servicios
     * @param id id|long
     * @param o objeto web
     * @return objeto web
     */
    @PutMapping(PINTURA_PRECIOS_PUT)
    public Object nPreciosPut(@PathVariable("id") Object id, @RequestBody Object o);
}
