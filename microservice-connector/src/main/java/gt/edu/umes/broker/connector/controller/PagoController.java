/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import gt.edu.umes.broker.connector.client.PagosClient;
import static gt.edu.umes.broker.connector.client.PagosClient.*;

/**
 * Clase encargado de gestionar el redireccionamiento de las peticiones a las direcciones correctas.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/broker/__connection__/")
public final class PagoController {
    @Autowired
    private PagosClient client;
    /* (non-Javadoc) */
    @PostMapping(PAGOS_CLIENTE_OBTENER)
    public Object getClienteObtener() {
        return client.pClienteObtener();
    }
    /* (non-Javadoc) */
    @PostMapping(PAGOS_CLIENTE_OBTENER_NIT)
    public Object getClienteObtener(@PathVariable("nit") Long nit) {
        return client. pClienteObtener(nit);
    }    
    /* (non-Javadoc) */
    @PostMapping(PAGOS_CLIENTE_CREAR)
    public Object getClienteCrear(@RequestBody Object value) {
        return client.pClienteCrear(value);
    }    
    /* (non-Javadoc) */
    @PostMapping(PAGOS_CLIENTE_ACTUALIZAR)
    public Object getClienteActualizar(@RequestBody Object value) {
        return client.pClienteActualizar(value);
    }
    /* (non-Javadoc) */
    @PostMapping(PAGOS_CLIENTE_ELIMINAR)
    public Object getClienteEliminar(@PathVariable("id_cliente") Long id) {
        return client.pClienteEliminar(id);
    }
    /* (non-Javadoc) */
    @PostMapping(PAGOS_CLIENTE_FIDELIDAD_CREAR)
    public Object getClienteFidelidadCrear(@PathVariable("id_cliente") Long id) {
        return client.pClienteFidelidadCrear(id);
    }
    /* (non-Javadoc) */
    @PostMapping(PAGOS_CLIENTE_FIDELIDAD_DESACTIVAR)
    public Object getClienteFidelidadDesactivar(@PathVariable("id_cliente") Long id) {
        return client.pClienteFidelidadDesactivar(id);
    }
    
    //***************************************************************************************************
    // >>                                        MÓDULO PAGOS                                          <<
    /* (non-Javadoc) */
    @PostMapping(PAGOS_METODO_OBTENER)
    public Object nMetodoObtener() {
        return client.pMetodoObtener();
    }
    /* (non-Javadoc) */
    @PostMapping(PAGOS_METODO_OBTENER_ID)
    public Object nMetodoObtenerId(@PathVariable("idMetodo") Long id) {
        return client.pMetodoObtenerId(id);
    }
    /* (non-Javadoc) */
    @PostMapping(PAGOS_METODO_CREAR)
    public Object getMetodoCrear(@RequestBody Object value) {
        return client.pMetodoCrear(value);
    }
    /* (non-Javadoc) */
    @PostMapping(PAGOS_METODO_ELIMINAR)
    public Object getMetodoEliminar(@PathVariable("id_metodo") Long id) {
        return client.pMetodoEliminar(id);
    }
    
    
    //***************************************************************************************************
    // >>                                   MÓDULO TRANSACCIONES                                       <<
    /* (non-Javadoc) */
    @PostMapping(PAGOS_TRANSACCION_OBTENER)
    public Object getTransaccionObtener(@RequestBody Object value) {
        return client.pTransaccionObtener(value);
    }
    /* (non-Javadoc) */
    @PostMapping(PAGOS_TRANSACCION_OBTENER_PARAM)
    public Object getTransaccionObtener(@PathVariable("noTransaccion") Long id) {
        return client.pTransaccionObtener(id);
    }
    /* (non-Javadoc) */
    @PostMapping(PAGOS_TRANSACCION_OBTENER_POR_SERVICIO)
    public Object getTransaccionPorServicio(@PathVariable("idServicio") Long id) {
        return client.pTransaccionPorServicio(id);
    }
    /* (non-Javadoc) */
    @PostMapping(PAGOS_TRANSACCION_CREAR)
    public Object getTransaccionCrear(@RequestBody Object value) {
        return client.pTransaccionCrear(value);
    }
    /* (non-Javadoc) */
    @PostMapping(PAGOS_TRANSACCION_ANULAR)
    public Object getTransaccionAnular(@PathVariable("noTransaccion") Long id) {
        return client.pTransaccionAnular(id);
    }
    
    //***************************************************************************************************
    // >>                                    MÓDULO DEVOLUCIONES                                       <<
    /* (non-Javadoc) */
    @PostMapping(PAGOS_DEVOLUCION_OBTENER)
    public Object getDevolucionObtener(@RequestBody Object value) {
        return client.pDevolucionObtener(value);
    }
    /* (non-Javadoc) */
    @PostMapping(PAGOS_DEVOLUCION_OBTENER_PARAM)
    public Object getDevolucionObtener(@PathVariable("noDevolucion") Long id) {
        return client.pDevolucionObtener(id);
    }
    /* (non-Javadoc) */
    @PostMapping(PAGOS_DEVOLUCION_CREAR)
    public Object getDevolucionCrear(@RequestBody Object value) {
        return client.pDevolucionCrear(value);
    }
    
    
    //***************************************************************************************************
    // >>                                        MÓDULO BANCO                                          <<
    /* (non-Javadoc) */
    @PostMapping(PAGOS_BANCOS_OBTENER)
    public Object getBancosObtener() {
        return client.pBancosObtener();
    }
    /* (non-Javadoc) */
    @PostMapping(PAGOS_BANCO_OBTENER_PARAM)
    public Object getBancosObtener(@PathVariable("id") Long id) {
        return client.pBancosObtener(id);
    }
    /* (non-Javadoc) */
    @PostMapping(PAGOS_BANCO_CREAR)
    public Object getBancoCrear(@RequestBody Object value) {
        return client.pBancoCrear(value);
    }
    /* (non-Javadoc) */
    @PostMapping(PAGOS_BANCO_ELIMINAR)
    public Object getBancoEliminar(@PathVariable("id") Long id) {
        return client.pBancoEliminar(id);
    }
    
    
    //***************************************************************************************************
    // >>                                        MÓDULO FACTURAS                                       <<
    /* (non-Javadoc) */
    @PostMapping(PAGOS_FACTURA_OBTENER)
    public Object getFacturaObtener(@PathVariable("noFactura") Long id) {
        return client.pFacturaObtener(id);
    }
    /* (non-Javadoc) */
    @PostMapping(PAGOS_FACTURA_ANULAR)
    public Object getFacturaAnular(@PathVariable("noFactura") Long id) {
        return client.pFacturaAnular(id);
    }
    
    
    //***************************************************************************************************
    // >>                                        CIERRE DE CAJAS                                        <<
    /* (non-Javadoc) */
    @PostMapping(PAGOS_CIERRE_OBTENER)
    public Object getCierreObtener() {
        return client.pCierreObtener();
    }
    /* (non-Javadoc) */
    @PostMapping(PAGOS_CIERRE_CREAR)
    public Object getCierreCrear(@RequestBody Object value) {
        return client.pCierreCrear(value);
    }
    /* (non-Javadoc) */
    @PostMapping(PAGOS_RETIRO)
    public Object getRetiro(@RequestBody Object value) {
        return client.pRetiro(value);
    }
}
