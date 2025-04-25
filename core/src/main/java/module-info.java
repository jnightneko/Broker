/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
module Core {
    requires com.fasterxml.jackson.annotation;
    requires jjwt.api;
    
    exports gt.edu.umes.broker.core;
    exports gt.edu.umes.broker.core.model;
    exports gt.edu.umes.broker.core.endpoints;
    exports gt.edu.umes.broker.core.system;
}
