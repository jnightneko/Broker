/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.validation.service;

import gt.edu.umes.broker.core.model.AbstractBKModel;

/**
 * Interfaz encargada de gestionar un oyente paara las validaciónes.
 * @param <T> tipo de modelo
 * @param <E> tipo del objeto
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@FunctionalInterface
public interface LogListener<T extends AbstractBKModel<E>, E extends Object>{
    
    /**
     * Genera un log dependiendo del estado de la petición.
     * 
     * @param logs servicio de logs
     * @param request petición
     * @param msg mensaje|log
     * @param err boolean
     */
    void log(LogService logs, T request, String msg, boolean err);
}
