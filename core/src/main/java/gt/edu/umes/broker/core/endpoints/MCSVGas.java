/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.core.endpoints;

/**
 * Clase encargada de listar todo los endpoints del servicio externo 'Gasolina'.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class MCSVGas {
    //******************************************************************************************************************
    //**    RUTA DE ELNLACES
    public static final String HTTP_BOMB_LIST                = "bomb/list";
    public static final String HTTP_BOMB_LIST                = "bomb/list/employee/{employeeId}";
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
    /** Constructor privadoo. */
    private MCSVGas() {}
}
