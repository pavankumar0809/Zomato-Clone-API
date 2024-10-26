package com.example.zomato.controller;

import com.example.zomato.requestdtos.UserRequest;
import com.example.zomato.responsedtos.UserResponse;
import com.example.zomato.service.UserService;
import com.example.zomato.util.AppResponseBuilder;
import com.example.zomato.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${zomato.base_url}")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final AppResponseBuilder appResponseBuilder;

    @PostMapping("/users")
    public ResponseEntity<ResponseStructure<UserResponse>> addUser(@RequestBody UserRequest userRequest){
            UserResponse userResponse = userService.addUser(userRequest);
            return appResponseBuilder.success(HttpStatus.CREATED, "user added", userResponse);
    }
}
