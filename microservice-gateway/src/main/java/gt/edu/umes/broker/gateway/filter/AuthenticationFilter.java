package gt.edu.umes.broker.gateway.filter;

import gt.edu.umes.broker.gateway.util.JwtUtil;
import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {
    @Autowired
    private RouteValidator routeValidator;

    /*@Autowired
    private RestTemplate restTemplate;*/
    @Autowired
    private JwtUtil jwtUtil;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            if (routeValidator.isSecured.test(exchange.getRequest())){
                //verificar si el token esta en el encabezado
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                    throw new RuntimeException("Falta de autorizacion en el encabezado");
                }

                String authHeader = exchange.getRequest().getHeaders().get(org.springframework.http.HttpHeaders.AUTHORIZATION).get(0);
                if (authHeader != null && authHeader.startsWith("Bearer ")){
                    authHeader=authHeader.substring(7);
                }
                try {
                    //restTemplate.getForObject("http://IDENTITY-SERVICE//validate?token" + authHeader, String.class);
                    jwtUtil.validateToken(authHeader);
                }catch (Exception e){
                    System.out.println("Acceso invalido");
                    throw new RuntimeException("Acceso invalido a la aplicacion");
                }
            }

            return chain.filter(exchange);
        });
    }

    public static class Config{

    }
}
