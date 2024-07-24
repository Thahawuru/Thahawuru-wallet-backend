package com.thahawuru_wallet.application.security;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.thahawuru_wallet.application.entity.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class ApiRequestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenHeader = request.getHeader("THAHAWURU-API-KEY");
        if(tokenHeader != null ){
            String token = tokenHeader;
            try{
                if(token.equals("123456789")){
//                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.get(),null,new ArrayList<>());
//                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    System.out.println("Equals the String");
                }

            }catch(JWTDecodeException ex){
                throw new JWTDecodeException("No valid token found");
            }

        }
    }
}

