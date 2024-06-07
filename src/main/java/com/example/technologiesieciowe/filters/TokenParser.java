package com.example.technologiesieciowe.filters;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TokenParser {
    @Value("${jwt.token.key}")
    private String tokenKey;

    public int getUserId(String token) {
        token = token.replace("Bearer ", "");
        Claims claims = Jwts.parser()
                .setSigningKey(tokenKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return Integer.parseInt(String.valueOf(claims.get("id")));
    }
}
