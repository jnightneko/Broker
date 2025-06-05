/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.core.endpoints;

/**
 * Clase encargada de listar todo los endpoints del servicio externo 'Tienda'.
 *
 * @author wil
 * @version 1.5.0
 * @since 1.0.0
 */
public final class MCSVTienda {

    //******************************************************************************************************************
    //**    RUTA DE ELNLACES
    public static final String HTTP_PRODUCTOS_GET = "/tienda-conveniencia/GET/productos";
    public static final String HTTP_PRODUCTOS_POST = "/tienda-conveniencia/POST/productos";
    public static final String HTTP_PRODUCTOS_GET_ID = "/tienda-conveniencia/GET/productos/{id}";
    public static final String HTTP_PRODUCTOS_PUT = "/tienda-conveniencia/PUT/productos/{id}";
    public static final String HTTP_PRODUCTO_DELETE = "/tienda-conveniencia/DELETE/productos/{id}";
    public static final String HTTP_CATEGORIA_GET = "/tienda-conveniencia/GET/categorias/";
    public static final String HTTP_CATEGORIA_POST = "/tienda-conveniencia/POST/categorias/";
    public static final String HTTP_CATEGORIA_GET_ID = "/tienda-conveniencia/GET/categorias/{id}";
    public static final String HTTP_CATEGORIA_PUT = "/tienda-conveniencia/PUT/categorias/{id}";
    public static final String HTTP_CATEGORIA_DELETE = "tienda-conveniencia/DELETE/categorias/{id}";
    public static final String HTTP_MARCAS_GET = "tienda-conveniencia/GET/marcas/";
    public static final String HTTP_MARCAS_POST = "tienda-conveniencia/POST/marcas/";
    public static final String HTTP_MARCAS_GET_ID = "tienda-conveniencia/GET/marcas/{id}";
    public static final String HTTP_MARCAS_PUT = "tienda-conveniencia/PUT/marcas/{id}";
    public static final String HTTP_MARCAS_DELETE = "tienda-conveniencia/DELETE/marcas/{id}";
    public static final String HTTP_LOTES_POST = "tienda-conveniencia/POST/lotes/";
    public static final String HTTP_LOTES_GET = "tienda-conveniencia/GET/lotes/";
    public static final String HTTP_LOTES_GET_PRODUCTO_ID = "tienda-conveniencia/GET/lotes/producto/{idProducto}";
    public static final String HTTP_LOTES_GET_ID = "tienda-conveniencia/GET/lotes/{id}";
    public static final String HTTP_LOTES_PUT = "tienda-conveniencia/PUT/lotes/{id}";
    public static final String HTTP_LOTES_DELETE = "tienda-conveniencia/DELETE/lotes/{id}";
    public static final String HTTP_VENTAS_GET = "tienda-conveniencia/GET/ventas/";
    public static final String HTTP_VENTAS_POST = "tienda-conveniencia/POST/ventas/";
    public static final String HTTP_VENTAS_ID_GET = "tienda-conveniencia/GET/ventas/{id}";
    public static final String HTTP_VENTAS_PUT = "tienda-conveniencia/PUT/ventas/{id}";
    public static final String HTTP_RECETAS_GET = "tienda-conveniencia/GET/recetas/{idProducto}";
    public static final String HTTP_RECETAS_PUT = "tienda-conveniencia/PUT/recetas/{idProducto}";
    public static final String HTTP_RECETAS_POST = "tienda-conveniencia/POST/recetas/";
    public static final String HTTP_RECETAS_DELETE = "tienda-conveniencia/DELETE/recetas/{idAsignacion}";
    public static final String HTTP_RECETA_PATCH = "tienda-conveniencia/PATCH/recetas/{idAsignacion}";

    /**
     * Constructor privadoo.
     */
    private MCSVTienda() {
    }
}
