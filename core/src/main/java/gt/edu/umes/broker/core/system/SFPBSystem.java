/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.core.system;

import gt.edu.umes.broker.core.ExceptionListener;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.util.Date;
import javax.crypto.SecretKey;

/**
 * @author wil
 */
public final class SFPBSystem {
    public static final String SECRET_KEY_TOKEN     = "e7f5a4c6d3b8e2f9a1c4d7e8f2b3c4a5d6e9f4b5c7d8a9b0c3d2e1f4a5b6c7";
    public static final Long TIME_EXPIRATION_TOKEN  = 1000L * 60L * 30L;
    
    public static final Long NULL = 0L;
    
    public static boolean isTokenExpired(String token, ExceptionListener<RuntimeException> el) {
        return extractExpiration(token, el).before(new Date());
    }
    
    public static String extractBearerToken(String raw) {
        if (raw.startsWith("Bearer ")) {
            return raw.substring(7);
        }
        return raw;
    }
    
    public static Jws<Claims> jwtGetToken(final String token, ExceptionListener<RuntimeException> el) {
        try {
            return Jwts.parser()
                    .verifyWith(jwtGetSignKey())
                    .build()
                    .parseSignedClaims(token);
        } catch (JwtException | IllegalArgumentException e) {
            el.nCatch(e);
            return null;
        }
    }
    
    public static Date extractExpiration(String token, ExceptionListener<RuntimeException> el) {
        Jws<Claims> jws = jwtGetToken(token, el);
        if (jws == null) {
            return new Date(System.currentTimeMillis() + (System.currentTimeMillis()  * 2));
        }
        
        Claims claims = jws.getPayload();
        return claims.getExpiration();
    }

    public static SecretKey jwtGetSignKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SFPBSystem.SECRET_KEY_TOKEN);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    
    public static String extractId(String token, ExceptionListener<RuntimeException> el) {
        Jws<Claims> jws = jwtGetToken(token, el);
        if (jws == null) {
            return null;
        }
        
        Claims claims = jws.getPayload();
        return claims.getId();
    }
    
    public static String extractUsername(String token, ExceptionListener<RuntimeException> el) {
        Jws<Claims> jws = jwtGetToken(token, el);
        if (jws == null) {
            return null;
        }
        
        Claims claims = jws.getPayload();
        return claims.getSubject();
    }
}
