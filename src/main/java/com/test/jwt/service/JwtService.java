package com.test.jwt.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class JwtService {

    @Value("${jwt.key}")
    private String SECRET;

    public Boolean validateToken(String token, UserDetails userDetails) {
        String username = extractClaims(token).getSubject();
        Date expirationDate = extractClaims(token).getExpiration();

        return userDetails.getUsername().equals(username) && expirationDate.after(new Date());
    }

    public Claims extractClaims(String token) {
        return Jwts
                .parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}
