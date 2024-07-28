package com.thahawuru_wallet.application.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.thahawuru_wallet.application.entity.ApiUser;
import com.thahawuru_wallet.application.entity.Roles;
import com.thahawuru_wallet.application.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.UUID;

@Service
public class JWTService {

    @Value("${jwt.algorithm.key}")
    private String algorithmKey;
    @Value("${jwt.issuer}")
    private String issuer;
    @Value("${jwt.expiaryinseconds}")
    private int expiaryinseconds;
    private Algorithm algorithm;

    private JWTVerifier verifier;

    private static final String USERNAME_KEY ="USERID";

    @PostConstruct
    public void postConstruct() throws UnsupportedEncodingException {
        this.algorithm= Algorithm.HMAC256(algorithmKey);
        this.verifier=  JWT.require(algorithm).withIssuer(issuer).build();
    }


    public String generateJWT(User user, Roles userType){
        return JWT.create()
                .withSubject(userType.toString())
                .withClaim(USERNAME_KEY,user.getId().toString())
                .withIssuer(issuer)
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*expiaryinseconds))
                .sign(algorithm);
    }
    public String generateJWTForApiUser(ApiUser user, String userType){
        return JWT.create()
                .withSubject(userType)
                .withClaim(USERNAME_KEY,user.getId().toString())
                .withIssuer(issuer)
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*expiaryinseconds))
                .sign(algorithm);
    }


    public UUID getUserId(String token){
        try {
            DecodedJWT jwt = verifier.verify(token);
            String userId = jwt.getClaim(USERNAME_KEY).asString();
            return UUID.fromString(userId);
        } catch (JWTDecodeException e) {
            throw new JWTDecodeException("Invalid token");
        }
    }

    public String getUserType(String token) {
        try {
            DecodedJWT jwt =verifier.verify(token);
            return jwt.getSubject();
        } catch (JWTDecodeException e) {
            throw new JWTDecodeException("Invalid token");
        }
    }



}
