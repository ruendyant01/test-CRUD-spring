package org.vascoom.vascoomspring.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.vascoom.vascoomspring.entities.Users;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {


    private final String SECRET = "vascoom";

    public String generateToken(Users users) {
        String token = Jwts.builder().setSubject(users.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(getSigninKey()).compact();

        return token;
    }

    public SecretKey getSigninKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.
                parserBuilder().setSigningKey(getSigninKey()).build().parseClaimsJws(token).getBody();
    }

    public <T> T extractClaim(String token, Function<Claims,T> claimType) {
        Claims claims = extractAllClaims(token);
        return claimType.apply(claims);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public boolean isValid(String token , UserDetails users) {
        return (extractUsername(token).equals(users.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token ) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
