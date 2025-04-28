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
    
    public static class JwtToken {
        private final String toke;
        private final Date issuedAt;
        private final Date expirarion;

        public JwtToken(String toke, Date issuedAt, Date expirarion) {
            this.toke = toke;
            this.issuedAt = issuedAt;
            this.expirarion = expirarion;
        }

        public String getToke() {
            return toke;
        }

        public Date getIssuedAt() {
            return issuedAt;
        }

        public Date getExpirarion() {
            return expirarion;
        }
    }

    public JwtToken generateToken(String id){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, id);
    }

    public JwtToken createToken(Map<String, Object> claims, String userId) {
        Date issAt = new Date(System.currentTimeMillis());
        Date exp = new Date(System.currentTimeMillis() + SFPBSystem.TIME_EXPIRATION_TOKEN);

        return new JwtToken(
                Jwts.builder()
                        .claims(claims)
                        .subject(userId)
                        .id(UUID.randomUUID().toString())
                        .issuedAt(issAt)
                        .expiration(exp)
                        .signWith(SFPBSystem.jwtGetSignKey()).compact(),
                issAt,
                exp
        );
    }
}
