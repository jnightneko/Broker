/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author wil
 */
@FeignClient(value = "MCSV-Administracion", url = "http://localhost:3000/")
public interface AdminClient {
    //******************************************************************************************************************
    //**    RUTA DE ELNLACES
    public static final String HTTP_ADMIN_EMPLEADOS_GET              = "/administracion/empleados";
    public static final String HTTP_ADMIN_EMPLEAODS_GET_ID           = "/administracion/empleados/{id}";
    public static final String HTTP_ADMIN_EMPLEADOS_POST             = "/administracion/empleados";
    public static final String HTTP_ADMIN_EMPLEADOS_PUT              = "/administracion/empleados/{id}";
    public static final String HTTP_ADMIN_ALERTAS_GET                = "/administracion/alertas";
    public static final String HTTP_ADMIN_ALETAS_GET_ID              = "/administracion/alertas/{id}";
    public static final String HTTP_ADMIN_ALERTAS_TINDA_CONVENIENCIA = "/administracion/alertas/tienda_de_conveniencia";
    public static final String HTTP_ADMIN_ALERTAS_GASOLINERA         = "/administracion/alertas/gasolinera";
    public static final String HTTP_ADMIN_ALERTAS_REPUESTO           = "/administracion/alertas/repuestos";
    public static final String HTTP_ADMIN_ALERTAS_PINTURA            = "/administracion/alertas/pintura";
    public static final String HTTP_ADMIN_AREAS_GET                  = "/administracion/areas";
    public static final String HTTP_ADMIN_AREAS_GET_ID               = "/administracion/areas/{id}";
    public static final String HTTP_ADMIN_ROLES_GET                  = "/administracion/roles";
    public static final String HTTP_ADMIN_ROLES_GET_ID               = "/administracion/roles/{id}";
    public static final String HTTP_ADMIN_ROLES_POST                 = "/administracion/roles";
    public static final String HTTP_ADMIN_ROLES_PUT                  = "/administracion/roles/{id}";
    public static final String HTTP_ADMIN_JORNADAS_GET               = "/administracion/jornadas";
    public static final String HTTP_ADMIN_JORNADAS_GET_ID            = "/administracion/jornadas/{id}";
    public static final String HTTP_ADMIN_PROVEEDORES_GET            = "/administracion/proveedores";
    public static final String HTTP_ADMIN_PROVEEDORES_GET_ID         = "/administracion/proveedores/{id}";
    public static final String HTTP_ADMIN_PROVEEDORES_POST           = "/administracion/proveedores";
    public static final String HTTP_ADMIN_PROVEEDORES_PUT            = "/administracion/proveedores/{id}";
    public static final String HTTP_ADMIN_SERVICIO_GET               = "/administracion/servicios";
    public static final String HTTP_ADMIN_SERVICIO_GET_ID            = "/administracion/servicios/{id}";
    public static final String HTTP_ADMIN_MOVIMIENTO_GET             = "/administracion/movimientos";
    public static final String HTTP_ADMIN_MOVIMIENTO_GET_ID          = "/administracion/movimientos/{id}";
    public static final String HTTP_ADMIN_MOVIMIENTO_GET_TODO        = "GET/administracion/movimientos";
    public static final String HTTP_ADMIN_MOVIMIENTO_GET_DIARIO      = "GET/administracion/movimientos/diarios";
    public static final String HTTP_ADMIN_MIVIMIENTO_GET_MESULA      = "GET/administracion/movimientos/mensualess";
    public static final String HTTP_ADMIN_MIVIMIENTO_GET_TRIMESTRAL  = "GET/administracion/movimientos/trimestrales";
    public static final String HTTP_ADMIN_MIVIMIENTO_GET_SEMESTRAL   = "GET/administracion/movimientos/semestrales";
    public static final String HTTP_ADMIN_MIVIMIENTO_GET_ANUAL       = "GET/administracion/movimientos/anuales";
    public static final String HTTP_ADMIN_ASISTENCIA_GET             = "/administracion/asistencias/empleado/{id}";
    public static final String HTTP_ADMIN_ASISTENCIA_POST            = "/administracion/asistencias";
    public static final String HTTP_ADMIN_INASISTENCIA_GET           = "/administracion/inasistencias/empleado/{id}";
    public static final String HTTP_ADMIN_ORDENES_GET                = "/administracion/ordenes";
    public static final String HTTP_ADMIN_ORDENES_GET_ID             = "/administracion/ordenes/{id}";
    public static final String HTTP_ADMIN_ORDENDES_POST              = "/administracion/ordenes/";
    public static final String HTTP_ADMIN_ORDENDES_MODIFICAR_ESTADO  = "/administracion/ordenes/modificar_estado/{id}";
    public static final String HTTP_ADMIN_ORDENES_DETALLE            = "/administracion/ordenes/detalles/{id_orden}";
    public static final String HTTP_ADMIN_ORDENES_DETALLE_MODIFICAR  = "/administracion/ordenes/detalles/{id_detalle_orden}";
    public static final String HTTP_ADMIN_ORDENES_ESTADO             = "/administracion/ordenes/estados_ordenes";
    public static final String HTTP_ADMIN_ORDENES_ESTADO_DETALLE     = "/administracion/ordenes/estados_ordenes_detalles";
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
    public Object nAdmminEmpleadoGetId(@PathVariable("id") Long id);
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
    public Object nAdmimEmpleadoPut(@PathVariable("id") Long id, @RequestBody Object o);
    /**
     * Consultar todas las alertas actuales para abastecimiento de pedidos
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_ALERTAS_GET)
    public Object nAdminAlertasGet();
    /**
     * Consultar una alerta específica para abastecimiento de pedidos
     * @param id id|long
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_ALETAS_GET_ID)
    public Object nAdminAlertasGetId(@PathVariable("id") Long id);
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
    public Object nAdminAreasGetId(@PathVariable("id") Long id);
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
    public Object nAdminRolesId(@PathVariable("id") Long id);
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
    public Object nAdminRolesPut(@PathVariable("id") Long id, @RequestBody Object o);
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
    public Object nAdminJornadasGetId(@PathVariable("id") Long id);
    /**
     * Consultar a todos los proveedores.
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_PROVEEDORES_GET)
    public Object nAdminProveedoresGet();
    /**
     * Consultar un proveedor en específico.
     * @param id id|long
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_PROVEEDORES_GET_ID)
    public Object nAmindProveedoresGetId(@PathVariable("id") Long id);
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
    public Object nAdminProveedoresPut(@PathVariable("id") Long id, @RequestBody Object o);
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
    public Object nAdminServicioGetId(@PathVariable("id") Long id);
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
    public Object nAdminMovGetId(@PathVariable("id") Long id);
    /**
     * Devuelve el reporte de todos los movimientos.
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_MOVIMIENTO_GET_TODO)
    public Object nAdminMovTodo();
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
    public Object nAdminMovAsistencia(@PathVariable("id") Long id, @RequestBody Object o);
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
    public Object nAdminInasistenicaGet(@PathVariable("id") Long id);
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
    public Object nAdminOrdendeGetId(@PathVariable("id") Long id);
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
    public Object nAdminOrdenesModificarEstado(@PathVariable("id") Long id, @RequestBody Object o);
    /**
     * Ver los productos relacionados a una orden específica.
     * @param id id|long
     * @return objeto web
     */
    @GetMapping(HTTP_ADMIN_ORDENES_DETALLE)
    public Object nAdminOrdenesDetalle(@PathVariable("id_orden") Long id);
    /**
     * Editar estado de 1 producto de una orden
     * @param id id|long
     * @param o objeto web
     * @return objeto web
     */
    @PutMapping(HTTP_ADMIN_ORDENES_DETALLE_MODIFICAR)
    public Object nAdminOrdenesDetalleModificar(@PathVariable("id_detalle_orden") Long id, @RequestBody Object o);
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
    @GetMapping(HTTP_ADMIN_ORDENDES_MODIFICAR_ESTADO)
    public Object nAdminOrdenesEstadoDetalle();    
}
