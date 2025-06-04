/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import gt.edu.umes.broker.connector.client.AdminClient;
import static gt.edu.umes.broker.core.endpoints.MCSVAdmin.*;

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
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_EMPLEADOS_PATCH)
    public Object getEmpleadoPatch(@PathVariable("id") Object o) {
        return client.nEmpleadoPatch(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_ALERTAS_PUT)
    public Object getAdminAlertasPut(@PathVariable("id") Object id, @RequestAttribute Object value) {
        return client.nAdminAlertasPut(id, value);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_PAGAR_SALARIO_POST )
    public Object getPagoSalario(@RequestBody(required = false) Object o) {
        return client.nPagoSalario(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_REMBOLSOS_POST)
    public Object getRembolose(@RequestBody Object o) {
        return client.nRembolose(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_USUARIO_LOGIN)
    public Object getUsuariosLogin(@RequestBody Object o) {
        return client.nUsuariosLogin(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_USUARIO_CAMBIO_PASS)
    public Object getUsuarioCambioPass(@RequestBody Object o) {
        return client.nUsuarioCambioPass(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_USUARIO_RESET_PASS)
    public Object getUsuarioResetPass(@RequestBody Object o) {
        return client.nUsuarioResetPass(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_ALERTAS_PATCH)
    public Object getAlertasPatch(@PathVariable("id") Object id) {
        return client.nAlertasPatch(id);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_AREAS_POST)
    public Object getAdminAlertasPost(@RequestBody Object o) {
        return client.nAdminAlertasPost(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_ROLES_PATCH)
    public Object getRolesPatch() {
        return client.nRolesPatch();
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_ASISTENCIA_PATCH)
    public Object getAsistenciaPatch(@RequestBody Object o) {
        return client.nAsistenciaPatch(o);
    }
    
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_EMPLEADOS_GET)
    public Object getAdminEmpleadoGet() {
        return client.nAdminEmpleadoGet();
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_EMPLEAODS_GET_ID)
    public Object getAdmminEmpleadoGetId(@PathVariable("id") Object id) {
        return client.nAdmminEmpleadoGetId(id);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_EMPLEADOS_POST)
    public Object getAdminEmpleadoPost(@RequestBody Object o) {
        return client.nAdminEmpleadoPost(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_EMPLEADOS_PUT)
    public Object getAdmimEmpleadoPut(@PathVariable("id") Object id, @RequestBody Object o) {
        return client.nAdmimEmpleadoPut(id, o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_ALERTAS_GET)
    public Object getAdminAlertasGet() {
        return client.nAdminAlertasGet();
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_ALETAS_GET_ID)
    public Object getAdminAlertasGetId(@PathVariable("id") Object id) {
        return client.nAdminAlertasGetId(id);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_ALERTAS_TINDA_CONVENIENCIA)
    public Object getAdminAlertaTinedaConveniencia(@RequestBody Object o) {
        return client.nAdminAlertaTinedaConveniencia(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_ALERTAS_GASOLINERA)
    public Object getAdminAlertaGasolinera(@RequestBody Object o) {
        return client.nAdminAlertaGasolinera(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_ALERTAS_REPUESTO)
    public Object getAdminAlertasRepuetos(@RequestBody Object o) {
        return client.nAdminAlertasRepuetos(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_ALERTAS_PINTURA)
    public Object getAdminPintura(@RequestBody Object o) {
        return client.nAdminPintura(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_AREAS_GET)
    public Object getAdminAreasGet() {
        return client.nAdminAreasGet();
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_AREAS_GET_ID)
    public Object getAdminAreasGetId(@PathVariable("id") Object id) {
        return client.nAdminAreasGetId(id);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_ROLES_GET)
    public Object nAdminRoles() {
        return client.nAdminRoles();
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_ROLES_GET_ID)
    public Object getAdminRolesId(@PathVariable("id") Object id) {
        return client.nAdminRolesId(id);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_ROLES_POST)
    public Object getAdminRolesPost(@RequestBody Object o) {
        return client.nAdminRolesPost(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_ROLES_PUT)
    public Object nAdminRolesPut(@PathVariable("id") Object id, @RequestBody Object o) {
        return client.nAdminRolesPut(id, o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_JORNADAS_GET)
    public Object getAdminJornadasGet() {
        return client.nAdminJornadasGet();
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_JORNADAS_GET_ID)
    public Object getAdminJornadasGetId(@PathVariable("id") Object id) {
        return client.nAdminJornadasGetId(id);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_PROVEEDORES_GET)
    public Object getAdminProveedoresGet() {
        return client.nAdminProveedoresGet();
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_PROVEEDORES_PATCH)
    public Object nAdminProveedoresPatch(@PathVariable("id") Object id) {
        return client.nAdminProveedoresPatch(id);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_PROVEEDORES_GET_ID)
    public Object getAmindProveedoresGetId(@PathVariable("id") Object id) {
        return client.nAmindProveedoresGetId(id);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_PROVEEDORES_POST)
    public Object getAdminProveedoresPost(@RequestBody Object o) {
        return client.nAdminProveedoresPost(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_PROVEEDORES_PUT)
    public Object getAdminProveedoresPut(@PathVariable("id") Object id, @RequestBody Object o) {
        return client.nAdminProveedoresPut(id, o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_SERVICIO_GET)
    public Object nAdminServicioGet() {
        return client.nAdminServicioGet();
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_SERVICIO_GET_ID)
    public Object getAdminServicioGetId(@PathVariable("id") Object id) {
        return client.nAdminServicioGetId(id);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_MOVIMIENTO_GET)
    public Object nAdminMovGet() {
        return client.nAdminMovGet();
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_MOVIMIENTO_GET_ID)
    public Object nAdminMovGetId(@PathVariable("id") Object id) {
        return client.nAdminMovGetId(id);
    }
    //* (non-Javadoc) */
    //@PostMapping(HTTP_ADMIN_MOVIMIENTO_GET_TODO)
    //public Object getAdminMovTodo() {
    //    return client.nAdminMovTodo();
    //}
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_MOVIMIENTO_GET_DIARIO)
    public Object getAdminMovDiario(@RequestBody Object o) {
        return client.nAdminMovDiario(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_MIVIMIENTO_GET_MESULA)
    public Object getAdminMovMensual(@RequestBody Object o) {
        return client.nAdminMovMensual(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_MIVIMIENTO_GET_TRIMESTRAL)
    public Object getAdminMovTrimestral(@RequestBody Object o) {
        return client.nAdminMovTrimestral(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_MIVIMIENTO_GET_SEMESTRAL)
    public Object getAdminMovSmestral(@RequestBody Object o) {
        return client.nAdminMovSmestral(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_MIVIMIENTO_GET_ANUAL)
    public Object getAdminMovAnual(@RequestBody Object o) {
        return client.nAdminMovAnual(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_ASISTENCIA_GET)
    public Object getAdminMovAsistencia(@PathVariable("id") Object id, @RequestBody Object o) {
        return client.nAdminMovAsistencia(id, o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_ASISTENCIA_POST)
    public Object getAdminAsistenciaPost(@RequestBody Object o) {
        return client.nAdminAsistenciaPost(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_INASISTENCIA_GET)
    public Object getAdminInasistenicaGet(@PathVariable("id") Object id) {
        return client.nAdminInasistenicaGet(id);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_ORDENES_GET)
    public Object getAdminOrdenesGet() {
        return client.nAdminOrdenesGet();
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_ORDENES_GET_ID)
    public Object getAdminOrdendeGetId(@PathVariable("id") Object id) {
        return client.nAdminOrdendeGetId(id);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_ORDENDES_POST)
    public Object getAdminOrdenesPost(@RequestBody Object o) {
        return client.nAdminOrdenesPost(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_ORDENDES_MODIFICAR_ESTADO)
    public Object getAdminOrdenesModificarEstado(@PathVariable("id") Object id, @RequestBody Object o) {
        return client.nAdminOrdenesModificarEstado(id, o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_ORDENES_DETALLE)
    public Object getAdminOrdenesDetalle(@PathVariable("id_orden") Object id) {
        return client.nAdminOrdenesDetalle(id);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_ORDENES_DETALLE_MODIFICAR)
    public Object getAdminOrdenesDetalleModificar(@PathVariable("id_detalle_orden") Object id, @RequestBody Object o) {
        return client.nAdminOrdenesDetalleModificar(id, o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_ORDENES_ESTADO)
    public Object getAdminOrdendesEstado() {
        return client.nAdminOrdendesEstado();
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ADMIN_ORDENES_ESTADO_DETALLE)
    public Object getAdminOrdenesEstadoDetalle() {
        return client.nAdminOrdenesEstadoDetalle();
    }
}
