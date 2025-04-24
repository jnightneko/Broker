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
    public static final String HTTP_CLIENTES_GET    = "/tallerrepuestos/GET/clientes";
    public static final String HTTP_CLIENTES_POST   = "/tallerrepuestos/POST/clientes";
    public static final String HTTP_CLIENTES_PUT    = "/tallerrepuestos/PUT/clientes/{id}";
    public static final String HTTP_PRODUCTOS_GET   = "/tallerrepuestos/GET/productos";
    public static final String HTTP_PRODUCTOS_POST  = "/tallerrepuestos/POST/productos";
    public static final String HTTP_PRODUCTOS_PUT   = "/tallerrepuestos/PUT/productos/{id}";
    public static final String HTTP_VEHICULOS_GET   = "/tallerrepuestos/GET/vehiculos";
    public static final String HTTP_VEHICULOS_POST  = "/tallerrepuestos/POST/vehiculos";
    public static final String HTTP_VEHICULOS_PUT   = "/tallerrepuestos/PUT/vehiculos/{id}";
    public static final String HTTP_SERVICIOS_GET   = "/tallerrepuestos/GET/servicios";
    public static final String HTTP_SERVICIOS_POST  = "/tallerrepuestos/POST/servicio";
    public static final String HTTP_INVENTARIO_GET  = "/tallerrepuestos/GET/inventarios";
    public static final String HTTP_VENTAS_GET      = "/tallerrepuestos/GET/ventas";
    public static final String HTTP_VENTAS_POST     = "/tallerrepuestos/POST/ventas";
    public static final String HTTP_VENTAS_PUT      = "/tallerrepuestos/PUT/ventas/{id}";
    /** Constructor privadoo. */
    private MCSVRepuestos() {}
}
