package com.golden.src.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Désactive la protection CSRF (nécessaire pour H2)
            .csrf().disable()
            // Autorisations spécifiques à H2
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console/**").permitAll() // Autoriser tout ce qui concerne H2
                .anyRequest().denyAll() // Bloquer toutes les autres requêtes
            )
            // Autoriser les frames pour H2
            .headers(headers -> headers.frameOptions().disable());

        return http.build();
    }
}
