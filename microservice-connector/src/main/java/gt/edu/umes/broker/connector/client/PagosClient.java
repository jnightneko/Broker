/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.client;

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
    //******************************************************************************************************************
    //**    RUTA DE ELNLACES
    public static final String PAGOS_CLIENTE_OBTENER                    = "/pagos/cliente/obtener";
    public static final String PAGOS_CLIENTE_OBTENER_NIT                = "/pagos/clientes/obtener/{nit}";
    public static final String PAGOS_CLIENTE_CREAR                      = "/pagos/cliente/crear";
    public static final String PAGOS_CLIENTE_ACTUALIZAR                 = "/pagos/cliente/actualizar/{id_cliente}";
    public static final String PAGOS_CLIENTE_ELIMINAR                   = "/pagos/cliente/eliminar/{id_cliente}";
    public static final String PAGOS_CLIENTE_FIDELIDAD_CREAR            = "/pagos/cliente/fidelidad/crear/{id_cliente}";
    public static final String PAGOS_CLIENTE_FIDELIDAD_DESACTIVAR       = "/pagos/cliente/fidelidad/desactivar/{id_cliente}";
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
    public static final String PAGOS_BANCO_OBTENER_PARAM                = "/pagos/bancos/obtener/{IdBanco}";
    public static final String PAGOS_BANCO_CREAR                        = "/pagos/bancos/crear";
    public static final String PAGOS_BANCO_ELIMINAR                     = "/pagos/bancos/eliminar/{id_banco}";
    public static final String PAGOS_FACTURA_OBTENER                    = "/pagos/facturas/obtener/{noFactura}";
    public static final String PAGOS_FACTURA_ANULAR                     = "/pagos/facturas/anular/{noFactura}";
    public static final String PAGOS_CIERRE_OBTENER                     = "/pagos/cierre/obtener";
    public static final String PAGOS_CIERRE_CREAR                       = "/pagos/cierre/crear";
    public static final String PAGOS_RETIRO                             = "/pagos/retiros";
    //***************************************************************************************************
    // >>                                   MÓDULO CLIEBTES                                           <<
    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @return objeto json
     */
    @GetMapping(PAGOS_CLIENTE_OBTENER)
    public Object pClienteObtener();
    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @param nit parámetro (path-variable)
     * @return objeto json
     */
    @GetMapping(PAGOS_CLIENTE_OBTENER_NIT)
    public Object pClienteObtener(@PathVariable("nit") Long nit);
    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @param value parámetro (body)
     * @return objeto json
     */
    @PostMapping(PAGOS_CLIENTE_CREAR)
    public Object pClienteCrear(@RequestBody Object value);
    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @param value parámetro (body)
     * @return objeto json
     */
    @PutMapping(PAGOS_CLIENTE_ACTUALIZAR)
    public Object pClienteActualizar(@RequestBody Object value);
    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @param id parámetro (body)
     * @return objeto json
     */
    @PutMapping(PAGOS_CLIENTE_ELIMINAR)
    public Object pClienteEliminar(@PathVariable("id_cliente") Long id);
    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @param id parámetro (body)
     * @return objeto json
     */
    @PutMapping(PAGOS_CLIENTE_FIDELIDAD_CREAR)
    public Object pClienteFidelidadCrear(@PathVariable("id_cliente") Long id);
    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @param id parámetro (body)
     * @return objeto json
     */
    @PutMapping(PAGOS_CLIENTE_FIDELIDAD_DESACTIVAR)
    public Object pClienteFidelidadDesactivar(@PathVariable("id_cliente") Long id);
    
    //***************************************************************************************************
    // >>                                        MÓDULO PAGOS                                          <<
    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @param value parámetro (body)
     * @return objeto json
     */
    @PostMapping(PAGOS_METODO_CREAR)
    public Object pMetodoCrear(@RequestBody Object value);
    /**
     * Elimina lógicamente un método de pago.
     * @param id parámetro (body)
     * @return objeto json
     */
    @PutMapping(PAGOS_METODO_ELIMINAR)
    public Object pMetodoEliminar(@PathVariable("id_metodo") Long id);
    
    //***************************************************************************************************
    // >>                                   MÓDULO TRANSACCIONES                                       <<
    /**
     * Lista todas las transacciones realizadas, acepta fechas de entrada para filtrar pero de no haber devuelve todas las transacciones
     * @param value parámetro (body)
     * @return objeto json
     */
    @GetMapping(PAGOS_TRANSACCION_OBTENER)
    public Object pTransaccionObtener(@RequestBody Object value);
    /**
     * Lista la transacción solicitada mediante el id
     * @param id parámetro (body)
     * @return objeto json
     */
    @GetMapping(PAGOS_TRANSACCION_OBTENER_PARAM)
    public Object pTransaccionObtener(@PathVariable("noTransaccion") Long id);
    /**
     * Lista las transacciones hechas filtradas por servicio
     * @param id parámetro (body)
     * @return objeto json
     */
    @GetMapping(PAGOS_TRANSACCION_OBTENER_POR_SERVICIO)
    public Object pTransaccionPorServicio(@PathVariable("idServicio") Long id);
    /**
     * Solicita datos necesarios para crear una transacción
     * @param value parámetro (body)
     * @return objeto json
     */
    @PostMapping(PAGOS_TRANSACCION_CREAR)
    public Object pTransaccionCrear(@RequestBody Object value);
    /**
     * Anula una transacción
     * @param id parámetro (body)
     * @return objeto json
     */
    @PutMapping(PAGOS_TRANSACCION_ANULAR)
    public Object pTransaccionAnular(@PathVariable("noTransaccion") Long id);
        
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
    public Object pDevolucionObtener(@RequestBody Object value);
    /**
     * Busca la devolución por el número dado
     * @param id parámetro (body)
     * @return objeto json
     */
    @GetMapping(PAGOS_DEVOLUCION_OBTENER_PARAM)
    public Object pDevolucionObtener(@PathVariable("noDevolucion") Long id);
    /**
     * Hacer una devolución
     * @param value parámetro (body)
     * @return objeto json
     */
    @PostMapping(PAGOS_DEVOLUCION_CREAR)
    public Object pDevolucionCrear(@RequestBody Object value);
    
    //***************************************************************************************************
    // >>                                        MÓDULO BANCO                                          <<
    /**
     * Devuelve un listado de los bancos con los que se trabaja
     * @return objeto json
     */
    @GetMapping(PAGOS_BANCOS_OBTENER)
    public Object pBancosObtener();
    /**
     * Devuelve el banco por el id 
     * @param id parámetro (body)
     * @return objeto json
     */
    @GetMapping(PAGOS_BANCO_OBTENER_PARAM)
    public Object pBancosObtener(@PathVariable("IdBanco") Long id);
    /**
     * Crea un nuevo banco
     * @param value parámetro (body)
     * @return objeto json
     */
    @PostMapping(PAGOS_BANCO_CREAR)
    public Object pBancoCrear(@RequestBody Object value);
    /**
     * Devuelve el banco por el id 
     * @param id parámetro (body)
     * @return objeto json
     */
    @PutMapping(PAGOS_BANCO_ELIMINAR)
    public Object pBancoEliminar(@PathVariable("id_banco") Long id);
    
    //***************************************************************************************************
    // >>                                        MÓDULO FACTURAS                                       <<
    /**
     * Devuelve la factura que coincida con el numero ingresado si existe
     * @param id parámetro (body)
     * @return objeto json
     */
    @GetMapping(PAGOS_FACTURA_OBTENER)
    public Object pFacturaObtener(@PathVariable("noFactura") Long id);
    /**
     * Anula una factura
     * @param id parámetro (body)
     * @return objeto json
     */
    @PutMapping(PAGOS_FACTURA_ANULAR)
    public Object pFacturaAnular(@PathVariable("noFactura") Long id);
    
    //***************************************************************************************************
    // >>                                        CIERRE DE CAJAS                                        <<
    /**
     * Lista todos los cierres de caja realizados
     * @return objeto json
     */
    @GetMapping(PAGOS_CIERRE_OBTENER)
    public Object pCierreObtener();
    /**
     * Realizar un cierre de caja
     * @param value parámetro (body)
     * @return objeto json
     */
    @PostMapping(PAGOS_CIERRE_CREAR)
    public Object pCierreCrear(@RequestBody Object value);
    /**
     * Realizar un retiro de caja
     * @param value parámetro (body)
     * @return objeto json
     */
    @PostMapping(PAGOS_RETIRO)
    public Object pRetiro(@RequestBody Object value);
}
