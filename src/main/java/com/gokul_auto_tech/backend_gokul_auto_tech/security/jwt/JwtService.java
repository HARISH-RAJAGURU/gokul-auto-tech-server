package com.gokul_auto_tech.backend_gokul_auto_tech.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${application.security.jwt.secretKey}")
    private String secretKey;

    @Value("${application.security.jwt.jwtExpiration}")
    private Long expirationTime;

    public String generateToken(HashMap<String,Object> claims,UserDetails userDetails) {
        return buildToken(claims,userDetails,expirationTime);
    }

    private String buildToken(HashMap<String,Object> extraClaims,
                              UserDetails userDetails,Long expirationTime) {
        var authorities = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

        return Jwts.builder().claims(extraClaims)
                .claim("authorities", authorities)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expirationTime))
                .subject(userDetails.getUsername())
                .signWith(getSignKey())
                .compact();
    }

    public boolean isTokenValid(String token,UserDetails userDetails) {
        String userEmail = extractUserEmailFromToken(token);
        return userEmail != null &&
                Objects.equals(userDetails.getUsername(), userEmail) && extractExpirationDate(token).after(new Date(System.currentTimeMillis()));
    }

    private <T>T extractClaims(String jwtToken, Function<Claims,T>claimsTFunction) {
        final Claims claims = Jwts.parser()
                .verifyWith((SecretKey) getSignKey())
                .build()
                .parseSignedClaims(jwtToken)
                .getPayload();
        return  claimsTFunction.apply(claims);
    }

    String extractUserEmailFromToken(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    private Date extractExpirationDate(String jwtToken){
        return extractClaims(jwtToken, Claims::getExpiration);
    }

    protected Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }




}
