/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.client;

import gt.edu.umes.broker.core.Microservice;
import static gt.edu.umes.broker.core.endpoints.MCSVAdmin.*;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Clase encargado de gestionar la conexión con el servicio de 'Administración', 
 * interfaz encargado de implementar los enlaces a los endpoints de dicho servicio.
 * 
 * @author wil
 * @version 1.0.1
 * @since 1.0.0
 */
@FeignClient(value = "MCSV-Administracion", url = Microservice.MICROSERVICE_ADMIN)
public interface AdminClient {
    /**
     * Eliminar a un empleado de manera lógica.
     * @param o objeto web
     * @return objeto web
     */
    @PatchMapping(HTTP_ADMIN_EMPLEADOS_PATCH)
    public Object nEmpleadoPatch(@PathVariable("id") Object o);
    /**
     * Registra el pago de salarios como movimiento
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(HTTP_ADMIN_PAGAR_SALARIO_POST )
    public Object nPagoSalario(@RequestBody(required = false) Object o);
    /**
     * Registra un reembolso como movimiento asociado a un servicio.
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(HTTP_ADMIN_REMBOLSOS_POST)
    public Object nRembolose(@RequestBody Object o);
    /**
     * Enalces de prueba para el login.
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(HTTP_ADMIN_USUARIO_LOGIN)
    public Object nUsuariosLogin(@RequestBody Object o);
    
    /**
     * Permite que un empleado pueda cambiar su contraseña de acceso al sistema. 
     * Haciendo uso de su contraseña anterior. Debe de cambiar contraseña al primer logueo
     * 
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(HTTP_ADMIN_USUARIO_CAMBIO_PASS)
    public Object nUsuarioCambioPass(@RequestBody Object o);
    
    /**
     * Permite restablecer la contraseña de un empleado que la haya olvidado. Genera 
     * una contraseña temporal, que luego el empleado puede cambiar.
     * 
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(HTTP_ADMIN_USUARIO_RESET_PASS)
    public Object nUsuarioResetPass(@RequestBody Object o);
    
    /**
     * Desactivar una alerta de manera lógica.
     * @param id objeto web
     * @return objeto web
     */
    @PatchMapping(HTTP_ADMIN_ALERTAS_PATCH)
    public Object nAlertasPatch(@PathVariable("id") Object id);
    
    /**
     * Eliminar un rol de manera lógica.
     * @param id obj
     * @return objeto web
     */
    @PatchMapping(HTTP_ADMIN_ROLES_PATCH)
    public Object nRolesPatch(@PathVariable("id") Object id);
    
    /**
     * Consultar la información de todos los empleados que trabajaron previamente 
     * en la gasolinera (empleados inactivos).
     * @return  obj
     */
    @GetMapping(HTTP_ADMIN_EMPLEADOS_BAJAS_GET)
    public Object nAdminEmpleadosBajasGet();
    
    /**
     * Registrar asistencia de un empleado específico (salida).
     * @param o objeto web
     * @return objeto web
     */
    @PatchMapping(HTTP_ADMIN_ASISTENCIA_PATCH)
    public Object nAsistenciaPatch(@RequestBody Object o);
    
    /**
     * Consultar la información de todos los empleados.
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_EMPLEADOS_GET)
    public Object nAdminEmpleadoGet();
    /**
     * Consultar la información de un empleado en específico.
     * @param id id|long
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_EMPLEAODS_GET_ID)
    public Object nAdmminEmpleadoGetId(@PathVariable("id") Object id);
    /**
     * Insertar un registro de empleado
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(HTTP_ADMIN_EMPLEADOS_POST)
    public Object nAdminEmpleadoPost(@RequestBody Object o);
    /**
     * Actualizar la información de un empleado específico
     * @param id id|long
     * @param o objeto web
     * @return objeto web
     */
    @PutMapping(HTTP_ADMIN_EMPLEADOS_PUT)
    public Object nAdmimEmpleadoPut(@PathVariable("id") Object id, @RequestBody Object o);
    /**
     * Consultar todas las alertas actuales para abastecimiento de pedidos
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_ALERTAS_GET)
    public Object nAdminAlertasGet();
    /**
     * Editar un área de trabajo o sección específica dentro de un servicio.
     * @param id objeto web
     * @param value objeto web
     * @return objeto web
     */
    @PutMapping(HTTP_ADMIN_ALERTAS_PUT)
    public Object nAdminAlertasPut(@PathVariable("id") Object id, @RequestBody Object value);
    /**
     * Consultar una alerta específica para abastecimiento de pedidos
     * @param id id|long
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_ALETAS_GET_ID)
    public Object nAdminAlertasGetId(@PathVariable("id") Object id);
    
    /**
     * Agregar un área de trabajo o sección específica dentro de un servicio.
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(HTTP_ADMIN_AREAS_POST)
    public Object nAdminAlertasPost(@RequestBody Object o);
    /**
     * Alertas: Tienda
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(HTTP_ADMIN_ALERTAS_TINDA_CONVENIENCIA)
    public Object nAdminAlertaTinedaConveniencia(@RequestBody Object o);
    /**
     * Alertas: Gasolinear
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(HTTP_ADMIN_ALERTAS_GASOLINERA)
    public Object nAdminAlertaGasolinera(@RequestBody Object o);
    /**
     * Alertas: Repuesto
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(HTTP_ADMIN_ALERTAS_REPUESTO)
    public Object nAdminAlertasRepuetos(@RequestBody Object o);
    /**
     * Alertas: RPintura
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(HTTP_ADMIN_ALERTAS_PINTURA)
    public Object nAdminPintura(@RequestBody Object o);
    /**
     * Consultar todas las áreas (secciones) dentro de la gasolinera
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_AREAS_GET)
    public Object nAdminAreasGet();
    /**
     * Consultar un área (sección) específica dentro de la gasolinera
     * @param id id|long
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_AREAS_GET_ID)
    public Object nAdminAreasGetId(@PathVariable("id") Object id);
    /**
     * Consultar todos los roles que puede ocupar un empleado dentro de un área
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_ROLES_GET)
    public Object nAdminRoles();
    /**
     * Consultar un rol específico que puede ocupar un empleado dentro de un área.
     * @param id id|long
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_ROLES_GET_ID)
    public Object nAdminRolesId(@PathVariable("id") Object id);
    /**
     * insertar un nuevo rol que puede ocupar un empleado dentro de un área.
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(HTTP_ADMIN_ROLES_POST)
    public Object nAdminRolesPost(@RequestBody Object o);
    /**
     * Editar un rol existente.
     * @param id id|long
     * @param o objeto web
     * @return objeto web
     */
    @PutMapping(HTTP_ADMIN_ROLES_PUT)
    public Object nAdminRolesPut(@PathVariable("id") Object id, @RequestBody Object o);
    /**
     * Consultar todas las jornadas laborales.
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_JORNADAS_GET)
    public Object nAdminJornadasGet();
    /**
     * Consultar una jornada laboral específica.
     * @param id id|long
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_JORNADAS_GET_ID)
    public Object nAdminJornadasGetId(@PathVariable("id") Object id);
    /**
     * Consultar a todos los proveedores.
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_PROVEEDORES_GET)
    public Object nAdminProveedoresGet();
    
    /**
     * Consultar a todos los proveedores.
     * @param id objeto web
     * @return objeto web
     */
    @PatchMapping(HTTP_ADMIN_PROVEEDORES_PATCH)
    public Object nAdminProveedoresPatch(@PathVariable("id") Object id);
    /**
     * Consultar un proveedor en específico.
     * @param id id|long
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_PROVEEDORES_GET_ID)
    public Object nAmindProveedoresGetId(@PathVariable("id") Object id);
    /**
     * Insertar un nuevo proveedor.
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(HTTP_ADMIN_PROVEEDORES_POST)
    public Object nAdminProveedoresPost(@RequestBody Object o);
    /**
     * Editar la información de un proveedor específico.
     * @param id id|long
     * @param o objeto web
     * @return objeto web
     */
    @PutMapping(HTTP_ADMIN_PROVEEDORES_PUT)
    public Object nAdminProveedoresPut(@PathVariable("id") Object id, @RequestBody Object o);
    /**
     * Consultar la información de todos los servicios.
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_SERVICIO_GET)
    public Object nAdminServicioGet();
    /**
     * Consultar la información de un servicio específico.
     * @param id id|long
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_SERVICIO_GET_ID)
    public Object nAdminServicioGetId(@PathVariable("id") Object id);
    /**
     * Consultar la información de todos los tipos de movimientos.
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_MOVIMIENTO_GET)
    public Object nAdminMovGet();
    /**
     * Consultar la información de un tipo de movimiento específico.
     * @param id id|long
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_MOVIMIENTO_GET_ID)
    public Object nAdminMovGetId(@PathVariable("id") Object id);
    ///**
    // * Devuelve el reporte de todos los movimientos.
    // * @return objeto web
    // */
    //@GetMapping(HTTP_ADMIN_MOVIMIENTO_GET_TODO)
    //public Object nAdminMovTodo();
    /**
     * Devuelve el reporte de movimientos de un dia especifico
     * @param o objeto web
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_MOVIMIENTO_GET_DIARIO)
    public Object nAdminMovDiario(@RequestBody Object o);
    /**
     * Devuelve el reporte de movimientos de un mes específico
     * @param o objeto web
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_MIVIMIENTO_GET_MESULA)
    public Object nAdminMovMensual(@RequestBody Object o);
    /**
     * Devuelve el reporte de movimientos de un trimestre específico
     * @param o objeto web
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_MIVIMIENTO_GET_TRIMESTRAL)
    public Object nAdminMovTrimestral(@RequestBody Object o);
    /**
     * Devuelve el reporte de movimientos de un dia especifico
     * @param o objeto web
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_MIVIMIENTO_GET_SEMESTRAL)
    public Object nAdminMovSmestral(@RequestBody Object o);
    /**
     * Devuelve el reporte de movimientos de un año específico
     * @param o objeto web
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_MIVIMIENTO_GET_ANUAL)
    public Object nAdminMovAnual(@RequestBody Object o);
    /**
     * Ver las asistencias de un empleado específico
     * @param id id|long
     * @param o objeto web
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_ASISTENCIA_GET)
    public Object nAdminMovAsistencia(@PathVariable("id") Object id, @RequestBody Object o);
    /**
     * Registrar asistencia de un empleado específico
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(HTTP_ADMIN_ASISTENCIA_POST)
    public Object nAdminAsistenciaPost(@RequestBody Object o);
    /**
     * Ver las inasistencias de un empleado específico
     * @param id id|long
     * @return objeto web
     */
    @PostMapping(HTTP_ADMIN_INASISTENCIA_GET)
    public Object nAdminInasistenicaGet(@PathVariable("id") Object id);
    /**
     * Consultar la información básica de todas las órdenes.
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_ORDENES_GET)
    public Object nAdminOrdenesGet();
    /**
     * Consultar la información básica de una orden específica.
     * @param id id|long
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_ORDENES_GET_ID)
    public Object nAdminOrdendeGetId(@PathVariable("id") Object id);
    /**
     * Registrar una orden.
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(HTTP_ADMIN_ORDENDES_POST)
    public Object nAdminOrdenesPost(@RequestBody Object o);    
    /**
     * Permite cambiar el estado actual de la orden (pedido realizado, pedido en 
     * camino, etc). Útil para rastreo de la misma.
     * 
     * @param id id|long
     * @param o objeto web
     * @return objeto web
     */
    @PutMapping(HTTP_ADMIN_ORDENDES_MODIFICAR_ESTADO)
    public Object nAdminOrdenesModificarEstado(@PathVariable("id") Object id, @RequestBody Object o);
    /**
     * Ver los productos relacionados a una orden específica.
     * @param id id|long
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_ORDENES_DETALLE)
    public Object nAdminOrdenesDetalle(@PathVariable("id_orden") Object id);
    /**
     * Editar estado de 1 producto de una orden
     * @param id id|long
     * @param o objeto web
     * @return objeto web
     */
    @PutMapping(HTTP_ADMIN_ORDENES_DETALLE_MODIFICAR)
    public Object nAdminOrdenesDetalleModificar(@PathVariable("id_detalle_orden") Object id, @RequestBody Object o);
    /**
     * Consultar el estado de todas las órdenes.
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_ORDENES_ESTADO)
    public Object nAdminOrdendesEstado();
    /**
     * Consultar el estado de todos los productos de las órdenes.
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_ORDENES_ESTADO_DETALLE)
    public Object nAdminOrdenesEstadoDetalle();    
}
