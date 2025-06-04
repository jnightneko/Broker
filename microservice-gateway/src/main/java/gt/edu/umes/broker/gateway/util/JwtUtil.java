package gt.edu.umes.broker.gateway.util;

import gt.edu.umes.broker.core.system.SFPBSystem;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtUtil {
    
    public boolean isTokenValid(String token) throws JwtException, IllegalArgumentException {
        /* verificacion hacia administracion. */
        String username = extractUsername(token);
        Long iduser     = extractId(token);
        
        System.out.println("login: " + username + '@' + iduser);
        /* ------------------------------------*/
        if (isTokenExpired(token)) {
            return false;
        }
        return true;
    }
    
    private boolean isTokenExpired(String token) throws JwtException, IllegalArgumentException {
        return extractExpiration(token).before(new Date());
    }
    
    private Jws<Claims> validateToken(final String token) throws JwtException, IllegalArgumentException {
        return Jwts.parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token);

    }

    public SecretKey getSignKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SFPBSystem.SECRET_KEY_TOKEN);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    
    public Date extractExpiration(String token) throws JwtException, IllegalArgumentException {
        Claims claims = validateToken(token).getPayload();
        return claims.getExpiration();
    }
    
    public Long extractId(String token) throws JwtException, IllegalArgumentException {
        Claims claims = validateToken(token).getPayload();
        try {
            return Long.valueOf(claims.getId());
        } catch (NumberFormatException e) {
            return 0L;
        }
    }
    
    public String extractUsername(String token) {
        Claims claims = validateToken(token).getPayload();
        return claims.getSubject();
    }
}
