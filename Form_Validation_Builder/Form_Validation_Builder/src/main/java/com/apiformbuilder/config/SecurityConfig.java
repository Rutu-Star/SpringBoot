package com.apiformbuilder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF to avoid 403 error for POST requests
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/submit-form").authenticated() // Secure POST endpoint
                .requestMatchers("/api/hello").authenticated() // Secure GET endpoint
                .anyRequest().permitAll()
            )
            .httpBasic(); // Enable Basic Authentication

        return http.build();
    }
}
