package com.example.zomato.requestdtos;

import com.example.zomato.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserRequest {
    private String firstName;
    private String lastName;
    private UserRole role;
    private String email;
    private String password;
}
