package com.example.zomato.controller;

import com.example.zomato.requestdtos.LoginRequest;
import com.example.zomato.requestdtos.UserRequest;
import com.example.zomato.responsedtos.UserResponse;
import com.example.zomato.security.JWTService;
import com.example.zomato.service.UserService;
import com.example.zomato.util.AppResponseBuilder;
import com.example.zomato.util.ResponseStructure;
import lombok.AllArgsConstructor;
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
    public ResponseEntity<ResponseStructure<UserResponse>> addUser(@RequestBody UserRequest userRequest){
            UserResponse userResponse = userService.addUser(userRequest);
            return appResponseBuilder.success(HttpStatus.CREATED, "user added", userResponse);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
       return userService.login(loginRequest);
    }
}
