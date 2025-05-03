/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.client;

import gt.edu.umes.broker.core.Microservice;
import static gt.edu.umes.broker.core.endpoints.MCSVPagos.*;

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
@FeignClient(value = "MCSV-PagosClient", url = Microservice.MICROSERVICE_PAGOS)
public interface PagosClient {    
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
    public Object pClienteObtener(@PathVariable("nit") Object nit);
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
    public Object pClienteEliminar(@PathVariable("id_cliente") Object id);
    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @param id parámetro (body)
     * @return objeto json
     */
    @PutMapping(PAGOS_CLIENTE_FIDELIDAD_CREAR)
    public Object pClienteFidelidadCrear(@PathVariable("id_cliente") Object id);
    /**
     * Método encargado de enlazar la ruta (endpoint) del microservicio 'Pagos'.
     * @param id parámetro (body)
     * @return objeto json
     */
    @PutMapping(PAGOS_CLIENTE_FIDELIDAD_DESACTIVAR)
    public Object pClienteFidelidadDesactivar(@PathVariable("id_cliente") Object id);
    
    //***************************************************************************************************
    // >>                                        MÓDULO PAGOS                                          <<
    /**
     * lista todos los métodos de pago disponibles
     * @return objeto web
     */
    @GetMapping(PAGOS_METODO_OBTENER)
    public Object pMetodoObtener();
    /**
     * busca el método de pago por el id
     * @param id id|long
     * @return objeto web
     */
    @GetMapping(PAGOS_METODO_OBTENER_ID)
    public Object pMetodoObtenerId(@PathVariable("idMetodo") Object id);
    
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
    public Object pMetodoEliminar(@PathVariable("id_metodo") Object id);
    
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
    public Object pTransaccionObtenerId(@PathVariable("noTransaccion") Object id);
    /**
     * Lista las transacciones hechas filtradas por servicio
     * @param id parámetro (body)
     * @return objeto json
     */
    @GetMapping(PAGOS_TRANSACCION_OBTENER_POR_SERVICIO)
    public Object pTransaccionPorServicio(@PathVariable("idServicio") Object id);
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
    public Object pTransaccionAnular(@PathVariable("noTransaccion") Object id);
        
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
    public Object pDevolucionObtenerId(@PathVariable("noDevolucion") Object id);
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
    public Object pBancosObtener(@PathVariable("id") Object id);
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
    public Object pBancoEliminar(@PathVariable("id") Object id);
    
    //***************************************************************************************************
    // >>                                        MÓDULO FACTURAS                                       <<
    /**
     * Devuelve la factura que coincida con el numero ingresado si existe
     * @param id parámetro (body)
     * @return objeto json
     */
    @GetMapping(PAGOS_FACTURA_OBTENER)
    public Object pFacturaObtener(@PathVariable("noFactura") Object id);
    /**
     * Anula una factura
     * @param id parámetro (body)
     * @return objeto json
     */
    @PutMapping(PAGOS_FACTURA_ANULAR)
    public Object pFacturaAnular(@PathVariable("noFactura") Object id);
    
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
