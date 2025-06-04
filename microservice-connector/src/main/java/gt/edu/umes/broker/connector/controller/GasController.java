/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.connector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import gt.edu.umes.broker.connector.client.GasClient;
import static  gt.edu.umes.broker.core.endpoints.MCSVGas.*;

/**
 * Clase encargado de gestionar el redireccionamiento de las peticiones a las 
 * direcciones correctas.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/broker/__connection__/")
public final class GasController {
    @Autowired
    private GasClient client;
    /* (non-Javadoc) */
    @PostMapping(HTTP_BOMB_LIST)
    public Object getBomBList() {
        return client.nBomBList();
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_BOMB_LIST_ACTIVE)
    public Object getBomBListActive() {
        return client.nBomBListActive();
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_BOMB_LIST_INACTIVE)
    public Object getBombListInactive() {
        return client.nBombListInactive();
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_BOMB_LIST_MAINTEANCE)
    public Object getBombListMainteance() {
        return client.nBombListMainteance();
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_BOMB_LIST_BOMBID)
    public Object getBombListBombId(@PathVariable("bombId") Object bombId) {
        return client.nBombListBombId(bombId);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_BOMB_LIST_EMPLOYEE_EMPLOYEEID)
    public Object getBombListBombId(@PathVariable("employeeId") Object employeeId) {
        return client.nBombListBombId(employeeId);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_BOMB_CREATE)
    public Object getBombCreate(@RequestBody Object o) {
        return client.nBombCreate(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_BOMB_UPDATE)
    public Object getBombUpdate(@PathVariable("bombId") Object bombId,@RequestBody Object o) {
        return client.nBombUpdate(bombId, o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_BOMB_DELETE)
    public Object getBombDelete(@PathVariable("bombId") Object bombId) {
        return client.nBombDelete(bombId);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_FUEL_TYPE_LIST)
    public Object getFuelTypeList() {
        return client.nFuelTypeList();
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_FUEL_TYPE_LIST_ID)
    public Object getFuelTypeListId(@PathVariable("fuelId") Object fuelId) {
        return client.nFuelTypeListId(fuelId);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_FUEL_TYPE_CREATE)
    public Object getFuelTypeCreate(@RequestBody Object o) {
        return client.nFuelTypeCreate(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_FUEL_TYPE_UPDATE)
    public Object getFuelTypeUpdate(@PathVariable("fuelId") Object fuelId, @RequestBody Object o) {
        return client.nFuelTypeUpdate(fuelId, o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_FUEL_TYPE_DELETE)
    public Object getFuelTypeDelete(@PathVariable("fuelId") Object fuelId) {
        return client.nFuelTypeDelete(fuelId);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_SALE_LIST)
    public Object getSaleList() {
        return client.nSaleList();
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_SALE_LIST_FUEL_SALE_ID)
    public Object getSaleListFuelSaleId(@PathVariable("fuelSaleId") Object fuelSaleId) {
        return client.nSaleListFuelSaleId(fuelSaleId);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_SALE_CREATE)
    public Object getSaleCreate(@RequestBody Object o) {
        return client.nSaleCreate(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_SALE_UPDATE)
    public Object getSaleUpdate(@PathVariable("fuelSaleId") Object fuelSaleId, @RequestBody Object o) {
        return client.nSaleUpdate(fuelSaleId, o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_SALE_DELETE)
    public Object getSaleDelerte(@PathVariable("fuelSaleId") Object fuelSaleId) {
        return client.nSaleDelerte(fuelSaleId);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_GENERAL_DEPOSIT_LIST)
    public Object getGeneralDepositList() {
        return client.nGeneralDepositList();
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_GENERAL_DEPOSIT_LIST_ID)
    public Object getGenaralDepositListId(@PathVariable("generalDepositId") Object generalDepositId) {
        return client.nGenaralDepositListId(generalDepositId);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_GENERAL_DEPOSIT_CREATE)
    public Object getGeneralDepositCreate(@RequestBody Object o) {
        return client.nGeneralDepositCreate(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_GENERAL_DEPOSIT_UPDATE)
    public Object getGeneralDepositUpdate(@PathVariable("generalDepositId") Object generalDepositId, @RequestBody Object o) {
        return client.nGeneralDepositUpdate(generalDepositId, o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_GENERAL_DEPOSIT_DELETE)
    public Object getGeneralDepositDelete(@PathVariable("generalDepositId") Object generalDepositId) {
        return client.nGeneralDepositDelete(generalDepositId);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ALERT_LIST)
    public Object getAlertList() {
        return client.nAlertList();
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ALERT_LIST_ID)
    public Object getAlertListId(@PathVariable("alertId") Object alertId) {
        return client.nAlertListId(alertId);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ALERT_CREATE)
    public Object getAlertCreate(@RequestBody Object o) {
        return client.nAlertCreate(o);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ALERT_UPDATE)
    public Object getAlretUpdate(@PathVariable("alertId") Object alertId) {
        return client.nAlretUpdate(alertId);
    }
    /* (non-Javadoc) */
    @PostMapping(HTTP_ALERT_DELETE)
    public Object getAlertDelete(@PathVariable("alertId") Object alertId) {
        return client.nAlertDelete(alertId);
    }
}
