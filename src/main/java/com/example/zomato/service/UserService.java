package com.example.zomato.service;

import com.example.zomato.entity.Customer;
import com.example.zomato.entity.RestaurantOwner;
import com.example.zomato.entity.User;
import com.example.zomato.enums.UserRole;
import com.example.zomato.mapping.UserMapper;
import com.example.zomato.repository.UserRepository;
import com.example.zomato.requestdtos.LoginRequest;
import com.example.zomato.requestdtos.UserRequest;
import com.example.zomato.responsedtos.AuthResponse;
import com.example.zomato.responsedtos.UserResponse;
import com.example.zomato.security.AuthUtil;
import com.example.zomato.security.JWTService;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;


@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final AuthUtil authUtil;

    public UserResponse addUser(UserRequest userRequest) {
        User user = null;
        switch (userRequest.getRole()) {
            case RESTAURANT_OWNER -> user = new RestaurantOwner();
            case CUSTOMER -> user = new Customer();
        }
        if (user != null) {
            userMapper.mapToUser(userRequest, user);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }
        return userMapper.mapToUserResponse(user);
    }

    public AuthResponse login(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        if (authentication.isAuthenticated()) {
            User user = userRepository.findByEmail(loginRequest.getEmail())
                    .orElseThrow(() -> new UsernameNotFoundException("Failed to find user"));
            AuthResponse authResponse = new AuthResponse();
            authResponse.setUserId(user.getUserId());
            authResponse.setUsername(user.getEmail());
            authResponse.setRole(user.getRole());
            authResponse.setAccessExpiration(Duration.ofSeconds(5 * 60));
            authResponse.setRefreshExpiration(Duration.ofSeconds(15 * 24 * 60 * 60));
            return authResponse;
        } else
            throw new UsernameNotFoundException("Failed to login");
    }

    public HttpHeaders grantCredentials(AuthResponse authResponse) {
        String accessToken = jwtService.generateJWT(authResponse.getUsername(),
                authResponse.getAccessExpiration().getSeconds() * 1000L,
                authResponse.getRole().name());

        String refreshToken = jwtService.generateJWT(authResponse.getUsername(),
                authResponse.getRefreshExpiration().getSeconds() * 1000L,
                authResponse.getRole().name());

        HttpHeaders header = new HttpHeaders();

        header.add(HttpHeaders.SET_COOKIE, this.configureTokenCookie("at", accessToken, authResponse.getAccessExpiration().getSeconds()));
        header.add(HttpHeaders.SET_COOKIE, this.configureTokenCookie("rt", refreshToken, authResponse.getRefreshExpiration().getSeconds()));

        return header;
    }

    public String configureTokenCookie(String name, String value, Long maxAge) {
        return ResponseCookie.from(name, value)
                .domain("localhost")
                .path("/")
                .maxAge(maxAge)
                .httpOnly(true)
                .secure(false)
                .sameSite("Lax")
                .build()
                .toString();
    }

    public AuthResponse refreshLogin(String refreshToken) {
        User user = authUtil.getCurrentUser();
        String username = user.getEmail();
        UserRole role = user.getRole();
        String userId = user.getUserId();
        AuthResponse authResponse = new AuthResponse();
        authResponse.setUsername(username);
        authResponse.setUserId(userId);
        authResponse.setRole(role);
        return authResponse;
    }

    public HttpHeaders logout() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(httpHeaders.SET_COOKIE,
                this.configureTokenCookie("at", "", 0L));
        httpHeaders.add(httpHeaders.SET_COOKIE,
                this.configureTokenCookie("rt", "", 0L));
        return httpHeaders;
    }
}
