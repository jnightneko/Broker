package gt.edu.umes.broker.gateway.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtUtil {
    public static final String SECRET = "e7f5a4c6d3b8e2f9a1c4d7e8f2b3c4a5d6e9f4b5c7d8a9b0c3d2e1f4a5b6c7";

    public Jws<Claims> validateToken(final String token){
        return Jwts.parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token);
    }

    public SecretKey getSignKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
