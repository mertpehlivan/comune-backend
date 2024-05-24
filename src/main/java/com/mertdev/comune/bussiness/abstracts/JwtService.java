package com.mertdev.comune.bussiness.abstracts;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface JwtService {
    public String extractUserName(String token);
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver);
    public List<String> extractRoles(String token);

    public String generateToken(UserDetails userDetails);
    public String generateToken(Map<String,Object> extraClaims, UserDetails userDetails);
    public boolean isTokenValid(String token,UserDetails userDetails);
}
