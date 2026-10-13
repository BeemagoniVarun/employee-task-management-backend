package com.varun.employee_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
                // Disable CSRF because we are currently testing REST APIs
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth

                        // Login API
                        .requestMatchers("/api/auth/**").permitAll()

                        // Temporarily allow existing APIs
                        .requestMatchers("/api/users/**").permitAll()
                        .requestMatchers("/api/projects/**").permitAll()
                        .requestMatchers("/api/tasks/**").permitAll()
                        .requestMatchers("/api/comments/**").permitAll()

                        // Any other request needs authentication
                        .anyRequest().authenticated()
                )

                // Disable default Spring Security login page
                .formLogin(form -> form.disable())

                // Disable HTTP Basic authentication for now
                .httpBasic(basic -> basic.disable());

        return http.build();
    }
}