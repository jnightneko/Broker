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
    @GetMapping(HTTP_SERVICIOS_GET)
    Object nServiciosGet();

    /**
     * Enlace al end-point para crear un servicio
     * @param o objeto de entrada (servicio)
     * @return objeto creado
     */
    @PostMapping(HTTP_SERVICIOS_POST)
    Object nServiciosPost(@RequestBody Object o);

    /**
     * Enlace al end-point para actualizar un servicio
     * @param id id del servicio
     * @param o objeto actualizado
     * @return objeto actualizado
     */
    @PutMapping(HTTP_SERVICIOS_PUT)
    Object nServiciosPut(@PathVariable("id") Object id, @RequestBody Object o);

    /**
     * Enlace al end-point para eliminar (lógicamente) un servicio
     * @param id id del servicio
     * @return mensaje de éxito
     */
    @DeleteMapping(HTTP_SERVICIOS_DELETE)
    Object nServiciosDelete(@PathVariable("id") Object id);

    @GetMapping(HTTP_TIPOSERVICIOS_GET)
    Object nTiposerviciosGet();

    /**
     * Enlace al endpoint para crear un tipo de servicio
     * @param o objeto tipo servicio
     * @return objeto creado
     */
    @PostMapping(HTTP_TIPOSERVICIOS_POST)
    Object nTiposerviciosPost(@RequestBody Object o);

    /**
     * Enlace al endpoint para actualizar un tipo de servicio
     * @param id id del tipo de servicio
     * @param o objeto actualizado
     * @return objeto actualizado
     */
    @PutMapping(HTTP_TIPOSERVICIOS_PUT)
    Object nTiposerviciosPut(@PathVariable("id") Object id, @RequestBody Object o);

    /**
     * Enlace al endpoint para eliminar lógicamente un tipo de servicio
     * @param id id del tipo de servicio
     * @return mensaje de éxito
     */
    @DeleteMapping(HTTP_TIPOSERVICIOS_DELETE)
    Object nTiposerviciosDelete(@PathVariable("id") Object id);

    @GetMapping(HTTP_EMPLEADOS_GET)
    Object nEmpleadosGet();

    /**
     * Enlace al endpoint para crear un nuevo empleado
     * @param o objeto de tipo empleado
     * @return objeto creado
     */
    @PostMapping(HTTP_EMPLEADOS_POST)
    Object nEmpleadosPost(@RequestBody Object o);

    /**
     * Enlace al endpoint para actualizar un empleado
     * @param id id del empleado
     * @param o objeto actualizado
     * @return objeto actualizado
     */
    @PutMapping(HTTP_EMPLEADOS_PUT)
    Object nEmpleadosPut(@PathVariable("id") Object id, @RequestBody Object o);

    /**
     * Enlace al endpoint para eliminar (lógicamente) un empleado
     * @param id id del empleado
     * @return mensaje de éxito
     */
    @DeleteMapping(HTTP_EMPLEADOS_DELETE)
    Object nEmpleadosDelete(@PathVariable("id") Object id);

    @GetMapping(HTTP_CLIENTES_GET)
    Object nClientesGet();

    /**
     * Enlace al endpoint para crear un nuevo cliente
     * @param o objeto cliente
     * @return cliente creado
     */
    @PostMapping(HTTP_CLIENTES_POST)
    Object nClientesPost(@RequestBody Object o);

    /**
     * Enlace al endpoint para actualizar un cliente por ID
     * @param id id del cliente
     * @param o objeto cliente actualizado
     * @return cliente actualizado
     */
    @PutMapping(HTTP_CLIENTES_PUT)
    Object nClientesPut(@PathVariable("id") Object id, @RequestBody Object o);

    /**
     * Enlace al endpoint para eliminar (lógicamente) un cliente
     * @param id id del cliente
     * @return mensaje de éxito
     */
    @DeleteMapping(HTTP_CLIENTES_DELETE)
    Object nClientesDelete(@PathVariable("id") Object id);

    @GetMapping(HTTP_VEHICULOS_GET)
    Object nVehiculosGet();

    /**
     * Enlace al endpoint para crear un nuevo vehículo
     * @param o objeto vehículo
     * @return vehículo creado
     */
    @PostMapping(HTTP_VEHICULOS_POST)
    Object nVehiculosPost(@RequestBody Object o);

    /**
     * Enlace al endpoint para actualizar un vehículo por ID
     * @param id id del vehículo
     * @param o objeto vehículo actualizado
     * @return vehículo actualizado
     */
    @PutMapping(HTTP_VEHICULOS_PUT)
    Object nVehiculosPut(@PathVariable("id") Object id, @RequestBody Object o);

    /**
     * Enlace al endpoint para eliminar (lógicamente) un vehículo
     * @param id id del vehículo
     * @return mensaje de éxito
     */
    @DeleteMapping(HTTP_VEHICULOS_DELETE)
    Object nVehiculosDelete(@PathVariable("id") Object id);

    @GetMapping(HTTP_VENTAS_GET)
    Object nVentasGet();

    /**
     * Enlace al endpoint para crear una nueva venta
     * @param o objeto venta
     * @return venta creada
     */
    @PostMapping(HTTP_VENTAS_POST)
    Object nVentasPost(@RequestBody Object o);

    /**
     * Enlace al endpoint para actualizar una venta por ID
     * @param id id de la venta
     * @param o objeto venta con los datos actualizados
     * @return venta actualizada
     */
    @PutMapping(HTTP_VENTAS_PUT)
    Object nVentasPut(@PathVariable("id") Object id, @RequestBody Object o);

    /**
     * Enlace al endpoint para eliminar (lógicamente) una venta
     * @param id id de la venta
     * @return mensaje de éxito
     */
    @DeleteMapping(HTTP_VENTAS_DELETE)
    Object nVentasDelete(@PathVariable("id") Object id);

    @GetMapping(HTTP_CATEGORIAS_GET)
    Object nCategoriasGet();

    /**
     * Enlace al endpoint para crear un nuevo vehículo
     * @param o objeto vehículo
     * @return vehículo creado
     */
    @PostMapping(HTTP_CATEGORIAS_POST)
    Object nCategoriasPost(@RequestBody Object o);

    /**
     * Actualizar categoría existente
     * @param id ID de la categoría a actualizar
     * @param o Objeto con los nuevos datos
     * @return Mensaje de éxito
     */
    @PutMapping(HTTP_CATEGORIAS_PUT)
    Object nCategoriasPut(@PathVariable("id") Object id, @RequestBody Object o);

    /**
     * Eliminar (lógicamente) una categoría
     * @param id ID de la categoría a eliminar
     * @return Mensaje de éxito
     */
    @DeleteMapping(HTTP_CATEGORIAS_DELETE)
    Object nCategoriasDelete(@PathVariable("id") Object id);

    @GetMapping(HTTP_PRODUCTOS_GET)
    Object nProductosGet();

    /**
     * Enlace al endpoint para crear un nuevo producto
     * @param o objeto producto
     * @return mensaje de éxito
     */
    @PostMapping(HTTP_PRODUCTOS_POST)
    Object nProductosPost(@RequestBody Object o);

    /**
     * Enlace al endpoint para actualizar un producto por ID
     * @param id id del producto
     * @param o objeto producto actualizado
     * @return mensaje de éxito
     */
    @PutMapping(HTTP_PRODUCTOS_PUT)
    Object nProductosPut(@PathVariable("id") Object id, @RequestBody Object o);

    /**
     * Enlace al endpoint para eliminar (lógicamente) un producto
     * @param id id del producto
     * @return mensaje de éxito
     */
    @DeleteMapping(HTTP_PRODUCTOS_DELETE)
    Object nProductosDelete(@PathVariable("id") Object id);

    @GetMapping(HTTP_INVENTARIOS_GET)
    Object nInventariosGet();

    /**
     * Enlace al endpoint para crear un nuevo lote de inventario
     * @param o objeto inventario
     * @return mensaje de éxito
     */
    @PostMapping(HTTP_INVENTARIOS_POST)
    Object nInventariosPost(@RequestBody Object o);

    /**
     * Enlace al endpoint para actualizar un lote de inventario por ID
     * @param id id del lote
     * @param o objeto inventario actualizado
     * @return mensaje de éxito
     */
    @PutMapping(HTTP_INVENTARIOS_PUT)
    Object nInventariosPut(@PathVariable("id") Object id, @RequestBody Object o);

    /**
     * Enlace al endpoint para eliminar (lógicamente) un lote de inventario
     * @param id id del lote
     * @return mensaje de éxito
     */
    @DeleteMapping(HTTP_INVENTARIOS_DELETE)
    Object nInventariosDelete(@PathVariable("id") Object id);

    @GetMapping(HTTP_MOVIMIENTOS_GET)
    Object nMovimientosGet();

    /**
     * Enlace al endpoint para crear un nuevo movimiento
     * @param o objeto movimiento
     * @return mensaje de éxito
     */
    @PostMapping(HTTP_MOVIMIENTOS_POST)
    Object nMovimientosPost(@RequestBody Object o);

    /**
     * Enlace al endpoint para actualizar un movimiento por ID
     * @param id id del movimiento
     * @param o objeto movimiento actualizado
     * @return mensaje de éxito
     */
    @PutMapping(HTTP_MOVIMIENTOS_PUT)
    Object nMovimientosPut(@PathVariable("id") Object id, @RequestBody Object o);

    /**
     * Enlace al endpoint para eliminar un movimiento
     * @param id id del movimiento
     * @return mensaje de éxito
     */
    @DeleteMapping(HTTP_MOVIMIENTOS_DELETE)
    Object nMovimientosDelete(@PathVariable("id") Object id);

    @GetMapping(HTTP_PRECIO_HISTORIAL_GET)
    Object nPrecioHistorialGet();

    /**
     * Endpoint to create new price history record
     * @param o price history object
     * @return success message
     */
    @PostMapping(HTTP_PRECIO_HISTORIAL_POST)
    Object nPrecioHistorialPost(@RequestBody Object o);

    /**
     * Endpoint to update price history by ID
     * @param id record ID
     * @param o updated price history object
     * @return success message
     */
    @PutMapping(HTTP_PRECIO_HISTORIAL_PUT)
    Object nPrecioHistorialPut(@PathVariable("id") Object id, @RequestBody Object o);

    /**
     * Endpoint to delete price history record
     * @param id record ID
     * @return success message
     */
    @DeleteMapping(HTTP_PRECIO_HISTORIAL_DELETE)
    Object nPrecioHistorialDelete(@PathVariable("id") Object id);

    @GetMapping(HTTP_DEVOLUCION_GET)
    Object nDevolucionGet();

    @GetMapping(HTTP_DEVOLUCION_GET_ID)
    Object nDevolucionGetById(@PathVariable("id") Object id);

    /**
     * Endpoint to create new devolution
     * @param o devolution object
     * @return success message
     */
    @PostMapping(HTTP_DEVOLUCION_POST)
    Object nDevolucionPost(@RequestBody Object o);

    @GetMapping(HTTP_BANCOS_GET)
    Object nBancosGet();

    @GetMapping(HTTP_METODOS_PAGO_GET)
    Object nMetodosPagoGet();

    @GetMapping(HTTP_SERVICIOS_TRANSACCION_GET)
    Object nServiciosTransaccionGet();

    @GetMapping(HTTP_CLIENTES_PAGO_GET)
    Object nClientesPagoGet();

    @GetMapping(HTTP_VERIFICAR_CLIENTE_GET)
    Object nVerificarClienteGet(@PathVariable("nit") Object nit);

    @PostMapping(HTTP_PROCESAR_VENTA_PAGO_POST)
    Object nProcesarVentaPagoPost(@RequestBody Object o);

    @PostMapping(HTTP_PROCESAR_VENTA_INVENTARIO_POST)
    Object nProcesarVentaInventarioPost(@RequestBody Object o);

    @PostMapping(HTTP_PROCESAR_PAGO_POST)
    Object nProcesarPagoPost(@PathVariable("idVenta") Object idVenta, @RequestBody Object o);

    @GetMapping(HTTP_TRANSACCION_GET)
    Object nTransaccionGet(@PathVariable("noTransaccion") Object noTransaccion);

    @PutMapping(HTTP_ANULAR_TRANSACCION_PUT)
    Object nAnularTransaccionPut(@PathVariable("noTransaccion") Object noTransaccion, @RequestBody Object o);

    @PostMapping(HTTP_PRODUCTOS_ABASTECER_POST)
    Object nProductosAbastecerPost(@RequestBody Object o);
}
