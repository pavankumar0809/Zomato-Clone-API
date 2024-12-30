package com.example.zomato.responsedtos;

import com.example.zomato.enums.UserRole;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
public class AuthResponse {

    private String userId;

    private String username;

    private Duration accessExpiration;

    private Duration refreshExpiration;

    private UserRole role;
}
