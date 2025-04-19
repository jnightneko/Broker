package gt.edu.umes.broker.identity.service;

import gt.edu.umes.broker.core.system.SFPBSystem;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtService {
    
    public Jws<Claims> validateToken(final String token){
        return Jwts.parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token);
    }

    public String generateToken(String userName, Long id){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userName, id);
    }

    public String createToken(Map<String, Object> claims, String userName, Long id){
        return Jwts.builder()
                .claims(claims)
                .subject(userName)
                .id(String.valueOf(id))
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + SFPBSystem.TIME_EXPIRATION_TOKEN))
                .signWith(getSignKey()).compact();
    }

    public SecretKey getSignKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SFPBSystem.SECRET_KEY_TOKEN);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
