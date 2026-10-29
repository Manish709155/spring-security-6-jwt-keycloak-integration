package com.keycloak.integration.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthConverter authConverter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){

        http
                .authorizeHttpRequests(authorize -> authorize

                        .requestMatchers("/admin/**")
                        .hasRole("ADMIN")

                        .requestMatchers("/user/**")
                        .hasRole("USER")

                        .anyRequest()
                        .authenticated()
                )

                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .jwtAuthenticationConverter(authConverter)
                        )
                );

        return http.build();
    }

}