package gt.edu.umes.broker.identity.service;

import gt.edu.umes.broker.core.ExceptionListener;
import gt.edu.umes.broker.core.model.JsonArrayX;
import gt.edu.umes.broker.core.model.JsonObjectX;
import gt.edu.umes.broker.core.system.SFPBSystem;
import gt.edu.umes.broker.identity.client.ClientLogs;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class JwtService {

    @Autowired
    private ClientLogs clientLogs;

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

    public String extractUsername(String token){
        return Jwts.parser()
                .verifyWith(SFPBSystem.jwtGetSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public String extractUserId(String token){
        return Jwts.parser()
                .verifyWith(SFPBSystem.jwtGetSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean isTokenExpired(String token){
        Date expiration = Jwts.parser()
                .verifyWith(SFPBSystem.jwtGetSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration();

        return expiration.before(new Date());
    }

    public boolean isValid(String token, UserDetails userDetails){
        try {
            String username = extractUsername(token);

            String userId = extractUserId(token);

            Object tokenResponse = clientLogs.obtenerTokenPorUsuario(userId);

            List<Map<String, Object>> userTokens = convertResponseToMapList(tokenResponse);

            boolean validToken = userTokens.stream()
                    .filter(t -> token.equals(t.get("token")))
                    .findFirst()
                    .map(t -> !(Boolean.TRUE.equals(t.get("loggedOut"))))
                    .orElse(false);
            return username.equals(userDetails.getUsername())
                    && !isTokenExpired(token)
                    && validToken;
        } catch (Exception e){
            return false;
        }
    }

    private List<Map<String, Object>> convertResponseToMapList(Object response){
        if(response instanceof List){
            return ((List<?>) response).stream()
                    .filter(item -> item instanceof  Map)
                    .map(item -> (Map<String, Object>) item)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
