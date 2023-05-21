package com.abbadi.arstore.authentication.filter;

import com.abbadi.arstore.authentication.config.Security;
import com.abbadi.arstore.authentication.service.JwtHandler;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtHandler jwtHandler;

    private final UserDetailsService userDetailsService;

    private final Security security;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
                                    @NonNull FilterChain chain) throws IOException, ServletException {
        final String header = request.getHeader(security.getJwtTokenHeaderName());
        final String jwt;
        final String username;
        if (header == null || !header.startsWith(security.getJwtTokenHeaderPrefix())) {
            chain.doFilter(request, response);
            return;
        }

        jwt = header.substring(security.getJwtTokenHeaderPrefix().length());
        username = jwtHandler.extractUsername(jwt);
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);// TODO: replace with username from token
            if (jwtHandler.isTokenValid(jwt, userDetails)) {
                AbstractAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authenticationToken.setDetails(
                        jwtHandler.extractUserId(jwt)
                );
                SecurityContextHolder.getContext()
                        .setAuthentication(authenticationToken);
            }
            chain.doFilter(request, response);
        }
    }
}
