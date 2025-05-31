package gt.edu.umes.broker.gateway.filter;

import gt.edu.umes.broker.gateway.util.JwtUtil;
import static gt.edu.umes.broker.core.Microservice.*;

import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {
    @Autowired
    private RouteValidator routeValidator;

    @Autowired
    private JwtUtil jwtUtil;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            InetSocketAddress clienAddress = exchange.getRequest()
                                                     .getRemoteAddress();
            
            if (routeValidator.isSecured.test(exchange.getRequest()) 
                    && !bkAllowAddress(clienAddress)) {                
                try {
                    //verificar si el token esta en el encabezado
                    if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                        throw new RuntimeException("Falta de autorizacion en el encabezado");
                    }
                    
                    String authHeader = exchange.getRequest().getHeaders().get(org.springframework.http.HttpHeaders.AUTHORIZATION).get(0);
                    if (authHeader != null && authHeader.startsWith("Bearer ")){
                        authHeader=authHeader.substring(7);
                    }

                    //restTemplate.getForObject("http://IDENTITY-SERVICE//validate?token" + authHeader, String.class);
                    if (!jwtUtil.isTokenValid(authHeader)) {
                        throw new RuntimeException("Acceso invalido a la aplicacion");
                    }
                } catch (RuntimeException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }

            return chain.filter(exchange);
        });
    }

    public static class Config{

    }
}