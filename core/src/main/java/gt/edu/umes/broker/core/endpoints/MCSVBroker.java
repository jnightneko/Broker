/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.core.endpoints;

/**
 * Clase encargada de listar todo los endpoints del servicio 'Broker'
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class MCSVBroker {
    
    public static final String BK_LOGS                       = "/broker/logs";
    
    public static final String BK_USUARIO_OBTENER_POR_ID     = "/broker/usuarios/{id}";
    public static final String BK_USUARIO_CREAR              = "/broker/usuarios";
    
    public static final String BK_TOKEN_OBTENER_POR_USUARIO  = "/broker/tokens/usuario/{idU}";
    public static final String BK_TOKEN_GUARDAR              = "/broker/tokens";
    
    public static final String BK_SESION_OBTENER_POR_USUARIO = "/broker/sesiones/usuario/{idU}";
    public static final String BK_SESIONES_CREAR             = "/broker/sesiones";
    public static final String BK_SESIONES_ACTUALIZAR_ESTADO = "/broker/sesiones/{id}";
    
    public static final String BK_TOKEN_ACTIVOS_ROLES        = "/broker/tokens/activos/{rol}";
    
    /** Constructor privado */
    private MCSVBroker() {}
}
