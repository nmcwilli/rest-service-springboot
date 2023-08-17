package com.example.restservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF protection for TEST ONLY
                .authorizeHttpRequests(auth -> auth
                        // Example role based sec
                        // .requestMatchers("/api/v1/clients/**").hasRole("CLIENT") // Secure Client endpoints
                        // .requestMatchers("/api/v1/users/**").hasRole("USER")     // Secure User endpoints
                        // .requestMatchers("/token/**").permitAll() //
                        .anyRequest().authenticated() // Authorize all requests
                )
                .httpBasic(Customizer.withDefaults()); // Using HTTP Basic Authentication

        return http.build();
    }
}