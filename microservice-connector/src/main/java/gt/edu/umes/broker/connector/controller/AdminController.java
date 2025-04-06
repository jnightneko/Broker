/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.controller;

import gt.edu.umes.broker.connector.http.WebObject;
import static gt.edu.umes.broker.connector.client.AdminClient.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import gt.edu.umes.broker.connector.client.AdminClient;

/**
 * Clase encargado de gestionar el redireccionamiento de las peticiones a las direcciones correctas.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/broker/__connection__/")
public class AdminController {
    @Autowired
    private AdminClient client;
    /*
        Consultar la información de todos los empleados.
    */
    @PostMapping(HTTP_ADMIN_EMPLEADOS_GET)
    public WebObject getAdminEmpleadoGet() {
        return client.nAdminEmpleadoGet();
    }
    
    /*
        Consultar la información de un empleado en específico.
    */
    @PostMapping(HTTP_ADMIN_EMPLEAODS_GET_ID)
    public WebObject getAdmminEmpleadoGetId(@PathVariable("id") Long id) {
        return client.nAdmminEmpleadoGetId(id);
    }
    
    /*
        Insertar un registro de empleado
    */
    @PostMapping(HTTP_ADMIN_EMPLEADOS_POST)
    public WebObject getAdminEmpleadoPost(@RequestBody WebObject o) {
        return client.nAdminEmpleadoPost(o);
    }
    
    /*
        Actualizar la información de un empleado específico
    */
    @PostMapping(HTTP_ADMIN_EMPLEADOS_PUT)
    public WebObject getAdmimEmpleadoPut(@PathVariable("id") Long id, @RequestBody WebObject o) {
        return client.nAdmimEmpleadoPut(id, o);
    }
    
    /*
        Consultar todas las alertas actuales para abastecimiento de pedidos
    */
    @PostMapping(HTTP_ADMIN_ALERTAS_GET)
    public WebObject getAdminAlertasGet() {
        return client.nAdminAlertasGet();
    }
    
    /*
        Consultar una alerta específica para abastecimiento de pedidos
    */
    @PostMapping(HTTP_ADMIN_ALETAS_GET_ID)
    public WebObject getAdminAlertasGetId(@PathVariable("id") Long id) {
        return client.nAdminAlertasGetId(id);
    }
    
    /*
        Alertas: Tienda
    */
    @PostMapping(HTTP_ADMIN_ALERTAS_TINDA_CONVENIENCIA)
    public WebObject getAdminAlertaTinedaConveniencia(@RequestBody WebObject o) {
        return client.nAdminAlertaTinedaConveniencia(o);
    }
    
    /*
        Alertas: Gasolinear
    */
    @PostMapping(HTTP_ADMIN_ALERTAS_GASOLINERA)
    public WebObject getAdminAlertaGasolinera(@RequestBody WebObject o) {
        return client.nAdminAlertaGasolinera(o);
    }
    
    /*
        Alertas: Repuesto
    */
    @PostMapping(HTTP_ADMIN_ALERTAS_REPUESTO)
    public WebObject getAdminAlertasRepuetos(@RequestBody WebObject o) {
        return client.nAdminAlertasRepuetos(o);
    }
    
    /*
        Alertas: RPintura
    */
    @PostMapping(HTTP_ADMIN_ALERTAS_PINTURA)
    public WebObject getAdminPintura(@RequestBody WebObject o) {
        return client.nAdminPintura(o);
    }
    
    /*
        Consultar todas las áreas (secciones) dentro de la gasolinera
    */
    @PostMapping(HTTP_ADMIN_AREAS_GET)
    public WebObject getAdminAreasGet() {
        return client.nAdminAreasGet();
    }
    
    /*
        Consultar un área (sección) específica dentro de la gasolinera
    */
    @PostMapping(HTTP_ADMIN_AREAS_GET_ID)
    public WebObject getAdminAreasGetId(@PathVariable("id") Long id) {
        return client.nAdminAreasGetId(id);
    }
    
    /*
        Consultar todos los roles que puede ocupar un empleado dentro de un área
    */
    @PostMapping(HTTP_ADMIN_ROLES_GET)
    public WebObject nAdminRoles() {
        return client.nAdminRoles();
    }
    
    /*
        Consultar un rol específico que puede ocupar un empleado dentro de un área.
    */
    @PostMapping(HTTP_ADMIN_ROLES_GET_ID)
    public WebObject getAdminRolesId(@PathVariable("id") Long id) {
        return client.nAdminRolesId(id);
    }
    
    /*
        insertar un nuevo rol que puede ocupar un empleado dentro de un área.
    */
    @PostMapping(HTTP_ADMIN_ROLES_POST)
    public WebObject getAdminRolesPost(@RequestBody WebObject o) {
        return client.nAdminRolesPost(o);
    }
    
    /*
        Editar un rol existente.
    */
    @PostMapping(HTTP_ADMIN_ROLES_PUT)
    public WebObject nAdminRolesPut(@PathVariable("id") Long id, @RequestBody WebObject o) {
        return client.nAdminRolesPut(id, o);
    }
    
    /*
        Consultar todas las jornadas laborales.
    */
    @PostMapping(HTTP_ADMIN_JORNADAS_GET)
    public WebObject getAdminJornadasGet() {
        return client.nAdminJornadasGet();
    }
    
    /*
        Consultar una jornada laboral específica.
    */
    @PostMapping(HTTP_ADMIN_JORNADAS_GET_ID)
    public WebObject getAdminJornadasGetId(@PathVariable("id") Long id) {
        return client.nAdminJornadasGetId(id);
    }
    
    /*
        Consultar a todos los proveedores.
    */
    @PostMapping(HTTP_ADMIN_PROVEEDORES_GET)
    public WebObject getAdminProveedoresGet() {
        return client.nAdminProveedoresGet();
    }
    
    /*
        Consultar un proveedor en específico.
    */
    @PostMapping(HTTP_ADMIN_PROVEEDORES_GET_ID)
    public WebObject getAmindProveedoresGetId(@PathVariable("id") Long id) {
        return client.nAmindProveedoresGetId(id);
    }
    
    /*
        Insertar un nuevo proveedor.
    */
    @PostMapping(HTTP_ADMIN_PROVEEDORES_POST)
    public WebObject getAdminProveedoresPost(@RequestBody WebObject o) {
        return client.nAdminProveedoresPost(o);
    }
    
    /*
        Editar la información de un proveedor específico.
    */
    @PostMapping(HTTP_ADMIN_PROVEEDORES_PUT)
    public WebObject getAdminProveedoresPut(@PathVariable("id") Long id, @RequestBody WebObject o) {
        return client.nAdminProveedoresPut(id, o);
    }
    
    /*
        Consultar la información de todos los servicios.
    */
    @PostMapping(HTTP_ADMIN_SERVICIO_GET)
    public WebObject nAdminServicioGet() {
        return client.nAdminServicioGet();
    }
    
    /*
        Consultar la información de un servicio específico.
    */
    @PostMapping(HTTP_ADMIN_SERVICIO_GET_ID)
    public WebObject getAdminServicioGetId(@PathVariable("id") Long id) {
        return client.nAdminServicioGetId(id);
    }
    
    /*
        Consultar la información de todos los tipos de movimientos.
    */
    @PostMapping(HTTP_ADMIN_MOVIMIENTO_GET)
    public WebObject nAdminMovGet() {
        return client.nAdminMovGet();
    }
    
    /*
        Consultar la información de un tipo de movimiento específico.
    */
    @PostMapping(HTTP_ADMIN_MOVIMIENTO_GET_ID)
    public WebObject nAdminMovGetId(@PathVariable("id") Long id) {
        return client.nAdminMovGetId(id);
    }
    
    /*
        Devuelve el reporte de todos los movimientos.
    */
    @PostMapping(HTTP_ADMIN_MOVIMIENTO_GET_TODO)
    public WebObject getAdminMovTodo() {
        return client.nAdminMovTodo();
    }
    
    /*
        Devuelve el reporte de movimientos de un dia especifico
    */
    @PostMapping(HTTP_ADMIN_MOVIMIENTO_GET_DIARIO)
    public WebObject getAdminMovDiario(@RequestBody WebObject o) {
        return client.nAdminMovDiario(o);
    }
    
    /*
        Devuelve el reporte de movimientos de un mes específico
    */
    @PostMapping(HTTP_ADMIN_MIVIMIENTO_GET_MESULA)
    public WebObject getAdminMovMensual(@RequestBody WebObject o) {
        return client.nAdminMovMensual(o);
    }
    
    /*
        Devuelve el reporte de movimientos de un trimestre específico
    */
    @PostMapping(HTTP_ADMIN_MIVIMIENTO_GET_TRIMESTRAL)
    public WebObject getAdminMovTrimestral(@RequestBody WebObject o) {
        return client.nAdminMovTrimestral(o);
    }
    
    /*
        Devuelve el reporte de movimientos de un dia especifico
    */
    @PostMapping(HTTP_ADMIN_MIVIMIENTO_GET_SEMESTRAL)
    public WebObject getAdminMovSmestral(@RequestBody WebObject o) {
        return client.nAdminMovSmestral(o);
    }
    
    /*
        Devuelve el reporte de movimientos de un año específico
    */
    @PostMapping(HTTP_ADMIN_MIVIMIENTO_GET_ANUAL)
    public WebObject getAdminMovAnual(@RequestBody WebObject o) {
        return client.nAdminMovAnual(o);
    }
    
    /*
        Ver las asistencias de un empleado específico
    */
    @PostMapping(HTTP_ADMIN_ASISTENCIA_GET)
    public WebObject getAdminMovAsistencia(@PathVariable("id") Long id, @RequestBody WebObject o) {
        return client.nAdminMovAsistencia(id, o);
    }
    
    /*
        Registrar asistencia de un empleado específico
    */
    @PostMapping(HTTP_ADMIN_ASISTENCIA_POST)
    public WebObject getAdminAsistenciaPost(@RequestBody WebObject o) {
        return client.nAdminAsistenciaPost(o);
    }
    
    /*
        Ver las inasistencias de un empleado específico
    */
    @PostMapping(HTTP_ADMIN_INASISTENCIA_GET)
    public WebObject getAdminInasistenicaGet(@PathVariable("id") Long id) {
        return client.nAdminInasistenicaGet(id);
    }
    
    /*
        Consultar la información básica de todas las órdenes.
    */
    @PostMapping(HTTP_ADMIN_ORDENES_GET)
    public WebObject getAdminOrdenesGet() {
        return client.nAdminOrdenesGet();
    }
    
    /*
        Consultar la información básica de una orden específica.
    */
    @PostMapping(HTTP_ADMIN_ORDENES_GET_ID)
    public WebObject getAdminOrdendeGetId(@PathVariable("id") Long id) {
        return client.nAdminOrdendeGetId(id);
    }
    
    /*
        Registrar una orden.
    */
    @PostMapping(HTTP_ADMIN_ORDENDES_POST)
    public WebObject getAdminOrdenesPost(@RequestBody WebObject o) {
        return client.nAdminOrdenesPost(o);
    }
    
    /*
        Permite cambiar el estado actual de la orden (pedido realizado, pedido en camino, etc). Útil para rastreo de la misma.
    */
    @PostMapping(HTTP_ADMIN_ORDENDES_MODIFICAR_ESTADO)
    public WebObject getAdminOrdenesModificarEstado(@PathVariable("id") Long id, @RequestBody WebObject o) {
        return client.nAdminOrdenesModificarEstado(id, o);
    }
    
    /*
        Ver los productos relacionados a una orden específica.
    */
    @PostMapping(HTTP_ADMIN_ORDENES_DETALLE)
    public WebObject getAdminOrdenesDetalle(@PathVariable("id_orden") Long id) {
        return client.nAdminOrdenesDetalle(id);
    }
    
    /*
        Editar estado de 1 producto de una orden
    */
    @PostMapping(HTTP_ADMIN_ORDENES_DETALLE_MODIFICAR)
    public WebObject getAdminOrdenesDetalleModificar(@PathVariable("id_detalle_orden") Long id, @RequestBody WebObject o) {
        return client.nAdminOrdenesDetalleModificar(id, o);
    }
    
    /*
         Consultar el estado de todas las órdenes.
    */
    @PostMapping(HTTP_ADMIN_ORDENES_ESTADO)
    public WebObject getAdminOrdendesEstado() {
        return client.nAdminOrdendesEstado();
    }
    
    /*
        Consultar el estado de todos los productos de las órdenes.
    */
    @PostMapping(HTTP_ADMIN_ORDENDES_MODIFICAR_ESTADO)
    public WebObject getAdminOrdenesEstadoDetalle() {
        return client.nAdminOrdenesEstadoDetalle();
    }
}
