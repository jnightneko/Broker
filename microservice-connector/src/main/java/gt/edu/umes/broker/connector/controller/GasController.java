/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.controller;

import gt.edu.umes.broker.connector.http.WebObject;
import static gt.edu.umes.broker.connector.client.GasClient.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import gt.edu.umes.broker.connector.client.GasClient;

/**
 * Clase encargado de gestionar el redireccionamiento de las peticiones a las direcciones correctas.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/broker/__connection__/")
public class GasController {
    @Autowired
    private GasClient client;
    /*
        Obtener todas las gasolinas 
    */
    @PostMapping(HTTP_BOMB_LIST)
    public WebObject getBomBList() {
        return client.nBomBList();
    }
    
    /*
        Obtener solo las bombas que se encuentran en estado activo
    */
    @PostMapping(HTTP_BOMB_LIST_ACTIVE)
    public WebObject getBomBListActive() {
        return client.nBomBListActive();
    }
    
    /*
        Obtener solo las bombas que se encuentran en estado inactivo
    */
    @PostMapping(HTTP_BOMB_LIST_INACTIVE)
    public WebObject getBombListInactive() {
        return client.nBombListInactive();
    }
    
    /*
        Obtener solo las bombas que se encuentran en estado de mantenimiento
    */
    @PostMapping(HTTP_BOMB_LIST_MAINTEANCE)
    public WebObject getBombListMainteance() {
        return client.nBombListMainteance();
    }
    
    /*
        Devuelve una bomba en específico en base al id
    */
    @PostMapping(HTTP_BOMB_LIST_BOMBID)
    public WebObject getBombListBombId(@PathVariable("bombId") Long id) {
        return client.nBombListBombId(id);
    }
    
    /*
        Crear una bomba de servicio de gasolina
    */
    @PostMapping(HTTP_BOMB_CREATE)
    public WebObject getBombCreate(@RequestBody WebObject o) {
        return client.nBombCreate(o);
    }
    
    /*
        Actualizar una bomba de gasolina
    */
    @PostMapping(HTTP_BOMB_UPDATE)
    public WebObject getBombUpdate(@PathVariable("bombId") Long id,@RequestBody WebObject o) {
        return client.nBombUpdate(id, o);
    }
    
    /*
        Eliminar una bomba de gasolina
    */
    @PostMapping(HTTP_BOMB_DELETE)
    public WebObject getBombDelete(@PathVariable("bombId") Long id) {
        return client.nBombDelete(id);
    }
    
    /*
        Obtener todos los tipos de gasolina
    */
    @PostMapping(HTTP_FUEL_TYPE_LIST)
    public WebObject getFuelTypeList() {
        return client.nFuelTypeList();
    }
    
    /*
        Devuelve un tipo de gasolina específico
    */
    @PostMapping(HTTP_FUEL_TYPE_LIST_ID)
    public WebObject getFuelTypeListId(@PathVariable("fuelId") Long id) {
        return client.nFuelTypeListId(id);
    }
    
    /*
        Crear un tipo de gasolina
    */
    @PostMapping(HTTP_FUEL_TYPE_CREATE)
    public WebObject getFuelTypeCreate(@RequestBody WebObject o) {
        return client.nFuelTypeCreate(o);
    }
    
    /*
        Actualizar un tipo de gasolina
    */
    @PostMapping(HTTP_FUEL_TYPE_UPDATE)
    public WebObject getFuelTypeUpdate(@PathVariable("fuelId") Long id, @RequestBody WebObject o) {
        return client.nFuelTypeUpdate(id, o);
    }
    
    /*
        Eliminar un tipo de gasolina
    */
    @PostMapping(HTTP_FUEL_TYPE_DELETE)
    public WebObject getFuelTypeDelete(@PathVariable("fuelId") Long id) {
        return client.nFuelTypeDelete(id);
    }
    
    /*
        Lista todas las ventas de combustible
    */
    @PostMapping(HTTP_SALE_LIST)
    public WebObject getSaleList() {
        return client.nSaleList();
    }
    
    /*
        Devuelve una venta de combustible específica
    */
    @PostMapping(HTTP_SALE_LIST_FUEL_SALE_ID)
    public WebObject getSaleListFuelSaleId(@PathVariable("fuelSaleId") Long id) {
        return client.nSaleListFuelSaleId(id);
    }
    
    /*
        Realiza una venta de combustible
    */
    @PostMapping(HTTP_SALE_CREATE)
    public WebObject getSaleCreate(@RequestBody WebObject o) {
        return client.nSaleCreate(o);
    }
    
    /*
        Edita una venta de combustible
    */
    @PostMapping(HTTP_SALE_UPDATE)
    public WebObject getSaleUpdate(@PathVariable("fuelSaleId") Long id, @RequestBody WebObject o) {
        return client.nSaleUpdate(id, o);
    }
    
    /*
        Borra lógicamente una venta de combustible
    */
    @PostMapping(HTTP_SALE_DELETE)
    public WebObject getSaleDelerte(@PathVariable("fuelSaleId") Long id) {
        return client.nSaleDelerte(id);
    }
    
    /*
        Lista todos los depósitos generales de combustible.
    */
    @PostMapping(HTTP_GENERAL_DEPOSIT_LIST)
    public WebObject getGeneralDepositList() {
        return client.nGeneralDepositList();
    }
    
    /*
        Obtener un depósito general de combustible específico.
    */
    @PostMapping(HTTP_GENERAL_DEPOSIT_LIST_ID)
    public WebObject getGenaralDepositListId(@PathVariable("generalDepositId") Long id) {
        return client.nGenaralDepositListId(id);
    }
    
    /*
        Guarda un nuevo depósito general de combustible.
    */
    @PostMapping(HTTP_GENERAL_DEPOSIT_CREATE)
    public WebObject getGeneralDepositCreate(@RequestBody WebObject o) {
        return client.nGeneralDepositCreate(o);
    }
    
    /*
        Edita un depósito general de combustible.
    */
    @PostMapping(HTTP_GENERAL_DEPOSIT_UPDATE)
    public WebObject getGeneralDepositUpdate(@PathVariable("generalDepositId") Long id, @RequestBody WebObject o) {
        return client.nGeneralDepositUpdate(id, o);
    }
    
    /*
        Borra lógicamente un depósito general de combustible.
    */
    @PostMapping(HTTP_GENERAL_DEPOSIT_DELETE)
    public WebObject getGeneralDepositDelete(@PathVariable("generalDepositId") Long id) {
        return client.nGeneralDepositDelete(id);
    }
    
    /*
        Lista todas las alertas generadas por el microservicio.
    */
    @PostMapping(HTTP_ALERT_LIST)
    public WebObject getAlertList() {
        return client.nAlertList();
    }
    
    /*
        Obtener una alerta específica.
    */
    @PostMapping(HTTP_ALERT_LIST_ID)
    public WebObject getAlertListId(@PathVariable("alertId") Long id) {
        return client.nAlertListId(id);
    }
    
    /*
        Guarda una nueva alerta.
    */
    @PostMapping(HTTP_ALERT_CREATE)
    public WebObject getAlertCreate(@RequestBody WebObject o) {
        return client.nAlertCreate(o);
    }
    
    /*
        Edita una alerta
    */
    @PostMapping(HTTP_ALERT_UPDATE)
    public WebObject getAlretUpdate(@PathVariable("alertId") Long id) {
        return client.nAlretUpdate(id);
    }
    
    /*
        Borra lógicamente una alerta.
    */
    @PostMapping(HTTP_ALERT_DELETE)
    public WebObject getAlertDelete(@PathVariable("alertId") Long id) {
        return client.nAlertDelete(id);
    }
}
