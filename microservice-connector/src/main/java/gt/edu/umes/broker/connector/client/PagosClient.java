/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.client;

import gt.edu.umes.broker.connector.http.WebObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Clase encargado de gestionar la conexión con el servicio de 'Pagos', objeto encargado de implementar los
 * enlaces a los endpoints de dicho servicios.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(value = "MCSV-PagosClient", url = "http://localhost:3001/")
public interface PagosClient {
    //***************************************************************************************************
    // >>                                   MÓDULO CLIEBTES                                           <<
    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @see #PAGOS_CLIENTE_OBTENER
     * 
     * @return objeto json
     */
    @GetMapping(PAGOS_CLIENTE_OBTENER)
    public WebObject pClienteObtener();
    public static final String PAGOS_CLIENTE_OBTENER        = "/pagos/cliente/obtener";

    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @param nit parámetro (path-variable)
     * 
     * @see #PAGOS_CLIENTE_OBTENER_NIT
     * 
     * @return objeto json
     */
    @GetMapping(PAGOS_CLIENTE_OBTENER_NIT)
    public WebObject pClienteObtener(@PathVariable("nit") Long nit);
    public static final String PAGOS_CLIENTE_OBTENER_NIT    = "/pagos/clientes/obtener/{nit}";
    
    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @param value parámetro (body)
     * 
     * @see #PAGOS_CLIENTE_CREAR
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_CLIENTE_CREAR)
    public WebObject pClienteCrear(@RequestBody WebObject value);
    public static final String PAGOS_CLIENTE_CREAR          = "/pagos/cliente/crear";
    
    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @param value parámetro (body)
     * 
     * @see #PAGOS_CLIENTE_ACTUALIZAR
     * 
     * @return objeto json
     */
    @PutMapping(PAGOS_CLIENTE_ACTUALIZAR)
    public WebObject pClienteActualizar(@RequestBody WebObject value);
    public static final String PAGOS_CLIENTE_ACTUALIZAR     = "/pagos/cliente/actualizar/{id_cliente}";
    
    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @param id parámetro (body)
     * 
     * @see #PAGOS_CLIENTE_ELIMINAR
     * 
     * @return objeto json
     */
    @PutMapping(PAGOS_CLIENTE_ELIMINAR)
    public WebObject pClienteEliminar(@PathVariable("id_cliente") Long id);
    public static final String PAGOS_CLIENTE_ELIMINAR       = "/pagos/cliente/eliminar/{id_cliente}";
    
    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @param id parámetro (body)
     * 
     * @see #PAGOS_CLIENTE_FIDELIDAD_CREAR
     * 
     * @return objeto json
     */
    @PutMapping(PAGOS_CLIENTE_FIDELIDAD_CREAR)
    public WebObject pClienteFidelidadCrear(@PathVariable("id_cliente") Long id);
    public static final String PAGOS_CLIENTE_FIDELIDAD_CREAR = "pagos/cliente/fidelidad/crear/{id_cliente}";
    
    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @param id parámetro (body)
     * 
     * @see #PAGOS_CLIENTE_FIDELIDAD_DESACTIVAR
     * 
     * @return objeto json
     */
    @PutMapping(PAGOS_CLIENTE_FIDELIDAD_DESACTIVAR)
    public WebObject pClienteFidelidadDesactivar(@PathVariable("id_cliente") Long id);
    public static final String PAGOS_CLIENTE_FIDELIDAD_DESACTIVAR = "pagos/cliente/fidelidad/desactivar/{id_cliente}";
    
    
    //***************************************************************************************************
    // >>                                        MÓDULO PAGOS                                          <<
    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @param value parámetro (body)
     * 
     * @see #PAGOS_METODO_CREAR
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_METODO_CREAR)
    public WebObject pMetodoCrear(@RequestBody WebObject value);
    public static final String PAGOS_METODO_CREAR                   = "/pagos/metodos/crear";
    
    /**
     * Elimina lógicamente un método de pago.
     * @param id parámetro (body)
     * 
     * @see #PAGOS_METODO_ELIMINAR
     * 
     * @return objeto json
     */
    @PutMapping(PAGOS_METODO_ELIMINAR)
    public WebObject pMetodoEliminar(@PathVariable("id_metodo") Long id);
    public static final String PAGOS_METODO_ELIMINAR                = "/pagos/metodo/eliminar/{id_metodo}";
    
    
    //***************************************************************************************************
    // >>                                   MÓDULO TRANSACCIONES                                       <<
    /**
     * Lista todas las transacciones realizadas, acepta fechas de entrada para filtrar pero de no haber devuelve todas las transacciones
     * @param value parámetro (body)
     * 
     * @see #PAGOS_TRANSACCION_OBTENER
     * 
     * @return objeto json
     */
    @GetMapping(PAGOS_TRANSACCION_OBTENER)
    public WebObject pTransaccionObtener(@RequestBody WebObject value);
    public static final String PAGOS_TRANSACCION_OBTENER            = "/pagos/transacciones/obtener";
    
    /**
     * Lista la transacción solicitada mediante el id
     * @param id parámetro (body)
     * 
     * @see #PAGOS_TRANSACCION_OBTENER_PARAM
     * 
     * @return objeto json
     */
    @GetMapping(PAGOS_TRANSACCION_OBTENER_PARAM)
    public WebObject pTransaccionObtener(@PathVariable("noTransaccion") Long id);
    public static final String PAGOS_TRANSACCION_OBTENER_PARAM      = "/pagos/transacciones/obtener/{noTransaccion}";
    
    /**
     * Lista las transacciones hechas filtradas por servicio
     * @param id parámetro (body)
     * 
     * @see #PAGOS_TRANSACCION_OBTENER_POR_SERVICIO
     * 
     * @return objeto json
     */
    @GetMapping(PAGOS_TRANSACCION_OBTENER_POR_SERVICIO)
    public WebObject pTransaccionPorServicio(@PathVariable("idServicio") Long id);
    public static final String PAGOS_TRANSACCION_OBTENER_POR_SERVICIO= "/pagos/transacciones/obtenerPorServicio/{idServicio}";
    
    /**
     * Solicita datos necesarios para crear una transacción
     * @param value parámetro (body)
     * 
     * @see #PAGOS_TRANSACCION_CREAR
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_TRANSACCION_CREAR)
    public WebObject pTransaccionCrear(@RequestBody WebObject value);
    public static final String PAGOS_TRANSACCION_CREAR              = "/pagos/transaccion/crear";
    
    /**
     * Anula una transacción
     * @param id parámetro (body)
     * 
     * @see #PAGOS_TRANSACCION_ANULAR
     * 
     * @return objeto json
     */
    @PutMapping(PAGOS_TRANSACCION_ANULAR)
    public WebObject pTransaccionAnular(@PathVariable("noTransaccion") Long id);
    public static final String PAGOS_TRANSACCION_ANULAR             = "/pagos/transaccion/anular/{noTransaccion}";
    
    
    //***************************************************************************************************
    // >>                                    MÓDULO DEVOLUCIONES                                       <<
    /**
     * Devuelve todas las devoluciones realizadas, acepta fechas de entrada para filtrar pero de no haber devuelve todas las devoluciones
     * @param value parámetro (body)
     * 
     * @see #PAGOS_DEVOLUCION_OBTENER
     * 
     * @return objeto json
     */
    @GetMapping(PAGOS_DEVOLUCION_OBTENER)
    public WebObject pDevolucionObtener(@RequestBody WebObject value);
    public static final String PAGOS_DEVOLUCION_OBTENER             = "pagos/devoluciones/obtener";
    
    /**
     * Busca la devolución por el número dado
     * @param id parámetro (body)
     * 
     * @see #PAGOS_DEVOLUCION_OBTENER_PARAM
     * 
     * @return objeto json
     */
    @GetMapping(PAGOS_DEVOLUCION_OBTENER_PARAM)
    public WebObject pDevolucionObtener(@PathVariable("noDevolucion") Long id);
    public static final String PAGOS_DEVOLUCION_OBTENER_PARAM       = "/pagos/devoluciones/obtener/{noDevolucion}";
    
    /**
     * Hacer una devolución
     * @param value parámetro (body)
     * 
     * @see #PAGOS_DEVOLUCION_CREAR
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_DEVOLUCION_CREAR)
    public WebObject pDevolucionCrear(@RequestBody WebObject value);
    public static final String PAGOS_DEVOLUCION_CREAR               = "/pagos/devoluciones/crear";
    
    
    //***************************************************************************************************
    // >>                                        MÓDULO BANCO                                          <<
    /**
     * Devuelve un listado de los bancos con los que se trabaja
     * @see #PAGOS_BANCOS_OBTENER
     * 
     * @return objeto json
     */
    @GetMapping(PAGOS_BANCOS_OBTENER)
    public WebObject pBancosObtener();
    public static final String PAGOS_BANCOS_OBTENER                 = "/pagos/bancos/obtener";
    
    /**
     * Devuelve el banco por el id 
     * @param id parámetro (body)
     * 
     * @see #PAGOS_BANCO_OBTENER_PARAM
     * 
     * @return objeto json
     */
    @GetMapping(PAGOS_BANCO_OBTENER_PARAM)
    public WebObject pBancosObtener(@PathVariable("IdBanco") Long id);
    public static final String PAGOS_BANCO_OBTENER_PARAM            = "/pagos/bancos/obtener/{IdBanco}";
    
    /**
     * Crea un nuevo banco
     * @param value parámetro (body)
     * 
     * @see #PAGOS_BANCO_CREAR
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_BANCO_CREAR)
    public WebObject pBancoCrear(@RequestBody WebObject value);
    public static final String PAGOS_BANCO_CREAR                    = "/pagos/bancos/crear";
    
    /**
     * Devuelve el banco por el id 
     * @param id parámetro (body)
     * 
     * @see #PAGOS_BANCO_ELIMINAR
     * 
     * @return objeto json
     */
    @PutMapping(PAGOS_BANCO_ELIMINAR)
    public WebObject pBancoEliminar(@PathVariable("id_banco") Long id);
    public static final String PAGOS_BANCO_ELIMINAR                 = "/pagos/bancos/eliminar/{id_banco}";
    
    
    //***************************************************************************************************
    // >>                                        MÓDULO FACTURAS                                       <<
    /**
     * Devuelve la factura que coincida con el numero ingresado si existe
     * @param id parámetro (body)
     * 
     * @see #PAGOS_FACTURA_OBTENER
     * 
     * @return objeto json
     */
    @GetMapping(PAGOS_FACTURA_OBTENER)
    public WebObject pFacturaObtener(@PathVariable("noFactura") Long id);
    public static final String PAGOS_FACTURA_OBTENER                 = "/pagos/facturas/obtener/{noFactura}";
    
    /**
     * Anula una factura
     * @param id parámetro (body)
     * 
     * @see #PAGOS_FACTURA_ANULAR
     * 
     * @return objeto json
     */
    @PutMapping(PAGOS_FACTURA_ANULAR)
    public WebObject pFacturaAnular(@PathVariable("noFactura") Long id);
    public static final String PAGOS_FACTURA_ANULAR                  = "/pagos/facturas/anular/{noFactura}";
    
    
    //***************************************************************************************************
    // >>                                        CIERRE DE CAJAS                                        <<
    /**
     * Lista todos los cierres de caja realizados
     * @see #PAGOS_CIERRE_OBTENER
     * 
     * @return objeto json
     */
    @GetMapping(PAGOS_CIERRE_OBTENER)
    public WebObject pCierreObtener();
    public static final String PAGOS_CIERRE_OBTENER                  = "/pagos/cierre/obtener";
    
    /**
     * Realizar un cierre de caja
     * @param value parámetro (body)
     * 
     * @see #PAGOS_CIERRE_CREAR
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_CIERRE_CREAR)
    public WebObject pCierreCrear(@RequestBody WebObject value);
    public static final String PAGOS_CIERRE_CREAR                   = "/pagos/cierre/crear";
    
    /**
     * Realizar un retiro de caja
     * @param value parámetro (body)
     * 
     * @see #PAGOS_RETIRO
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_RETIRO)
    public WebObject pRetiro(@RequestBody WebObject value);
    public static final String PAGOS_RETIRO                         = "/pagos/retiros";
}
