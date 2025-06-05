/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.core.endpoints;

/**
 * Clase encargada de listar todo los endpoints del servicio externo 'Taller de Repuesto'.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class MCSVRepuestos {
    //******************************************************************************************************************
    //**    RUTA DE ELNLACES

    //** SERVICIOS
    public static final String HTTP_SERVICIOS_GET    = "/tallerrepuestos/GET/servicios";
    public static final String HTTP_SERVICIOS_POST   = "/tallerrepuestos/POST/servicios";
    public static final String HTTP_SERVICIOS_PUT    = "/tallerrepuestos/PUT/servicios/{id}";
    public static final String HTTP_SERVICIOS_DELETE = "/tallerrepuestos/DELETE/servicios/{id}";
    //** TIPO SERVICIOS
    public static final String HTTP_TIPOSERVICIOS_GET    = "/tallerrepuestos/GET/tiposervicios";
    public static final String HTTP_TIPOSERVICIOS_POST   = "/tallerrepuestos/POST/tiposervicios";
    public static final String HTTP_TIPOSERVICIOS_PUT    = "/tallerrepuestos/PUT/tiposervicios/{id}";
    public static final String HTTP_TIPOSERVICIOS_DELETE = "/tallerrepuestos/DELETE/tiposervicios/{id}";
    //** EMPLEADOS
    public static final String HTTP_EMPLEADOS_GET    = "/tallerrepuestos/GET/empleados";
    public static final String HTTP_EMPLEADOS_POST   = "/tallerrepuestos/POST/empleados";
    public static final String HTTP_EMPLEADOS_PUT    = "/tallerrepuestos/PUT/empleados/{id}";
    public static final String HTTP_EMPLEADOS_DELETE = "/tallerrepuestos/DELETE/empleados/{id}";
    //** CLIENTES
    public static final String HTTP_CLIENTES_GET    = "/tallerrepuestos/GET/clientes";
    public static final String HTTP_CLIENTES_POST   = "/tallerrepuestos/POST/clientes";
    public static final String HTTP_CLIENTES_PUT    = "/tallerrepuestos/PUT/clientes/{id}";
    public static final String HTTP_CLIENTES_DELETE = "/tallerrepuestos/DELETE/clientes/{id}";
    //** VEHICULOS
    public static final String HTTP_VEHICULOS_GET    = "/tallerrepuestos/GET/vehiculos";
    public static final String HTTP_VEHICULOS_POST   = "/tallerrepuestos/POST/vehiculos";
    public static final String HTTP_VEHICULOS_PUT    = "/tallerrepuestos/PUT/vehiculos/{id}";
    public static final String HTTP_VEHICULOS_DELETE = "/tallerrepuestos/DELETE/vehiculos/{id}";
    //** VENTAS
    public static final String HTTP_VENTAS_GET    = "/tallerrepuestos/GET/ventas";
    public static final String HTTP_VENTAS_POST   = "/tallerrepuestos/POST/ventas";
    public static final String HTTP_VENTAS_PUT    = "/tallerrepuestos/PUT/ventas/{id}";
    public static final String HTTP_VENTAS_DELETE = "/tallerrepuestos/DELETE/ventas/{id}";
    //** CATEGORIAS
    public static final String HTTP_CATEGORIAS_GET = "/tallerrepuestos/GET/categorias";
    public static final String HTTP_CATEGORIAS_POST = "/tallerrepuestos/POST/categorias";
    public static final String HTTP_CATEGORIAS_PUT = "/tallerrepuestos/PUT/categorias/{id}";
    public static final String HTTP_CATEGORIAS_DELETE = "/tallerrepuestos/DELETE/categorias/{id}";
    //** PRODUCTOS
    public static final String HTTP_PRODUCTOS_GET    = "/tallerrepuestos/GET/productos";
    public static final String HTTP_PRODUCTOS_POST   = "/tallerrepuestos/POST/productos";
    public static final String HTTP_PRODUCTOS_PUT    = "/tallerrepuestos/PUT/productos/{id}";
    public static final String HTTP_PRODUCTOS_DELETE = "/tallerrepuestos/DELETE/productos/{id}";
    //** INVENTARIOS
    public static final String HTTP_INVENTARIOS_GET    = "/tallerrepuestos/GET/inventariosl";
    public static final String HTTP_INVENTARIOS_POST   = "/tallerrepuestos/POST/inventariosl";
    public static final String HTTP_INVENTARIOS_PUT    = "/tallerrepuestos/PUT/inventariosl/{id}";
    public static final String HTTP_INVENTARIOS_DELETE = "/tallerrepuestos/DELETE/inventariosl/{id}";
    //** MOVIMIENTOS
    public static final String HTTP_MOVIMIENTOS_GET = "/tallerrepuestos/GET/movimientos";
    public static final String HTTP_MOVIMIENTOS_POST = "/tallerrepuestos/POST/movimientos";
    public static final String HTTP_MOVIMIENTOS_PUT = "/tallerrepuestos/PUT/movimientos/{id}";
    public static final String HTTP_MOVIMIENTOS_DELETE = "/tallerrepuestos/DELETE/movimientos/{id}";
    //** PRECIO HISTORIAL
    public static final String HTTP_PRECIO_HISTORIAL_GET = "/tallerrepuestos/GET/preciohistorial";
    public static final String HTTP_PRECIO_HISTORIAL_POST = "/tallerrepuestos/POST/preciohistorial";
    public static final String HTTP_PRECIO_HISTORIAL_PUT = "/tallerrepuestos/PUT/preciohistorial/{id}";
    public static final String HTTP_PRECIO_HISTORIAL_DELETE = "/tallerrepuestos/DELETE/preciohistorial/{id}";
    //** DEVOLUCION
    public static final String HTTP_DEVOLUCION_GET = "/tallerrepuestos/GET/devolucion";
    public static final String HTTP_DEVOLUCION_GET_ID = "/tallerrepuestos/GET/devolucion/{id}";
    public static final String HTTP_DEVOLUCION_POST = "/tallerrepuestos/POST/devolucion";
    //** PAGOS (COMUNICACION)
    public static final String HTTP_BANCOS_GET = "/tallerrepuestos/GET/pago/bancos";
    public static final String HTTP_METODOS_PAGO_GET = "/tallerrepuestos/GET/pago/metodos-pago";
    public static final String HTTP_SERVICIOS_TRANSACCION_GET = "/tallerrepuestos/GET/pago/servicios-transaccion";
    public static final String HTTP_CLIENTES_PAGO_GET = "/tallerrepuestos/GET/pago/clientes-pago";
    public static final String HTTP_VERIFICAR_CLIENTE_GET = "/tallerrepuestos/GET/pago/verificar-cliente/{nit}";
    public static final String HTTP_PROCESAR_VENTA_PAGO_POST = "/tallerrepuestos/POST/pago/procesar-venta-pago";
    public static final String HTTP_PROCESAR_VENTA_INVENTARIO_POST = "/tallerrepuestos/POST/pago/procesar-venta-inventario";
    public static final String HTTP_PROCESAR_PAGO_POST = "/tallerrepuestos/POST/pago/procesar-pago/{idVenta}";
    public static final String HTTP_TRANSACCION_GET = "/tallerrepuestos/GET/pago/transaccion/{noTransaccion}";
    public static final String HTTP_ANULAR_TRANSACCION_PUT = "/tallerrepuestos/PUT/pago/anular-transaccion/{noTransaccion}";
    //** ADMINISTRACION (ABASTECIMIENTO)
    public static final String HTTP_PRODUCTOS_ABASTECER_POST = "/tallerrepuestos/POST/productos/abastecer";


    /** Constructor privadoo. */
    private MCSVRepuestos() {}
}
