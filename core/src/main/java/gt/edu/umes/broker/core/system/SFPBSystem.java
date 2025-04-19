/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.core.system;

/**
 *
 * @author wil
 */
public final class SFPBSystem {
    public static final String SECRET_KEY_TOKEN     = "e7f5a4c6d3b8e2f9a1c4d7e8f2b3c4a5d6e9f4b5c7d8a9b0c3d2e1f4a5b6c7";
    public static final Long TIME_EXPIRATION_TOKEN  = 1000L * 60L * 30L;
    
    public static boolean bkIsInternalService(String address, int port) {
        return true;
    }
}
