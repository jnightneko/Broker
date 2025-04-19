/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.core.endpoints;

/**
 * Clase encargada de listar todo los endpoints del servicio externo 'Pagos'.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class MCSVPagos {
    //******************************************************************************************************************
    //**    RUTA DE ELNLACES
    public static final String PAGOS_CLIENTE_OBTENER                    = "/pagos/cliente/obtener";
    public static final String PAGOS_CLIENTE_OBTENER_NIT                = "/pagos/clientes/obtener/{nit}";
    public static final String PAGOS_CLIENTE_CREAR                      = "/pagos/cliente/crear";
    public static final String PAGOS_CLIENTE_ACTUALIZAR                 = "/pagos/cliente/actualizar/{id_cliente}";
    public static final String PAGOS_CLIENTE_ELIMINAR                   = "/pagos/cliente/eliminar/{id_cliente}";
    public static final String PAGOS_CLIENTE_FIDELIDAD_CREAR            = "/pagos/cliente/fidelidad/crear/{id_cliente}";
    public static final String PAGOS_CLIENTE_FIDELIDAD_DESACTIVAR       = "/pagos/cliente/fidelidad/desactivar/{id_cliente}";
    public static final String PAGOS_METODO_OBTENER                     = "/pagos/metodos/obtener";
    public static final String PAGOS_METODO_OBTENER_ID                  = "/pagos/metodos/obtener/{idMetodo}";
    public static final String PAGOS_METODO_CREAR                       = "/pagos/metodos/crear";
    public static final String PAGOS_METODO_ELIMINAR                    = "/pagos/metodos/eliminar/{id_metodo}";
    public static final String PAGOS_TRANSACCION_OBTENER                = "/pagos/transacciones/obtener";
    public static final String PAGOS_TRANSACCION_OBTENER_PARAM          = "/pagos/transacciones/obtener/{noTransaccion}";
    public static final String PAGOS_TRANSACCION_OBTENER_POR_SERVICIO   = "/pagos/transacciones/obtenerPorServicio/{idServicio}";
    public static final String PAGOS_TRANSACCION_CREAR                  = "/pagos/transaccion/crear";
    public static final String PAGOS_TRANSACCION_ANULAR                 = "/pagos/transaccion/anular/{noTransaccion}";
    public static final String PAGOS_DEVOLUCION_OBTENER                 = "/pagos/devoluciones/obtener";
    public static final String PAGOS_DEVOLUCION_OBTENER_PARAM           = "/pagos/devoluciones/obtener/{noDevolucion}";
    public static final String PAGOS_DEVOLUCION_CREAR                   = "/pagos/devoluciones/crear";
    public static final String PAGOS_BANCOS_OBTENER                     = "/pagos/bancos/obtener";
    public static final String PAGOS_BANCO_OBTENER_PARAM                = "/pagos/bancos/obtener/{id}";
    public static final String PAGOS_BANCO_CREAR                        = "/pagos/bancos/crear";
    public static final String PAGOS_BANCO_ELIMINAR                     = "/pagos/bancos/eliminar/{id}";
    public static final String PAGOS_FACTURA_OBTENER                    = "/pagos/facturas/obtener/{noFactura}";
    public static final String PAGOS_FACTURA_ANULAR                     = "/pagos/facturas/anular/{noFactura}";
    public static final String PAGOS_CIERRE_OBTENER                     = "/pagos/cierre/obtener";
    public static final String PAGOS_CIERRE_CREAR                       = "/pagos/cierre/crear";
    public static final String PAGOS_RETIRO                             = "/pagos/retiros";
    /** Constructor privadoo. */
    private MCSVPagos() {}
}
