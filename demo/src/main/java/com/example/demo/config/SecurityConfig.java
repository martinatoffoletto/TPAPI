package com.example.demo.config;

import java.util.Base64;

import javax.crypto.SecretKey;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                        (authz) -> authz.anyRequest().authenticated())
                .addFilterBefore(jwtAuth(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    //puedo acceder a estos sin autorización
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("TPApi/templates/index", "auth/login", "registroAdmin", "registroDueInqui");
    }


    @Bean
    public JwtAuthFilter jwtAuth() {
        return new JwtAuthFilter(secretKey());
    }

    @Bean
    public SecretKey secretKey() {
        return Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }
}
