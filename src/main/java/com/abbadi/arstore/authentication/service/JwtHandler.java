package com.abbadi.arstore.authentication.service;

import com.abbadi.arstore.user.model.UserDto;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.function.Function;

public interface JwtHandler {

    String extractUsername(String token);

    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

    String generateToken(Map<String, Object> claims, UserDto userDto);

    String generateToken(UserDto userDto);

    boolean isTokenValid(String token, UserDetails userDetails);

    Long extractUserId(String token);
}
