package com.example.zomato.securityfilters;

import com.example.zomato.enums.UserRole;
import com.example.zomato.security.JWTService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@AllArgsConstructor
public class RefreshFilter extends OncePerRequestFilter {

    private final JWTService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            String token = null;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("rt")) {
                    token = cookie.getValue();
                }
            }

            if (token != null) {
                Claims claims = jwtService.extraClaims(token);
                String username = jwtService.getUsername(claims);
                String role = jwtService.getRole(claims);
                if (username != null && role != null) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, null,
                            UserRole.valueOf(role)
                                    .getPrivileges().stream()
                                    .map(privilege -> new SimpleGrantedAuthority(privilege.name()))
                                    .toList());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
