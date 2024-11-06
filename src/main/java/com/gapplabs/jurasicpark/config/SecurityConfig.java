package com.gapplabs.jurasicpark.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Bean
    SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) {
        // Configura la autorizacion para que todas las solicitudes requieran autenticacion.
        http
                .authorizeExchange((authorize) -> authorize
                        .anyExchange().authenticated()
                )
                .formLogin(withDefaults()); // Usa login por formulario
        // @formatter:on
        return http.build();
    }

    @Bean
    MapReactiveUserDetailsService userDetailsService() {
        // Crea un usuario en memoria para pruebas.
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new MapReactiveUserDetailsService(user);
    }
}
