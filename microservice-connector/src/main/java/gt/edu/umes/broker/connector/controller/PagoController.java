/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.controller;

import gt.edu.umes.broker.connector.client.PagosClient;
import gt.edu.umes.broker.connector.http.WebObject;
import static gt.edu.umes.broker.connector.client.PagosClient.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Clase encargado de gestionar el redireccionamiento de las peticiones a las direcciones correctas.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/broker/__connection__/")
public final class PagoController {
    @Autowired
    private PagosClient client;
    //***************************************************************************************************
    // >>                                   MÓDULO CLIEBTES                                           <<
    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @see #PAGOS_CLIENTE_OBTENER
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_CLIENTE_OBTENER)
    public WebObject getClienteObtener() {
        return client.pClienteObtener();
    }

    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @param nit parámetro (path-variable)
     * 
     * @see #PAGOS_CLIENTE_OBTENER_NIT
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_CLIENTE_OBTENER_NIT)
    public WebObject getClienteObtener(@PathVariable("nit") Long nit) {
        return client. pClienteObtener(nit);
    }
    
    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @param value parámetro (body)
     * 
     * @see #PAGOS_CLIENTE_CREAR
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_CLIENTE_CREAR)
    public WebObject getClienteCrear(@RequestBody WebObject value) {
        return client.pClienteCrear(value);
    }
    
    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @param value parámetro (body)
     * 
     * @see #PAGOS_CLIENTE_ACTUALIZAR
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_CLIENTE_ACTUALIZAR)
    public WebObject getClienteActualizar(@RequestBody WebObject value) {
        return client.pClienteActualizar(value);
    }
    
    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @param id parámetro (body)
     * 
     * @see #PAGOS_CLIENTE_ELIMINAR
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_CLIENTE_ELIMINAR)
    public WebObject getClienteEliminar(@PathVariable("id_cliente") Long id) {
        return client.pClienteEliminar(id);
    }
    
    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @param id parámetro (body)
     * 
     * @see #PAGOS_CLIENTE_FIDELIDAD_CREAR
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_CLIENTE_FIDELIDAD_CREAR)
    public WebObject getClienteFidelidadCrear(@PathVariable("id_cliente") Long id) {
        return client.pClienteFidelidadCrear(id);
    }
    
    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @param id parámetro (body)
     * 
     * @see #PAGOS_CLIENTE_FIDELIDAD_DESACTIVAR
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_CLIENTE_FIDELIDAD_DESACTIVAR)
    public WebObject getClienteFidelidadDesactivar(@PathVariable("id_cliente") Long id) {
        return client.pClienteFidelidadDesactivar(id);
    }
    
    
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
    public WebObject getMetodoCrear(@RequestBody WebObject value) {
        return client.pMetodoCrear(value);
    }
    
    /**
     * Elimina lógicamente un método de pago.
     * @param id parámetro (body)
     * 
     * @see #PAGOS_METODO_ELIMINAR
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_METODO_ELIMINAR)
    public WebObject getMetodoEliminar(@PathVariable("id_metodo") Long id) {
        return client.pMetodoEliminar(id);
    }
    
    
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
    @PostMapping(PAGOS_TRANSACCION_OBTENER)
    public WebObject getTransaccionObtener(@RequestBody WebObject value) {
        return client.pTransaccionObtener(value);
    }
    
    /**
     * Lista la transacción solicitada mediante el id
     * @param id parámetro (body)
     * 
     * @see #PAGOS_TRANSACCION_OBTENER_PARAM
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_TRANSACCION_OBTENER_PARAM)
    public WebObject getTransaccionObtener(@PathVariable("noTransaccion") Long id) {
        return client.pTransaccionObtener(id);
    }
    
    /**
     * Lista las transacciones hechas filtradas por servicio
     * @param id parámetro (body)
     * 
     * @see #PAGOS_TRANSACCION_OBTENER_POR_SERVICIO
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_TRANSACCION_OBTENER_POR_SERVICIO)
    public WebObject getTransaccionPorServicio(@PathVariable("idServicio") Long id) {
        return client.pTransaccionPorServicio(id);
    }
    
    /**
     * Solicita datos necesarios para crear una transacción
     * @param value parámetro (body)
     * 
     * @see #PAGOS_TRANSACCION_CREAR
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_TRANSACCION_CREAR)
    public WebObject getTransaccionCrear(@RequestBody WebObject value) {
        return client.pTransaccionCrear(value);
    }
    
    /**
     * Anula una transacción
     * @param id parámetro (body)
     * 
     * @see #PAGOS_TRANSACCION_ANULAR
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_TRANSACCION_ANULAR)
    public WebObject getTransaccionAnular(@PathVariable("noTransaccion") Long id) {
        return client.pTransaccionAnular(id);
    }
    
    
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
    @PostMapping(PAGOS_DEVOLUCION_OBTENER)
    public WebObject getDevolucionObtener(@RequestBody WebObject value) {
        return client.pDevolucionObtener(value);
    }
    
    /**
     * Busca la devolución por el número dado
     * @param id parámetro (body)
     * 
     * @see #PAGOS_DEVOLUCION_OBTENER_PARAM
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_DEVOLUCION_OBTENER_PARAM)
    public WebObject getDevolucionObtener(@PathVariable("noDevolucion") Long id) {
        return client.pDevolucionObtener(id);
    }
    
    /**
     * Hacer una devolución
     * @param value parámetro (body)
     * 
     * @see #PAGOS_DEVOLUCION_CREAR
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_DEVOLUCION_CREAR)
    public WebObject getDevolucionCrear(@RequestBody WebObject value) {
        return client.pDevolucionCrear(value);
    }
    
    
    //***************************************************************************************************
    // >>                                        MÓDULO BANCO                                          <<
    /**
     * Devuelve un listado de los bancos con los que se trabaja
     * @see #PAGOS_BANCOS_OBTENER
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_BANCOS_OBTENER)
    public WebObject getBancosObtener() {
        return client.pBancosObtener();
    }
    
    /**
     * Devuelve el banco por el id 
     * @param id parámetro (body)
     * 
     * @see #PAGOS_BANCO_OBTENER_PARAM
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_BANCO_OBTENER_PARAM)
    public WebObject getBancosObtener(@PathVariable("IdBanco") Long id) {
        return client.pBancosObtener(id);
    }
    
    /**
     * Crea un nuevo banco
     * @param value parámetro (body)
     * 
     * @see #PAGOS_BANCO_CREAR
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_BANCO_CREAR)
    public WebObject getBancoCrear(@RequestBody WebObject value) {
        return client.pBancoCrear(value);
    }
    
    /**
     * Devuelve el banco por el id 
     * @param id parámetro (body)
     * 
     * @see #PAGOS_BANCO_ELIMINAR
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_BANCO_ELIMINAR)
    public WebObject getBancoEliminar(@PathVariable("id_banco") Long id) {
        return client.pBancoEliminar(id);
    }
    
    
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
    @PostMapping(PAGOS_FACTURA_OBTENER)
    public WebObject getFacturaObtener(@PathVariable("noFactura") Long id) {
        return client.pFacturaObtener(id);
    }
    
    /**
     * Anula una factura
     * @param id parámetro (body)
     * 
     * @see #PAGOS_FACTURA_ANULAR
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_FACTURA_ANULAR)
    public WebObject getFacturaAnular(@PathVariable("noFactura") Long id) {
        return client.pFacturaAnular(id);
    }
    
    
    //***************************************************************************************************
    // >>                                        CIERRE DE CAJAS                                        <<
    /**
     * Lista todos los cierres de caja realizados
     * @see #PAGOS_CIERRE_OBTENER
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_CIERRE_OBTENER)
    public WebObject getCierreObtener() {
        return client.pCierreObtener();
    }
    
    /**
     * Realizar un cierre de caja
     * @param value parámetro (body)
     * 
     * @see #PAGOS_CIERRE_CREAR
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_CIERRE_CREAR)
    public WebObject getCierreCrear(@RequestBody WebObject value) {
        return client.pCierreCrear(value);
    }
    
    /**
     * Realizar un retiro de caja
     * @param value parámetro (body)
     * 
     * @see #PAGOS_RETIRO
     * 
     * @return objeto json
     */
    @PostMapping(PAGOS_RETIRO)
    public WebObject getRetiro(@RequestBody WebObject value) {
        return client.pRetiro(value);
    }
}
