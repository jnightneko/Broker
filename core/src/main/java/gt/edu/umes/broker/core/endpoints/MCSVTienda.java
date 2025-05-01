/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.core.endpoints;

/**
 * Clase encargada de listar todo los endpoints del servicio externo 'Tienda'.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class MCSVTienda {
    //******************************************************************************************************************
    //**    RUTA DE ELNLACES
    public static final String HTTP_VENTAS_GET                      = "/api/v1/tienda/GET/ventas";
    public static final String HTTP_VENTAS_COMPLETO_GET             = "/api/v1/tienda/GET/ventas/completo";
    public static final String HTTP_VENTAS_ID_GET                   = "/api/v1/tienda/GET/ventas/{id}";
    public static final String HTTP_VENTAS_POST                     = "/api/v1/tienda/POST/ventas";
    public static final String HTTP_VENTAS_PUT                      = "/api/v1/tienda/PUT/ventas/{id}";
    public static final String HTTP_VENTAS_DELETE                   = "/api/v1/tienda/DELETE/ventas/{id}";
    public static final String HTTP_DEVOLUCIONES_GET                = "/api/v1/tienda/GET/devoluciones";
    public static final String HTTP_DEVOLUCIONES_ID_GET             = "/api/v1/tienda/GET/devoluciones/{id}";
    public static final String HTTP_DEVOLUCIONES_VENTA_GET          = "/api/v1/tienda/GET/devoluciones/venta/{id}";
    public static final String HTTP_DEVOLUCIONES_PENDIENTE_GET      = "/api/v1/tienda/GET/devoluciones/estado/pendiente";
    public static final String HTTP_DEVOLUCIONES_POST               = "/api/v1/tienda/POST/devoluciones";
    public static final String HTTP_DEVOLUCIONES_PUT                = "/api/v1/tienda/PUT/devoluciones/{id}";
    /** Constructor privadoo. */
    private MCSVTienda() {}
}
