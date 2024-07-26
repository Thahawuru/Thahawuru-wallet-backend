package com.thahawuru_wallet.application.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Order(1)
@EnableWebSecurity
public class ApiSecurityConfig {

    @Bean
    public ApiRequestFilter apiRequestFilter() {
        return new ApiRequestFilter();
    }

    @Bean
    public SecurityFilterChain apiSecurityFilterChain(HttpSecurity http, ApiRequestFilter apiRequestFilter) throws Exception {
        http
                .securityMatcher("/api/v1/qr/get/**")
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().permitAll())
                .cors(withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(withDefaults());

        // Add the ApiRequestFilter for the specific endpoint
        http.addFilterBefore(apiRequestFilter, AuthorizationFilter.class);

        return http.build();
    }
}
