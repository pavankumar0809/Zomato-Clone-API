package com.example.zomato.service;

import com.example.zomato.entity.Customer;
import com.example.zomato.entity.RestaurantOwner;
import com.example.zomato.entity.User;
import com.example.zomato.mapping.UserMapper;
import com.example.zomato.repository.UserRepository;
import com.example.zomato.requestdtos.UserRequest;
import com.example.zomato.responsedtos.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse addUser(UserRequest userRequest) {
        User user = null;
        switch (userRequest.getRole()) {
            case RESTAURANT_OWNER -> user = new RestaurantOwner();
            case CUSTOMER -> user = new Customer();
        }
        if (user != null) {
            userMapper.mapToUser(userRequest, user);
            userRepository.save(user);
        }
        return userMapper.mapToUserResponse(user);
    }
}
