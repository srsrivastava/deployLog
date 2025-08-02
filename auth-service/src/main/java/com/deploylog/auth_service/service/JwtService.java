package com.deploylog.auth_service.service;

import com.deploylog.auth_service.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class JwtService {
        private static final String SECRET = "your-256-bit-secret-your-256-bit-secret"; // must be 256-bit (32 chars for HS256)
        private static final SecretKey KEY = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

        public String generateToken(String subject) {
            return Jwts.builder()
                    .setSubject(subject)
                    .setIssuedAt(new Date())
                    .setExpiration(Date.from(Instant.now().plus(1, ChronoUnit.DAYS)))
                    .signWith(KEY, SignatureAlgorithm.HS256)
                    .compact();
        }

    // You’ll add methods like generateToken(), extractUsername(), isTokenValid() next
}

