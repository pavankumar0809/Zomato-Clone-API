package com.example.zomato.controller;

import com.example.zomato.requestdtos.LoginRequest;
import com.example.zomato.requestdtos.UserRequest;
import com.example.zomato.responsedtos.AuthResponse;
import com.example.zomato.responsedtos.UserResponse;
import com.example.zomato.security.JWTService;
import com.example.zomato.service.UserService;
import com.example.zomato.util.AppResponseBuilder;
import com.example.zomato.util.ResponseStructure;
import com.example.zomato.util.SimpleResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${zomato.base_url}")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final AppResponseBuilder appResponseBuilder;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> addUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.addUser(userRequest);
        return appResponseBuilder.success(HttpStatus.CREATED, "user added", userResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseStructure<AuthResponse>> login(@RequestBody LoginRequest loginRequest) {
        AuthResponse authResponse = userService.login(loginRequest);
        HttpHeaders httpHeaders = userService.grantCredentials(authResponse);
        return appResponseBuilder.success(HttpStatus.OK, "logged in successful", authResponse, httpHeaders);
    }

    @PostMapping("/refresh")
    public ResponseEntity<ResponseStructure<AuthResponse>> refreshLogin(@CookieValue(required = false, name = "rt") String refreshToken) {
        AuthResponse authResponse = userService.refreshLogin(refreshToken);
        HttpHeaders httpHeaders = userService.grantCredentials(authResponse);
        return appResponseBuilder.success(HttpStatus.OK, "logged in successfully refreshed", authResponse, httpHeaders);
    }

    @PostMapping("/logout")
    public ResponseEntity<SimpleResponseStructure> logout() {
        HttpHeaders httpHeaders = userService.logout();
        return appResponseBuilder.success(HttpStatus.OK, "Logged out successfully", httpHeaders);
    }
}
