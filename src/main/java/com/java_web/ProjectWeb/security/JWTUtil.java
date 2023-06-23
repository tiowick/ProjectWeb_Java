package com.java_web.ProjectWeb.security;

import java.sql.Date;
import java.util.Objects;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {
    
    @Value("$(jwt.secret)")
    private String secret;

    @Value("$(jwt.expiration)")
    private Long expiration;

    public String generateToken(String username) {
        SecretKey key = getKeyBySecret();
        return Jwts.builder()
            .setSubject(username)
            .setExpiration(new Date(System.currentTimeMillis() + this.expiration)) //Long
            .signWith(key)
            .compact();
    }

    public boolean isValidToken(String token) {
    Claims claims = getClaims(token);
    if (Objects.nonNull(claims)) {
        String username = claims.getSubject();
        Instant expirationInstant = claims.getExpiration().toInstant();
        Instant now = Instant.now();
        if (Objects.nonNull(username) && Objects.nonNull(expirationInstant) && now.isBefore(expirationInstant))
            return true;
        }
        return false;

    }
    
    /* 
    public boolean isValidToken(String token) {
        Claims claims = getClaims(token);
        if (Objects.nonNull(claims)) {
            String username = claims.getSubject();
            Date expirationDate = claims.getExpiration();
            Date now = new Date(System.currentTimeMillis());
            if (Objects.nonNull(username) && Objects.nonNull(expirationDate) && now.before(expirationDate))
                return true;
        }
        return false;
    }
    */

     private Claims getClaims(String token) {
        SecretKey key = getKeyBySecret();
        try {
            return Jwts.parserBuilder()
            .setSigningKey(key).build()
            .parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return null;
        }
    }

    private SecretKey getKeyBySecret() {
        SecretKey key = Keys.hmacShaKeyFor(this.secret.getBytes());
        return key;
    }


}
