package com.example.zomato.mapping;

import com.example.zomato.entity.User;
import com.example.zomato.requestdtos.UserRequest;
import com.example.zomato.responsedtos.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser(UserRequest userRequest, User user) {
        user.setRole(userRequest.getRole());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastname());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        return user;
    }

    public UserResponse mapToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(user.getUserId());
        userResponse.setUserRole(user.getRole());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        return userResponse;
    }
}
