package com.example.zomato.responsedtos;

import com.example.zomato.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponse {
    private String userId;
    private String firstName;
    private String lastName;
    private UserRole userRole;
}
