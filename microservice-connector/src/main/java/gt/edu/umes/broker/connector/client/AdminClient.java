/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.client;

import gt.edu.umes.broker.connector.http.WebObject;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author wil
 */
@FeignClient(value = "MCSV-Administracion", url = "http://localhost:3000/")
public interface AdminClient {    
    /*
        Consultar la información de todos los empleados.
    */
    @GetMapping(HTTP_ADMIN_EMPLEADOS_GET)
    public WebObject nAdminEmpleadoGet();
    public static final String HTTP_ADMIN_EMPLEADOS_GET             = "/administracion/empleados";
    
    /*
        Consultar la información de un empleado en específico.
    */
    @GetMapping(HTTP_ADMIN_EMPLEAODS_GET_ID)
    public WebObject nAdmminEmpleadoGetId(@PathVariable("id") Long id);
    public static final String HTTP_ADMIN_EMPLEAODS_GET_ID          = " /administracion/empleados/{id}";
    
    /*
        Insertar un registro de empleado
    */
    @PostMapping(HTTP_ADMIN_EMPLEADOS_POST)
    public WebObject nAdminEmpleadoPost(@RequestBody WebObject o);
    public static final String HTTP_ADMIN_EMPLEADOS_POST            = "/administracion/empleados";
    
    /*
        Actualizar la información de un empleado específico
    */
    @PutMapping(HTTP_ADMIN_EMPLEADOS_PUT)
    public WebObject nAdmimEmpleadoPut(@PathVariable("id") Long id, @RequestBody WebObject o);
    public static final String HTTP_ADMIN_EMPLEADOS_PUT             = "administracion/empleados/{id}";
    
    /*
        Consultar todas las alertas actuales para abastecimiento de pedidos
    */
    @GetMapping(HTTP_ADMIN_ALERTAS_GET)
    public WebObject nAdminAlertasGet();
    public static final String HTTP_ADMIN_ALERTAS_GET                = "/administracion/alertas";
    
    /*
        Consultar una alerta específica para abastecimiento de pedidos
    */
    @GetMapping(HTTP_ADMIN_ALETAS_GET_ID)
    public WebObject nAdminAlertasGetId(@PathVariable("id") Long id);
    public static final String HTTP_ADMIN_ALETAS_GET_ID             = "/administracion/alertas/{id}";
    
    /*
        Alertas: Tienda
    */
    @PostMapping(HTTP_ADMIN_ALERTAS_TINDA_CONVENIENCIA)
    public WebObject nAdminAlertaTinedaConveniencia(@RequestBody WebObject o);
    public static final String HTTP_ADMIN_ALERTAS_TINDA_CONVENIENCIA = "/administracion/alertas/tienda_de_conveniencia";
    
    /*
        Alertas: Gasolinear
    */
    @PostMapping(HTTP_ADMIN_ALERTAS_GASOLINERA)
    public WebObject nAdminAlertaGasolinera(@RequestBody WebObject o);
    public static final String HTTP_ADMIN_ALERTAS_GASOLINERA        = "/administracion/alertas/gasolinera";
    
    /*
        Alertas: Repuesto
    */
    @PostMapping(HTTP_ADMIN_ALERTAS_REPUESTO)
    public WebObject nAdminAlertasRepuetos(@RequestBody WebObject o);
    public static final String HTTP_ADMIN_ALERTAS_REPUESTO           = "/administracion/alertas/repuestos";
    
    /*
        Alertas: RPintura
    */
    @PostMapping(HTTP_ADMIN_ALERTAS_PINTURA)
    public WebObject nAdminPintura(@RequestBody WebObject o);
    public static final String HTTP_ADMIN_ALERTAS_PINTURA            = "/administracion/alertas/pintura";
    
    /*
        Consultar todas las áreas (secciones) dentro de la gasolinera
    */
    @GetMapping(HTTP_ADMIN_AREAS_GET)
    public WebObject nAdminAreasGet();
    public static final String HTTP_ADMIN_AREAS_GET                  = " /administracion/areas";
    
    /*
        Consultar un área (sección) específica dentro de la gasolinera
    */
    @GetMapping(HTTP_ADMIN_AREAS_GET_ID)
    public WebObject nAdminAreasGetId(@PathVariable("id") Long id);
    public static final String HTTP_ADMIN_AREAS_GET_ID              = "/administracion/areas/{id}";
    
    /*
        Consultar todos los roles que puede ocupar un empleado dentro de un área
    */
    @GetMapping(HTTP_ADMIN_ROLES_GET)
    public WebObject nAdminRoles();
    public static final String HTTP_ADMIN_ROLES_GET                 = "/administracion/roles";
    
    /*
        Consultar un rol específico que puede ocupar un empleado dentro de un área.
    */
    @GetMapping(HTTP_ADMIN_ROLES_GET_ID)
    public WebObject nAdminRolesId(@PathVariable("id") Long id);
    public static final String HTTP_ADMIN_ROLES_GET_ID              = "/administracion/roles/{id}";
    
    /*
        insertar un nuevo rol que puede ocupar un empleado dentro de un área.
    */
    @PostMapping(HTTP_ADMIN_ROLES_POST)
    public WebObject nAdminRolesPost(@RequestBody WebObject o);
    public static final String HTTP_ADMIN_ROLES_POST                = "/administracion/roles";
    
    /*
        Editar un rol existente.
    */
    @PutMapping(HTTP_ADMIN_ROLES_PUT)
    public WebObject nAdminRolesPut(@PathVariable("id") Long id, @RequestBody WebObject o);
    public static final String HTTP_ADMIN_ROLES_PUT                 = "/administracion/roles/{id}";
    
    /*
        Consultar todas las jornadas laborales.
    */
    @GetMapping(HTTP_ADMIN_JORNADAS_GET)
    public WebObject nAdminJornadasGet();
    public static final String HTTP_ADMIN_JORNADAS_GET              = "/administracion/jornadas";
    
    /*
        Consultar una jornada laboral específica.
    */
    @GetMapping(HTTP_ADMIN_JORNADAS_GET_ID)
    public WebObject nAdminJornadasGetId(@PathVariable("id") Long id);
    public static final String HTTP_ADMIN_JORNADAS_GET_ID           = "/administracion/jornadas/{id}";
    
    /*
        Consultar a todos los proveedores.
    */
    @GetMapping(HTTP_ADMIN_PROVEEDORES_GET)
    public WebObject nAdminProveedoresGet();
    public static final String HTTP_ADMIN_PROVEEDORES_GET           = "/administracion/proveedores";
    
    /*
        Consultar un proveedor en específico.
    */
    @GetMapping(HTTP_ADMIN_PROVEEDORES_GET_ID)
    public WebObject nAmindProveedoresGetId(@PathVariable("id") Long id);
    public static final String HTTP_ADMIN_PROVEEDORES_GET_ID        = " /administracion/proveedores/{id}";
    
    /*
        Insertar un nuevo proveedor.
    */
    @PostMapping(HTTP_ADMIN_PROVEEDORES_POST)
    public WebObject nAdminProveedoresPost(@RequestBody WebObject o);
    public static final String HTTP_ADMIN_PROVEEDORES_POST          = "/administracion/proveedores";
    
    /*
        Editar la información de un proveedor específico.
    */
    @PutMapping(HTTP_ADMIN_PROVEEDORES_PUT)
    public WebObject nAdminProveedoresPut(@PathVariable("id") Long id, @RequestBody WebObject o);
    public static final String HTTP_ADMIN_PROVEEDORES_PUT           = "administracion/proveedores/{id}";
    
    /*
        Consultar la información de todos los servicios.
    */
    @GetMapping(HTTP_ADMIN_SERVICIO_GET)
    public WebObject nAdminServicioGet();
    public static final String HTTP_ADMIN_SERVICIO_GET              = "/administracion/servicios";
    
    /*
        Consultar la información de un servicio específico.
    */
    @GetMapping(HTTP_ADMIN_SERVICIO_GET_ID)
    public WebObject nAdminServicioGetId(@PathVariable("id") Long id);
    public static final String HTTP_ADMIN_SERVICIO_GET_ID           = "/administracion/servicios/{id}";
    
    /*
        Consultar la información de todos los tipos de movimientos.
    */
    @GetMapping(HTTP_ADMIN_MOVIMIENTO_GET)
    public WebObject nAdminMovGet();
    public static final String HTTP_ADMIN_MOVIMIENTO_GET            = "/administracion/movimientos";
    
    /*
        Consultar la información de un tipo de movimiento específico.
    */
    @GetMapping(HTTP_ADMIN_MOVIMIENTO_GET_ID)
    public WebObject nAdminMovGetId(@PathVariable("id") Long id);
    public static final String HTTP_ADMIN_MOVIMIENTO_GET_ID         = "/administracion/movimientos/{id}";
    
    /*
        Devuelve el reporte de todos los movimientos.
    */
    @GetMapping(HTTP_ADMIN_MOVIMIENTO_GET_TODO)
    public WebObject nAdminMovTodo();
    public static final String HTTP_ADMIN_MOVIMIENTO_GET_TODO       = "GET/administracion/movimientos";
    
    /*
        Devuelve el reporte de movimientos de un dia especifico
    */
    @GetMapping(HTTP_ADMIN_MOVIMIENTO_GET_DIARIO)
    public WebObject nAdminMovDiario(@RequestBody WebObject o);
    public static final String HTTP_ADMIN_MOVIMIENTO_GET_DIARIO     = "GET/administracion/movimientos/diarios";
    
    /*
        Devuelve el reporte de movimientos de un mes específico
    */
    @GetMapping(HTTP_ADMIN_MIVIMIENTO_GET_MESULA)
    public WebObject nAdminMovMensual(@RequestBody WebObject o);
    public static final String HTTP_ADMIN_MIVIMIENTO_GET_MESULA     = "GET/administracion/movimientos/mensualess";
    
    /*
        Devuelve el reporte de movimientos de un trimestre específico
    */
    @GetMapping(HTTP_ADMIN_MIVIMIENTO_GET_TRIMESTRAL)
    public WebObject nAdminMovTrimestral(@RequestBody WebObject o);
    public static final String HTTP_ADMIN_MIVIMIENTO_GET_TRIMESTRAL   = "GET/administracion/movimientos/trimestrales";
    
    /*
        Devuelve el reporte de movimientos de un dia especifico
    */
    @GetMapping(HTTP_ADMIN_MIVIMIENTO_GET_SEMESTRAL)
    public WebObject nAdminMovSmestral(@RequestBody WebObject o);
    public static final String HTTP_ADMIN_MIVIMIENTO_GET_SEMESTRAL     = "GET/administracion/movimientos/semestrales";
    
    /*
        Devuelve el reporte de movimientos de un año específico
    */
    @GetMapping(HTTP_ADMIN_MIVIMIENTO_GET_ANUAL)
    public WebObject nAdminMovAnual(@RequestBody WebObject o);
    public static final String HTTP_ADMIN_MIVIMIENTO_GET_ANUAL          = "GET/administracion/movimientos/anuales";
    
    /*
        Ver las asistencias de un empleado específico
    */
    @GetMapping(HTTP_ADMIN_ASISTENCIA_GET)
    public WebObject nAdminMovAsistencia(@PathVariable("id") Long id, @RequestBody WebObject o);
    public static final String HTTP_ADMIN_ASISTENCIA_GET                = "/administracion/asistencias/empleado/{id}";
    
    /*
        Registrar asistencia de un empleado específico
    */
    @PostMapping(HTTP_ADMIN_ASISTENCIA_POST)
    public WebObject nAdminAsistenciaPost(@RequestBody WebObject o);
    public static final String HTTP_ADMIN_ASISTENCIA_POST               = "/administracion/asistencias";
    
    /*
        Ver las inasistencias de un empleado específico
    */
    @PostMapping(HTTP_ADMIN_INASISTENCIA_GET)
    public WebObject nAdminInasistenicaGet(@PathVariable("id") Long id);
    public static final String HTTP_ADMIN_INASISTENCIA_GET              = "/administracion/inasistencias/empleado/{id}";
    
    /*
        Consultar la información básica de todas las órdenes.
    */
    @GetMapping(HTTP_ADMIN_ORDENES_GET)
    public WebObject nAdminOrdenesGet();
    public static final String HTTP_ADMIN_ORDENES_GET                   = "/administracion/ordenes";
    
    /*
        Consultar la información básica de una orden específica.
    */
    @GetMapping(HTTP_ADMIN_ORDENES_GET_ID)
    public WebObject nAdminOrdendeGetId(@PathVariable("id") Long id);
    public static final String HTTP_ADMIN_ORDENES_GET_ID                = " /administracion/ordenes/{id}";
    
    /*
        Registrar una orden.
    */
    @PostMapping(HTTP_ADMIN_ORDENDES_POST)
    public WebObject nAdminOrdenesPost(@RequestBody WebObject o);
    public static final String HTTP_ADMIN_ORDENDES_POST                  = "/administracion/ordenes/";
    
    /*
        Permite cambiar el estado actual de la orden (pedido realizado, pedido en camino, etc). Útil para rastreo de la misma.
    */
    @PutMapping(HTTP_ADMIN_ORDENDES_MODIFICAR_ESTADO)
    public WebObject nAdminOrdenesModificarEstado(@PathVariable("id") Long id, @RequestBody WebObject o);
    public static final String HTTP_ADMIN_ORDENDES_MODIFICAR_ESTADO      = "administracion/ordenes/modificar_estado/{id}";
    
    /*
        Ver los productos relacionados a una orden específica.
    */
    @GetMapping(HTTP_ADMIN_ORDENES_DETALLE)
    public WebObject nAdminOrdenesDetalle(@PathVariable("id_orden") Long id);
    public static final String HTTP_ADMIN_ORDENES_DETALLE                = "/administracion/ordenes/detalles/{id_orden}";
    
    /*
        Editar estado de 1 producto de una orden
    */
    @PutMapping(HTTP_ADMIN_ORDENES_DETALLE_MODIFICAR)
    public WebObject nAdminOrdenesDetalleModificar(@PathVariable("id_detalle_orden") Long id, @RequestBody WebObject o);
    public static final String HTTP_ADMIN_ORDENES_DETALLE_MODIFICAR      = "administracion/ordenes/detalles/{id_detalle_orden}";
    
    /*
         Consultar el estado de todas las órdenes.
    */
    @GetMapping(HTTP_ADMIN_ORDENES_ESTADO)
    public WebObject nAdminOrdendesEstado();
    public static final String HTTP_ADMIN_ORDENES_ESTADO                = "/administracion/ordenes/estados_ordenes";
    
    /*
        Consultar el estado de todos los productos de las órdenes.
    */
    @GetMapping(HTTP_ADMIN_ORDENDES_MODIFICAR_ESTADO)
    public WebObject nAdminOrdenesEstadoDetalle();
    public static final String HTTP_ADMIN_ORDENES_ESTADO_DETALLE        = "administracion/ordenes/estados_ordenes_detalles";
}
