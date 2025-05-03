/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import gt.edu.umes.broker.connector.client.PinturaClient;
import static gt.edu.umes.broker.core.endpoints.MCSVPintura.*;
/**
 * Clase encargado de gestionar el redireccionamiento de las peticiones a las direcciones correctas.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/broker/__connection__/")
public final class PinturaController {
    @Autowired
    private PinturaClient client;
    /*(non-Javadoc) */
    @PostMapping(PINTURA_SERVICIO_GET)
    public Object getPServicio() {
        return client.nPServicio();
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_SERVICIO_POST)
    public Object getPServicio(@RequestBody Object value) {
        return client.nPServicio(value);
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_SERVICIO_PUT)
    public Object getPServicio(@PathVariable("idServicio") Object id, @RequestBody Object value) {
        return client.nPServicio(id, value);
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_TIPOSERVICIO_GET)
    public Object getPTipoServicio() {
        return client.nPTipoServicio();
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_TIPOSERVICIO_PUT)
    public Object getPTipoServicio(@PathVariable("idTipoServicio") Object id, @RequestBody Object value) {
        return client.nPTipoServicio(id, value);
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_TIPOSERVICIO_POST)
    public Object getPTipoServicio(@RequestBody Object value) {
        return client.nPTipoServicio(value);
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_TIPOVEHICULO_GET)
    public Object getPTipoVehiculo() {
        return client.nPTipoVehiculo();
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_TIPOVEHICULO_POST)
    public Object getPTipoVehiculo(@RequestBody Object value) {
        return client.nPTipoVehiculo(value);
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_TIPOVEHICULO_PUT)
    public Object getPTipoVehiculo(@PathVariable("idTipoVehiculo") Object id, @RequestBody Object value) {
        return client.nPTipoVehiculo(id, value);
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_TIPOPINTURA_GET)
    public Object getPTipoPintura() {
        return client.nPTipoPintura();
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_TIPOPINTURA_POST)
    public Object getPTipoPintura(@RequestBody Object value) {
        return client.nPTipoPintura(value);
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_TIPOPINTURA_PUT)
    public Object getPTipoPintura(@PathVariable("idTipoPintura") Object id, @RequestBody Object value) {
        return client.nPTipoPintura(id, value);
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_INVENTARIO_GET)
    public Object getPInvetario() {
        return client.nPInvetario();
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_INVENTARIO_POST)
    public Object getPInventario(@RequestBody Object value) {
        return client.nPInventario(value);
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_INVENTARIO_PUT)
    public Object getPInventario(@PathVariable("idInventario") Object id, @RequestBody Object value) {
        return client.nPInventario(id, value);
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_MOVIMIENTO_GET)
    public Object getPMovimiento() {
        return client.nPMovimiento();
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_MOVIMIENTO_POST)
    public Object getPMovimiento(@RequestBody Object o) {
        return client.nPMovimiento(o);
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_MOVIMINEOT_PUT)
    public Object getPMovimientoPut(@RequestBody Object o) {
        return client.nPMovimientoPut(o);
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_VENTAS_POST)
    public Object getPVentas(@RequestBody Object o) {
        return client.nPVentas(o);
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_VENTAS_GET)
    public Object nPVentas() {
        return client.nPVentas();
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_VENTAS_PUT)
    public Object getPVentas(@PathVariable("idVenta") Object id, @RequestBody Object o) {
        return client.nPVentas(id, o);
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_DETALLE_VENTA_GET)
    public Object getPDetallVenta(@PathVariable("idVenta") Object id) {
        return client.nPDetallVenta(id);
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_DETALLE_VENTA_POST)
    public Object getPDetalleVenta(@RequestBody Object o) {
        return client.nPDetalleVenta(o);
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_DETALLE_VENTA_PUT)
    public Object getPDetalleVenta(@PathVariable("idDetalleVenta") Object l, @RequestBody Object o) {
        return client.nPDetalleVenta(l, o);
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_DEVOLUCION_GET)
    public Object getPVecolucion() {
        return client.nPVecolucion();
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_DEVOLUCION_POST)
    public Object getPDevolucion(@RequestBody Object o) {
        return client.nPDevolucion(o);
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_VEHICULO_INVENTARIO_GET)
    public Object getPVehiculoInventario() {
        return client.nPVehiculoInventario();
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_VEHICULO_INVENTARIO_POST)
    public Object getPVehiculoInventario(@RequestBody Object o) {
        return client.nPVehiculoInventario(o);
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_VEHICULO_INVENTARIO_PUT)
    public Object getPVehiculoInventarioPut(@RequestBody Object o) {
        return client.nPVehiculoInventarioPut(o);
    }
    /*(non-Javadoc) */
    @PostMapping(PINTURA_PRECIOS_GET)
    public Object getPreciosGet() {
        return client.nPreciosGet();
    }    
    /*(non-Javadoc) */
    @PostMapping(PINTURA_PRECIOS_POST)
    public Object getPreciosPost(@RequestBody Object o) {
        return client.nPreciosPost(o);
    }    
    /*(non-Javadoc) */
    @PostMapping(PINTURA_PRECIOS_PUT)
    public Object getPreciosPut(@PathVariable("id") Object id, @RequestBody Object o) {
        return client.nPreciosPut(id, o);
    }
}
