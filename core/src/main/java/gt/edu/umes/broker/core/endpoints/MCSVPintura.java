/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.core.endpoints;

/**
 * Clase encargada de listar todo los endpoints del servicio externo 'Pintura'.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class MCSVPintura {
    //******************************************************************************************************************
    //**    RUTA DE ELNLACES
    public static final String PINTURA_SERVICIO_GET             = "pintura/GET/servicios";
    public static final String PINTURA_SERVICIO_POST            = "pintura/POST/servicios";
    public static final String PINTURA_SERVICIO_PUT             = "pintura/PUT/servicios/{idServicio}";
    public static final String PINTURA_TIPOSERVICIO_GET         = "pintura/GET/tiposervicios";
    public static final String PINTURA_TIPOSERVICIO_PUT         = "pintura/PUT/tiposervicios/{idTipoServicio}";
    public static final String PINTURA_TIPOSERVICIO_POST        = "pintura/POST/tiposervicios";
    public static final String PINTURA_TIPOVEHICULO_GET         = "pintura/GET/tipovehiculos";
    public static final String PINTURA_TIPOVEHICULO_POST        = "pintura/POST/tipovehiculos";
    public static final String PINTURA_TIPOVEHICULO_PUT         = "pintura/PUT/tipovehiculos/{idTipoVehiculo}";
    public static final String PINTURA_TIPOPINTURA_GET          = "pintura/GET/tipopinturas";
    public static final String PINTURA_TIPOPINTURA_POST         = "pintura/POST/tipopintura";
    public static final String PINTURA_TIPOPINTURA_PUT          = "pintura/PUT/tipopinturas/{idTipoPintura}";
    public static final String PINTURA_INVENTARIO_GET           = "pintura/GET/inventarios";
    public static final String PINTURA_INVENTARIO_POST          = "pintura/POST/inventarios";
    public static final String PINTURA_INVENTARIO_PUT           = "pintura/PUT/inventarios/{idInventario}";
    public static final String PINTURA_MOVIMIENTO_GET           = "pintura/GET/movimiento";
    public static final String PINTURA_MOVIMIENTO_POST          = "pintura/POST/movimientos";
    public static final String PINTURA_MOVIMINEOT_PUT           = "/pintura/PUT/movimiento/{movimiento_id}";
    public static final String PINTURA_VENTAS_POST              = "pintura/POST/venta";
    public static final String PINTURA_VENTAS_GET               = "pintura/GET/venta";
    public static final String PINTURA_VENTAS_PUT               = "pintura/PUT/venta/{venta_id}";
    public static final String PINTURA_DETALLE_VENTA_GET        = "pintura/GET/detalleventas/{idVenta}";
    public static final String PINTURA_DETALLE_VENTA_POST       = "pintura/POST/detalleventas";
    public static final String PINTURA_DETALLE_VENTA_PUT        = "pintura/PUT/detalleventas/{idDetalleVenta}";
    public static final String PINTURA_DEVOLUCION_GET           = "pintura/GET/devolucion";
    public static final String PINTURA_DEVOLUCION_POST          = "pintura/POST/devolucion";
    public static final String PINTURA_VEHICULO_INVENTARIO_GET  = "pintura/GET/vehiculoinventarios";
    public static final String PINTURA_VEHICULO_INVENTARIO_POST = "pintura/POST/vehiculoinventarios";
    public static final String PINTURA_VEHICULO_INVENTARIO_PUT  = "pintura/PUT/vehiculoinventarios";
    public static final String PINTURA_PRECIOS_GET              = "pintura/GET/precioservicio";
    public static final String PINTURA_PRECIOS_POST             = "pintura/POST/precioservicio";
    public static final String PINTURA_PRECIOS_PUT              = "pintura/PUT/precioservicio/{id}";
    /** Constructor privadoo. */
    private MCSVPintura() {}
}
