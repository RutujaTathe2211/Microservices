package ApIGateway.ApiGateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    //to config okta security
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity){
        httpSecurity.
                //for any authorization
                authorizeExchange()
                .anyExchange()
                .authenticated()
                .and()
                .oauth2Client()//for login
                .and()
                .oauth2ResourceServer()//config oauthresource server
                .jwt();

        return httpSecurity.build();


    }
}
