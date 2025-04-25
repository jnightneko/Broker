package gt.edu.umes.broker.identity.service;

import gt.edu.umes.broker.core.system.SFPBSystem;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class JwtService {

    public String generateToken(String id){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, id);
    }

    public String createToken(Map<String, Object> claims, String userId){
        return Jwts.builder()
                .claims(claims)
                .subject(userId)
                .id(UUID.randomUUID().toString())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + SFPBSystem.TIME_EXPIRATION_TOKEN))
                .signWith(SFPBSystem.jwtGetSignKey()).compact();
    }
}
