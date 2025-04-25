/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.core;

/**
 * Clase encargada de maner un oyente de excepciones o errores.
 * 
 * @param <EX> tipo de error a lanzar
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ExceptionListener<EX extends Throwable> {
    
    /**
     * Método encargado de gestionar el error lanzada.
     * @param e excepción
     */
    void nCatch(EX e);
}
