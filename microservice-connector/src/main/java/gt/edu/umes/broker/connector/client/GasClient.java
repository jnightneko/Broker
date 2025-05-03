/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.client;

import gt.edu.umes.broker.core.Microservice;
import static gt.edu.umes.broker.core.endpoints.MCSVGas.*;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Clase encargado de gestionar la conexión con el servicio de 'Conbustible', 
 * interfaz encargado de implementar los enlaces a los endpoints de dicho servicio.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(value = "MCSV-CombustibleGas", url = Microservice.MICROSERVICE_GAS)
public interface GasClient {
    /**
     * Obtener todas las gasolinas 
     * @return objeto web
     */
    @GetMapping(HTTP_BOMB_LIST)
    public Object nBomBList();    
    /**
     * Obtener solo las bombas que se encuentran en estado activo
     * @return objeto web
     */
    @GetMapping(HTTP_BOMB_LIST_ACTIVE)
    public Object nBomBListActive();    
    /**
     * Obtener solo las bombas que se encuentran en estado inactivo
     * @return objeto web
     */
    @GetMapping(HTTP_BOMB_LIST_INACTIVE)
    public Object nBombListInactive();
    /**
     * Obtener solo las bombas que se encuentran en estado de mantenimiento
     * @return objeto web
     */
    @GetMapping(HTTP_BOMB_LIST_MAINTEANCE)
    public Object nBombListMainteance();
    /**
     * Devuelve una bomba en específico en base al id
     * @param id id:long
     * @return objeto web
     */
    @GetMapping(HTTP_BOMB_LIST_BOMBID)
    public Object nBombListBombId(@PathVariable("bombId") Object id);
    /**
     * Crear una bomba de servicio de gasolina
     * @param o id:long
     * @return objeto web
     */
    @PostMapping(HTTP_BOMB_CREATE)
    public Object nBombCreate(@RequestBody Object o);
    /**
     * Actualizar una bomba de gasolina
     * @param id id:long
     * @param o objeto web
     * @return objeto web
     */
    @PatchMapping(HTTP_BOMB_UPDATE)
    public Object nBombUpdate(@PathVariable("bombId") Object id,@RequestBody Object o);
    /**
     * Eliminar una bomba de gasolina
     * @param id id:long
     * @return objeto web
     */
    @PatchMapping(HTTP_BOMB_DELETE)
    public Object nBombDelete(@PathVariable("bombId") Object id);
    /**
     * Obtener todos los tipos de gasolina
     * @return objeto web
     */
    @GetMapping(HTTP_FUEL_TYPE_LIST)
    public Object nFuelTypeList();
    /**
     * Devuelve un tipo de gasolina específico
     * @param id id:long
     * @return objeto web
     */
    @GetMapping(HTTP_FUEL_TYPE_LIST_ID)
    public Object nFuelTypeListId(@PathVariable("fuelId") Object id);
    /**
     * Crear un tipo de gasolina
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(HTTP_FUEL_TYPE_CREATE)
    public Object nFuelTypeCreate(@RequestBody Object o);
    /**
     * Actualizar un tipo de gasolina
     * @param id id:long
     * @param o objeto web
     * @return objeto web
     */
    @PatchMapping(HTTP_FUEL_TYPE_UPDATE)
    public Object nFuelTypeUpdate(@PathVariable("fuelId") Object id, @RequestBody Object o);
    /**
     * Eliminar un tipo de gasolina
     * @param id id:long
     * @return objeto web
     */
    @PatchMapping(HTTP_FUEL_TYPE_DELETE)
    public Object nFuelTypeDelete(@PathVariable("fuelId") Object id);
    /**
     * Lista todas las ventas de combustible
     * @return objeto web
     */
    @GetMapping(HTTP_SALE_LIST)
    public Object nSaleList();
    /**
     * Devuelve una venta de combustible específica
     * @param id id:long
     * @return objeto web
     */
    @GetMapping(HTTP_SALE_LIST_FUEL_SALE_ID)
    public Object nSaleListFuelSaleId(@PathVariable("fuelSaleId") Object id);
    /**
     * Realiza una venta de combustible
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(HTTP_SALE_CREATE)
    public Object nSaleCreate(@RequestBody Object o);
    /**
     * Edita una venta de combustible
     * @param id id:long
     * @param o objeto web
     * @return objeto web
     */
    @PatchMapping(HTTP_SALE_UPDATE)
    public Object nSaleUpdate(@PathVariable("fuelSaleId") Object id, @RequestBody Object o);
    /**
     * Borra lógicamente una venta de combustible
     * @param id id:long
     * @return objeto web
     */
    @PatchMapping(HTTP_SALE_DELETE)
    public Object nSaleDelerte(@PathVariable("fuelSaleId") Object id);
    /**
     * Lista todos los depósitos generales de combustible.
     * @return objeto web
     */
    @GetMapping(HTTP_GENERAL_DEPOSIT_LIST)
    public Object nGeneralDepositList();    
    /**
     * Obtener un depósito general de combustible específico.
     * @param id id:long
     * @return objeto web
     */
    @GetMapping(HTTP_GENERAL_DEPOSIT_LIST_ID)
    public Object nGenaralDepositListId(@PathVariable("generalDepositId") Object id);
    /**
     * Guarda un nuevo depósito general de combustible.
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(HTTP_GENERAL_DEPOSIT_CREATE)
    public Object nGeneralDepositCreate(@RequestBody Object o);
    /**
     * Edita un depósito general de combustible.
     * @param id id:long
     * @param o objeto web
     * @return objeto web
     */
    @PatchMapping(HTTP_GENERAL_DEPOSIT_UPDATE)
    public Object nGeneralDepositUpdate(@PathVariable("generalDepositId") Object id, @RequestBody Object o);
    /**
     * Borra lógicamente un depósito general de combustible.
     * @param id id:long
     * @return objeto web
     */
    @PatchMapping(HTTP_GENERAL_DEPOSIT_DELETE)
    public Object nGeneralDepositDelete(@PathVariable("generalDepositId") Object id);
    /**
     * Lista todas las alertas generadas por el microservicio.
     * @return objeto web
     */
    @GetMapping(HTTP_ALERT_LIST)
    public Object nAlertList();
    /**
     * Obtener una alerta específica.
     * @param id id:long
     * @return objeto web
     */
    @GetMapping(HTTP_ALERT_LIST_ID)
    public Object nAlertListId(@PathVariable("alertId") Object id);
    /**
     * Guarda una nueva alerta.
     * @param o objeto web
     * @return objeto web
     */
    @PostMapping(HTTP_ALERT_CREATE)
    public Object nAlertCreate(@RequestBody Object o);
    /**
     * Edita una alerta
     * @param id objeto web
     * @return objeto web
     */
    @PatchMapping(HTTP_ALERT_UPDATE)
    public Object nAlretUpdate(@PathVariable("alertId") Object id);
    /**
     * Borra lógicamente una alerta.
     * @param id id:long
     * @return objeto web
     */
    @PatchMapping(HTTP_ALERT_DELETE)
    public Object nAlertDelete(@PathVariable("alertId") Object id);    
}
