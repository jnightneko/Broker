/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.client;

import gt.edu.umes.broker.connector.http.WebObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Clase encargado de gestionar la conexión con el servicio de 'Conbustible', objeto encargado de implementar los
 * enlaces a los endpoints de dicho servicio.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(value = "MCSV-Combustible|Gas", url = "http://localhost:3002/")
public interface GasClient {
    
    /*
        Obtener todas las gasolinas 
    */
    @GetMapping(HTTP_BOMB_LIST)
    public WebObject nBomBList();
    public static final String HTTP_BOMB_LIST                = "bomb/list";
    
    /*
        Obtener solo las bombas que se encuentran en estado activo
    */
    @GetMapping(HTTP_BOMB_LIST_ACTIVE)
    public WebObject nBomBListActive();
    public static final String HTTP_BOMB_LIST_ACTIVE         = "bomb/list/active";
    
    /*
        Obtener solo las bombas que se encuentran en estado inactivo
    */
    @GetMapping(HTTP_BOMB_LIST_INACTIVE)
    public WebObject nBombListInactive();
    public static final String HTTP_BOMB_LIST_INACTIVE      = "bomb/list/inactive";
    
    /*
        Obtener solo las bombas que se encuentran en estado de mantenimiento
    */
    @GetMapping(HTTP_BOMB_LIST_MAINTEANCE)
    public WebObject nBombListMainteance();
    public static final String HTTP_BOMB_LIST_MAINTEANCE    = "bomb/list/mainteance";
    
    /*
        Devuelve una bomba en específico en base al id
    */
    @GetMapping(HTTP_BOMB_LIST_BOMBID)
    public WebObject nBombListBombId(@PathVariable("bombId") Long id);
    public static final String HTTP_BOMB_LIST_BOMBID        = "bomb/list/{bombId}";
    
    /*
        Crear una bomba de servicio de gasolina
    */
    @PostMapping(HTTP_BOMB_CREATE)
    public WebObject nBombCreate(@RequestBody WebObject o);
    public static final String HTTP_BOMB_CREATE             = "bomb/create";
    
    /*
        Actualizar una bomba de gasolina
    */
    @PatchMapping(HTTP_BOMB_UPDATE)
    public WebObject nBombUpdate(@PathVariable("bombId") Long id,@RequestBody WebObject o);
    public static final String HTTP_BOMB_UPDATE             = "bomb/update/{bombId}";
    
    /*
        Eliminar una bomba de gasolina
    */
    @PatchMapping(HTTP_BOMB_DELETE)
    public WebObject nBombDelete(@PathVariable("bombId") Long id);
    public static final String HTTP_BOMB_DELETE             = "bomb/delete/{bombId}";
    
    /*
        Obtener todos los tipos de gasolina
    */
    @GetMapping(HTTP_FUEL_TYPE_LIST)
    public WebObject nFuelTypeList();
    public static final String HTTP_FUEL_TYPE_LIST          = "fuelType/list";
    
    /*
        Devuelve un tipo de gasolina específico
    */
    @GetMapping(HTTP_FUEL_TYPE_LIST_ID)
    public WebObject nFuelTypeListId(@PathVariable("fuelId") Long id);
    public static final String HTTP_FUEL_TYPE_LIST_ID       = "fuelType/list/{fuelId}";
    
    /*
        Crear un tipo de gasolina
    */
    @PostMapping(HTTP_FUEL_TYPE_CREATE)
    public WebObject nFuelTypeCreate(@RequestBody WebObject o);
    public static final String HTTP_FUEL_TYPE_CREATE        = "fuelType/create";
    
    /*
        Actualizar un tipo de gasolina
    */
    @PatchMapping(HTTP_FUEL_TYPE_UPDATE)
    public WebObject nFuelTypeUpdate(@PathVariable("fuelId") Long id, @RequestBody WebObject o);
    public static final String HTTP_FUEL_TYPE_UPDATE        = "fuelType/update/{fuelId}";
    
    /*
        Eliminar un tipo de gasolina
    */
    @PatchMapping(HTTP_FUEL_TYPE_DELETE)
    public WebObject nFuelTypeDelete(@PathVariable("fuelId") Long id);
    public static final String HTTP_FUEL_TYPE_DELETE        = "fuelType/delete/{fuelId}";
    
    /*
        Lista todas las ventas de combustible
    */
    @GetMapping(HTTP_SALE_LIST)
    public WebObject nSaleList();
    public static final String HTTP_SALE_LIST               = "sale/list";
    
    /*
        Devuelve una venta de combustible específica
    */
    @GetMapping(HTTP_SALE_LIST_FUEL_SALE_ID)
    public WebObject nSaleListFuelSaleId(@PathVariable("fuelSaleId") Long id);
    public static final String HTTP_SALE_LIST_FUEL_SALE_ID  = "sale/list/{fuelSaleId}";
    
    /*
        Realiza una venta de combustible
    */
    @PostMapping(HTTP_SALE_CREATE)
    public WebObject nSaleCreate(@RequestBody WebObject o);
    public static final String HTTP_SALE_CREATE             = "sale/create";
    
    /*
        Edita una venta de combustible
    */
    @PatchMapping(HTTP_SALE_UPDATE)
    public WebObject nSaleUpdate(@PathVariable("fuelSaleId") Long id, @RequestBody WebObject o);
    public static final String HTTP_SALE_UPDATE             = "sale/update/{fuelSaleId}";
    
    /*
        Borra lógicamente una venta de combustible
    */
    @PatchMapping(HTTP_SALE_DELETE)
    public WebObject nSaleDelerte(@PathVariable("fuelSaleId") Long id);
    public static final String HTTP_SALE_DELETE             = "sale/delete/{fuelSaleId}";
    
    /*
        Lista todos los depósitos generales de combustible.
    */
    @GetMapping(HTTP_GENERAL_DEPOSIT_LIST)
    public WebObject nGeneralDepositList();
    public static final String HTTP_GENERAL_DEPOSIT_LIST     = "generalDeposit/list";
    
    /*
        Obtener un depósito general de combustible específico.
    */
    @GetMapping(HTTP_GENERAL_DEPOSIT_LIST_ID)
    public WebObject nGenaralDepositListId(@PathVariable("generalDepositId") Long id);
    public static final String HTTP_GENERAL_DEPOSIT_LIST_ID  = "generalDeposit/list/{generalDepositId}";
    
    /*
        Guarda un nuevo depósito general de combustible.
    */
    @PostMapping(HTTP_GENERAL_DEPOSIT_CREATE)
    public WebObject nGeneralDepositCreate(@RequestBody WebObject o);
    public static final String HTTP_GENERAL_DEPOSIT_CREATE   = "generalDeposit/create";
    
    /*
        Edita un depósito general de combustible.
    */
    @PatchMapping(HTTP_GENERAL_DEPOSIT_UPDATE)
    public WebObject nGeneralDepositUpdate(@PathVariable("generalDepositId") Long id, @RequestBody WebObject o);
    public static final String HTTP_GENERAL_DEPOSIT_UPDATE   = "generalDeposit/update/{generalDepositId}";
    
    /*
        Borra lógicamente un depósito general de combustible.
    */
    @PatchMapping(HTTP_GENERAL_DEPOSIT_DELETE)
    public WebObject nGeneralDepositDelete(@PathVariable("generalDepositId") Long id);
    public static final String HTTP_GENERAL_DEPOSIT_DELETE   = "generalDeposit/delete/{generalDepositId}";
    
    /*
        Lista todas las alertas generadas por el microservicio.
    */
    @GetMapping(HTTP_ALERT_LIST)
    public WebObject nAlertList();
    public static final String HTTP_ALERT_LIST               = "alert/list";
    
    /*
        Obtener una alerta específica.
    */
    @GetMapping(HTTP_ALERT_LIST_ID)
    public WebObject nAlertListId(@PathVariable("alertId") Long id);
    public static final String HTTP_ALERT_LIST_ID            = "/alert/list/{alertId}";
    
    /*
        Guarda una nueva alerta.
    */
    @PostMapping(HTTP_ALERT_CREATE)
    public WebObject nAlertCreate(@RequestBody WebObject o);
    public static final String HTTP_ALERT_CREATE             = "alert/create";
    
    /*
        Edita una alerta
    */
    @PatchMapping(HTTP_ALERT_UPDATE)
    public WebObject nAlretUpdate(@PathVariable("alertId") Long id);
    public static final String HTTP_ALERT_UPDATE             = "alert/update/{alertId}";
    
    /*
        Borra lógicamente una alerta.
    */
    @PatchMapping(HTTP_ALERT_DELETE)
    public WebObject nAlertDelete(@PathVariable("alertId") Long id);
    public static final String HTTP_ALERT_DELETE             = "alert/delete/{alertId}";
}
