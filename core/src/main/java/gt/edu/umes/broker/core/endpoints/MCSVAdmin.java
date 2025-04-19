/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.core.endpoints;

/**
 * Clase encargada de listar todo los endpoints del servicio externo 'Administración'.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class MCSVAdmin {
    //******************************************************************************************************************
    //**    RUTA DE ELNLACES
    public static final String HTTP_ADMIN_EMPLEADOS_GET              = "/administracion/GET/empleados";
    public static final String HTTP_ADMIN_EMPLEAODS_GET_ID           = "/administracion/GET/empleados/{id}";
    public static final String HTTP_ADMIN_EMPLEADOS_POST             = "/administracion/POST/empleados";
    public static final String HTTP_ADMIN_EMPLEADOS_PUT              = "/administracion/PUT/empleados/{id}";
    public static final String HTTP_ADMIN_ALERTAS_GET                = "/administracion/GET/alertas";
    public static final String HTTP_ADMIN_ALETAS_GET_ID              = "/administracion/GET/alertas/{id}";
    public static final String HTTP_ADMIN_ALERTAS_TINDA_CONVENIENCIA = "/administracion/POST/alertas/tienda_de_conveniencia";
    public static final String HTTP_ADMIN_ALERTAS_GASOLINERA         = "/administracion/POST/alertas/gasolinera";
    public static final String HTTP_ADMIN_ALERTAS_REPUESTO           = "/administracion/POST/alertas/repuestos";
    public static final String HTTP_ADMIN_ALERTAS_PINTURA            = "/administracion/POST/alertas/pintura";
    public static final String HTTP_ADMIN_AREAS_GET                  = "/administracion/GET/areas";
    public static final String HTTP_ADMIN_AREAS_GET_ID               = "/administracion/GET/areas/{id}";
    public static final String HTTP_ADMIN_ROLES_GET                  = "/administracion/GET/roles";
    public static final String HTTP_ADMIN_ROLES_GET_ID               = "/administracion/GET/roles/{id}";
    public static final String HTTP_ADMIN_ROLES_POST                 = "/administracion/POST/roles";
    public static final String HTTP_ADMIN_ROLES_PUT                  = "/administracion/PUT/roles/{id}";
    public static final String HTTP_ADMIN_JORNADAS_GET               = "/administracion/GET/jornadas";
    public static final String HTTP_ADMIN_JORNADAS_GET_ID            = "/administracion/GET/jornadas/{id}";
    public static final String HTTP_ADMIN_PROVEEDORES_GET            = "/administracion/GET/proveedores";
    public static final String HTTP_ADMIN_PROVEEDORES_GET_ID         = "/administracion/GET/proveedores/{id}";
    public static final String HTTP_ADMIN_PROVEEDORES_POST           = "/administracion/POST/proveedores";
    public static final String HTTP_ADMIN_PROVEEDORES_PUT            = "/administracion/PUT/proveedores/{id}";
    public static final String HTTP_ADMIN_SERVICIO_GET               = "/administracion/GET/servicios";
    public static final String HTTP_ADMIN_SERVICIO_GET_ID            = "/administracion/GET/servicios/{id}";
    public static final String HTTP_ADMIN_MOVIMIENTO_GET             = "/administracion/GET/movimientos";
    public static final String HTTP_ADMIN_MOVIMIENTO_GET_ID          = "/administracion/GET/movimientos/{id}";
    /*public static final String HTTP_ADMIN_MOVIMIENTO_GET_TODO        = "/administracion/GET/movimientos";*/
    public static final String HTTP_ADMIN_MOVIMIENTO_GET_DIARIO      = "/administracion/GET/movimientos/diarios";
    public static final String HTTP_ADMIN_MIVIMIENTO_GET_MESULA      = "/administracion/GET/movimientos/mensuales";
    public static final String HTTP_ADMIN_MIVIMIENTO_GET_TRIMESTRAL  = "/administracion/GET/movimientos/trimestrales";
    public static final String HTTP_ADMIN_MIVIMIENTO_GET_SEMESTRAL   = "/administracion/GET/movimientos/semestrales";
    public static final String HTTP_ADMIN_MIVIMIENTO_GET_ANUAL       = "/administracion/GET/movimientos/anuales";
    public static final String HTTP_ADMIN_ASISTENCIA_GET             = "/administracion/GET/asistencias/empleado/{id}";
    public static final String HTTP_ADMIN_ASISTENCIA_POST            = "/administracion/POST/asistencias/";
    public static final String HTTP_ADMIN_INASISTENCIA_GET           = "/administracion/GET/inasistencias/empleado/{id}";
    public static final String HTTP_ADMIN_ORDENES_GET                = "/administracion/GET/ordenes";
    public static final String HTTP_ADMIN_ORDENES_GET_ID             = "/administracion/GET/ordenes/{id}";
    public static final String HTTP_ADMIN_ORDENDES_POST              = "/administracion/POST/ordenes/";
    public static final String HTTP_ADMIN_ORDENDES_MODIFICAR_ESTADO  = "/administracion/PUT/ordenes/modificar_estado/{id}";
    public static final String HTTP_ADMIN_ORDENES_DETALLE            = "/administracion/GET/ordenes/detalles/{id_orden}";
    public static final String HTTP_ADMIN_ORDENES_DETALLE_MODIFICAR  = "/administracion/PUT/ordenes/detalles/{id_detalle_orden}";
    public static final String HTTP_ADMIN_ORDENES_ESTADO             = "/administracion/GET/ordenes/estados_ordenes";
    public static final String HTTP_ADMIN_ORDENES_ESTADO_DETALLE     = "administracion/GET/ordenes/estados_ordenes_detalles";
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /* Enalces de prueba para el login. */
    public static final String HTTP_ADMIN_USUARIO_LOGIN              = "/administracion/POST/login/empleados";
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Constructor privadoo. */
    private MCSVAdmin() {}
}
