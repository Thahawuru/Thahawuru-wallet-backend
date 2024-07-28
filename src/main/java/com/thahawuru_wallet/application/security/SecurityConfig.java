package com.thahawuru_wallet.application.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    JWTRequestFilter jwtRequestFilter;

    @Autowired
    ApiRequestFilter apiRequestFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/v1/auth/**","/api/v1/qr/get/**","/api/v1/identities/**","/api/v1/licenses/**").permitAll()
                        .requestMatchers("/api/v1/admin/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/maintainer/**").hasAnyRole("MAINTAINER","ADMIN")
                        .requestMatchers("/api/v1/users/**").hasAnyRole("ADMIN","MAINTAINER","USER")
                        .requestMatchers("/api/v1/apiuser/**","/api/v1/apikey/**").hasAnyRole("APIUSER","ADMIN","MAINTAINER")
                        .anyRequest().authenticated())
                .cors(withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(withDefaults());
        http.addFilterBefore(jwtRequestFilter, AuthorizationFilter.class);
        return http.build();
    }

@Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:8081","http://localhost:8082","http://localhost:6000","http://localhost:3000","http://localhost:3010"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
