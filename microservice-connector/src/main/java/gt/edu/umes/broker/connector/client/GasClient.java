/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.client;

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
@FeignClient(value = "MCSV-CombustibleGas", url = "http://localhost:3002/")
public interface GasClient {    
    //******************************************************************************************************************
    //**    RUTA DE ELNLACES
    public static final String HTTP_BOMB_LIST                = "bomb/list";
    public static final String HTTP_BOMB_LIST_ACTIVE         = "bomb/list/active";
    public static final String HTTP_BOMB_LIST_INACTIVE       = "bomb/list/inactive";
    public static final String HTTP_BOMB_LIST_MAINTEANCE     = "bomb/list/mainteance";
    public static final String HTTP_BOMB_LIST_BOMBID         = "bomb/list/{bombId}";
    public static final String HTTP_BOMB_CREATE              = "bomb/create";
    public static final String HTTP_BOMB_UPDATE              = "bomb/update/{bombId}";
    public static final String HTTP_BOMB_DELETE              = "bomb/delete/{bombId}";
    public static final String HTTP_FUEL_TYPE_LIST           = "fuelType/list";
    public static final String HTTP_FUEL_TYPE_LIST_ID        = "fuelType/list/{fuelId}";
    public static final String HTTP_FUEL_TYPE_CREATE         = "fuelType/create";
    public static final String HTTP_FUEL_TYPE_UPDATE         = "fuelType/update/{fuelId}";
    public static final String HTTP_FUEL_TYPE_DELETE         = "fuelType/delete/{fuelId}";
    public static final String HTTP_SALE_LIST                = "sale/list";
    public static final String HTTP_SALE_LIST_FUEL_SALE_ID   = "sale/list/{fuelSaleId}";
    public static final String HTTP_SALE_CREATE              = "sale/create";
    public static final String HTTP_SALE_UPDATE              = "sale/update/{fuelSaleId}";
    public static final String HTTP_SALE_DELETE              = "sale/delete/{fuelSaleId}";
    public static final String HTTP_GENERAL_DEPOSIT_LIST     = "generalDeposit/list";
    public static final String HTTP_GENERAL_DEPOSIT_LIST_ID  = "generalDeposit/list/{generalDepositId}";
    public static final String HTTP_GENERAL_DEPOSIT_CREATE   = "generalDeposit/create";
    public static final String HTTP_GENERAL_DEPOSIT_UPDATE   = "generalDeposit/update/{generalDepositId}";
    public static final String HTTP_GENERAL_DEPOSIT_DELETE   = "generalDeposit/delete/{generalDepositId}";
    public static final String HTTP_ALERT_LIST               = "alert/list";
    public static final String HTTP_ALERT_LIST_ID            = "alert/list/{alertId}";
    public static final String HTTP_ALERT_CREATE             = "alert/create";
    public static final String HTTP_ALERT_UPDATE             = "alert/update/{alertId}";
    public static final String HTTP_ALERT_DELETE             = "alert/delete/{alertId}";
    
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
    public Object nBombListBombId(@PathVariable("bombId") Long id);
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
    public Object nBombUpdate(@PathVariable("bombId") Long id,@RequestBody Object o);
    /**
     * Eliminar una bomba de gasolina
     * @param id id:long
     * @return objeto web
     */
    @PatchMapping(HTTP_BOMB_DELETE)
    public Object nBombDelete(@PathVariable("bombId") Long id);
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
    public Object nFuelTypeListId(@PathVariable("fuelId") Long id);
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
    public Object nFuelTypeUpdate(@PathVariable("fuelId") Long id, @RequestBody Object o);
    /**
     * Eliminar un tipo de gasolina
     * @param id id:long
     * @return objeto web
     */
    @PatchMapping(HTTP_FUEL_TYPE_DELETE)
    public Object nFuelTypeDelete(@PathVariable("fuelId") Long id);
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
    public Object nSaleListFuelSaleId(@PathVariable("fuelSaleId") Long id);
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
    public Object nSaleUpdate(@PathVariable("fuelSaleId") Long id, @RequestBody Object o);
    /**
     * Borra lógicamente una venta de combustible
     * @param id id:long
     * @return objeto web
     */
    @PatchMapping(HTTP_SALE_DELETE)
    public Object nSaleDelerte(@PathVariable("fuelSaleId") Long id);
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
    public Object nGenaralDepositListId(@PathVariable("generalDepositId") Long id);
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
    public Object nGeneralDepositUpdate(@PathVariable("generalDepositId") Long id, @RequestBody Object o);
    /**
     * Borra lógicamente un depósito general de combustible.
     * @param id id:long
     * @return objeto web
     */
    @PatchMapping(HTTP_GENERAL_DEPOSIT_DELETE)
    public Object nGeneralDepositDelete(@PathVariable("generalDepositId") Long id);
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
    public Object nAlertListId(@PathVariable("alertId") Long id);
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
    public Object nAlretUpdate(@PathVariable("alertId") Long id);
    /**
     * Borra lógicamente una alerta.
     * @param id id:long
     * @return objeto web
     */
    @PatchMapping(HTTP_ALERT_DELETE)
    public Object nAlertDelete(@PathVariable("alertId") Long id);    
}
