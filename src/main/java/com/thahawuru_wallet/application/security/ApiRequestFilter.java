package com.thahawuru_wallet.application.security;

import com.thahawuru_wallet.application.exception.RequestForbiddenException;
import com.thahawuru_wallet.application.service.ApiKeyService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.UnavailableException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.io.IOException;
import java.net.http.HttpTimeoutException;

public class ApiRequestFilter extends OncePerRequestFilter {

    @Autowired
    private ApiKeyService apiKeyService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenHeader = request.getHeader("THAHAWURU-API-KEY");
        if (tokenHeader != null) {
            String token = tokenHeader;
            try {
                if (!apiKeyService.isValidAPIKey(token)) {
                    System.out.println("wrong key");
                    throw new RequestForbiddenException("Request cant be completed!");
                }

            } catch (Exception ex) {
                throw new RequestForbiddenException("No valid token found");
            }
        }
        filterChain.doFilter(request, response);
    }
}
