/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.client;

import gt.edu.umes.broker.connector.http.WebObject;
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
@FeignClient(value = "MCSV-TallerPinturaClient", url = "http://localhost:8000/")
public interface TallerPinturaClient {
    
    /**
     * Obtener todos los servicios disponibles
     * @return objeto json
     */
    @GetMapping(PINTURA_SERVICIO_GET)
    public WebObject nPServicio();
    public static final String PINTURA_SERVICIO_GET             = "pintura/GET/servicios";
    
    /**
     * Crear un nuevo servicio
     * @param value object
     * 
     * @return objeto json
     */
    @PostMapping(PINTURA_SERVICIO_POST)
    public WebObject nPServicio(@RequestBody WebObject value);
    public static final String PINTURA_SERVICIO_POST            = "pintura/POST/servicios";
    
    /**
     * Acutalizar un servicio
     * 
     * @param id number|object id
     * @param value object
     * 
     * @return objeto json
     */
    @PutMapping(PINTURA_SERVICIO_PUT)
    public WebObject nPServicio(@PathVariable("idServicio") Long id, @RequestBody WebObject value);
    public static final String PINTURA_SERVICIO_PUT             = "pintura/PUT/servicios/{idServicio}";
    
    /**
     * Obtener todos los tipos de servicio
     * @return objeto json
     */
    @GetMapping(PINTURA_TIPOSERVICIO_GET)
    public WebObject nPTipoServicio();
    public static final String PINTURA_TIPOSERVICIO_GET         = "pintura/GET/tiposervicios";
    
    /**
     * Actualizar un tipo de servicio
     * 
     * @param id number|object id
     * @param value object
     * 
     * @return objeto json
     */
    @PutMapping(PINTURA_TIPOSERVICIO_PUT)
    public WebObject nPTipoServicio(@PathVariable("idTipoServicio") Long id, @RequestBody WebObject value);
    public static final String PINTURA_TIPOSERVICIO_PUT        = "pintura/PUT/tiposervicios/{idTipoServicio}";
    
    /**
     * Crear un nuevo tipo de servicio
     * @param value object
     * 
     * @return objeto json
     */
    @PostMapping(PINTURA_TIPOSERVICIO_POST)
    public WebObject nPTipoServicio(@RequestBody WebObject value);
    public static final String PINTURA_TIPOSERVICIO_POST        = "pintura/POST/tiposervicios";
    
    /**
     * Obtener todos los tipos de vehículo
     * @return objeto json
     */
    @GetMapping(PINTURA_TIPOVEHICULO_GET)
    public WebObject nPTipoVehiculo();
    public static final String PINTURA_TIPOVEHICULO_GET         = "pintura/GET/tiposvehiculos";
    
    /**
     * Crear un nuevo tipo de vehículo
     * @param value object
     * 
     * @return objeto json
     */
    @PostMapping(PINTURA_TIPOVEHICULO_POST)
    public WebObject nPTipoVehiculo(@RequestBody WebObject value);
    public static final String PINTURA_TIPOVEHICULO_POST        = "pintura/POST/tipovehiculos";
    
    /**
     * Actualizar un tipo de vehículo específico
     * 
     * @param id number|object id
     * @param value object
     * 
     * @return objeto json
     */
    @PutMapping(PINTURA_TIPOVEHICULO_PUT)
    public WebObject nPTipoVehiculo(@PathVariable("idTipoVehiculo") Long id, @RequestBody WebObject value);
    public static final String PINTURA_TIPOVEHICULO_PUT         = "pintura/PUT/tiposvehiculos/{idTipoVehiculo}";
    
    /**
     * Obtener todos los tipos de pintura disponibles
     * @return objeto json
     */
    @GetMapping(PINTURA_TIPOPINTURA_GET)
    public WebObject nPTipoPintura();
    public static final String PINTURA_TIPOPINTURA_GET          = "pintura/GET/tipospinturas";
    
    /*
        Crear un nuevo tipo de pintura
    */
    @PostMapping(PINTURA_TIPOPINTURA_POST)
    public WebObject nPTipoPintura(@RequestBody WebObject value);
    public static final String PINTURA_TIPOPINTURA_POST         = "pintura/POST/tipopinturas";
    
    /*
        Actualizar un tipo de pintura
    */
    @PutMapping(PINTURA_TIPOPINTURA_PUT)
    public WebObject nPTipoPintura(@PathVariable("idTipoPintura") Long id, @RequestBody WebObject value);
    public static final String PINTURA_TIPOPINTURA_PUT          = "pintura/PUT/tipopinturas/{idTipoPintura}";
    
    /*
        Obtener todos los inventarios
    */
    @GetMapping(PINTURA_INVENTARIO_GET)
    public WebObject nPInvetario();
    public static final String PINTURA_INVENTARIO_GET           = "pintura/GET/inventarios";
    
    /*
        Crear un nuevo inventario
    */
    @PostMapping(PINTURA_INVENTARIO_POST)
    public WebObject nPInventario(@RequestBody WebObject value);
    public static final String PINTURA_INVENTARIO_POST          = "pintura/POST/inventarios";
    
    /*
        Actualizar un tipo de inventario
    */
    @PutMapping(PINTURA_INVENTARIO_PUT)
    public WebObject nPInventario(@PathVariable("idInventario") Long id, @RequestBody WebObject value);
    public static final String PINTURA_INVENTARIO_PUT           = "pintura/PUT/inventarios/{idInventario}";
    
    /*
        Obtener todos los movimientos de inventario
    */
    @GetMapping(PINTURA_MOVIMIENTO_GET)
    public WebObject nPMovimiento();
    public static final String PINTURA_MOVIMIENTO_GET           = "pintura/GET/movimientos";
    
    /*
        Crear un nuevo movimiento de inventarios
    */
    @PostMapping(PINTURA_MOVIMIENTO_POST)
    public WebObject nPMovimiento(@RequestBody WebObject o);
    public static final String PINTURA_MOVIMIENTO_POST          = "pintura/POST/movimientos";
    
    /*
        Actualizar un movimiento de inventario
    */
    @PutMapping(PINTURA_MOVIMINEOT_PUT)
    public WebObject nPMovimientoPut(@RequestBody WebObject o);
    public static final String PINTURA_MOVIMINEOT_PUT           = "pintura/PUT/movimientos";
    
    /*
        Crear una nueva venta
    */
    @PostMapping(PINTURA_VENTAS_POST)
    public WebObject nPVentas(@RequestBody WebObject o);
    public static final String PINTURA_VENTAS_POST               = "pintura/POST/ventas";
    
    /*
        Obtener todas las ventas
    */
    @GetMapping(PINTURA_VENTAS_GET)
    public WebObject nPVentas();
    public static final String PINTURA_VENTAS_GET                = "pintura/GET/ventas";
    
    /*
        Actualizar una venta
    */
    @PutMapping(PINTURA_VENTAS_PUT)
    public WebObject nPVentas(@PathVariable("idVenta") Long id, @RequestBody WebObject o);
    public static final String PINTURA_VENTAS_PUT                = "pintura/PUT/ventas/{idVenta}";
    
    /*
        Obtener el detalle de una venta específica
    */
    @GetMapping(PINTURA_DETALLE_VENTA_GET)
    public WebObject nPDetallVenta(@PathVariable("idVenta") Long id);
    public static final String PINTURA_DETALLE_VENTA_GET         = "pintura/GET/detalleventas/{idVenta}";
    
    /*
        rear un nuevo detalle de venta
    */
    @PostMapping(PINTURA_DETALLE_VENTA_POST)
    public WebObject nPDetalleVenta(@RequestBody WebObject o);
    public static final String PINTURA_DETALLE_VENTA_POST       = "pintura/POST/detalleventas";
    
    /*
        Actualizar un detalle de venta
    */
    @PutMapping(PINTURA_DETALLE_VENTA_PUT)
    public WebObject nPDetalleVenta(@PathVariable("idDetalleVenta") Long l, @RequestBody WebObject o);
    public static final String PINTURA_DETALLE_VENTA_PUT         = "pintura/PUT/detalleventas/{idDetalleVenta}";
    
    /*
        Obtener todas las devoluciones
    */
    @GetMapping(PINTURA_DEVOLUCION_GET)
    public WebObject nPVecolucion();
    public static final String PINTURA_DEVOLUCION_GET            = "pintura/GET/devolucion";
    
    /*
        Crear una nueva devlución
    */
    @PostMapping(PINTURA_DEVOLUCION_POST)
    public WebObject nPDevolucion(@RequestBody WebObject o);
    public static final String PINTURA_DEVOLUCION_POST           = "pintura/POST/devolucion";
    
    /*
        Obtener todos los inventarios de vehiculo
    */
    @GetMapping(PINTURA_VEHICULO_INVENTARIO_GET)
    public WebObject nPVehiculoInventario();
    public static final String PINTURA_VEHICULO_INVENTARIO_GET   = "pintura/GET/vehiculoinventarios";
    
    /*
        Crear un nuevo inventario de vehiculo
    */
    @PostMapping(PINTURA_VEHICULO_INVENTARIO_POST)
    public WebObject nPVehiculoInventario(@RequestBody WebObject o);
    public static final String PINTURA_VEHICULO_INVENTARIO_POST  = "pintura/POST/vehiculoinventarios";
    
    /*
        Actualizar un inventario de vehiculo
    */
    @PutMapping(PINTURA_VEHICULO_INVENTARIO_PUT)
    public WebObject nPVehiculoInventarioPut(@RequestBody WebObject o);
    public static final String PINTURA_VEHICULO_INVENTARIO_PUT   = "pintura/PUT/vehiculoinventarios";
}
