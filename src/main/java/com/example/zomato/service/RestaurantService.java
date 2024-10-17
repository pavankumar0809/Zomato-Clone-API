package com.example.zomato.service;

import com.example.zomato.entity.Restaurant;
import com.example.zomato.mapping.RestaurantMapper;
import com.example.zomato.repository.RestaurantRepository;
import com.example.zomato.requestdtos.RestaurantRequest;
import com.example.zomato.responsedtos.RestaurantResponse;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public RestaurantService(RestaurantRepository restaurantRepository, RestaurantMapper restaurantMapper) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper= restaurantMapper;
    }

    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) {
    Restaurant restaurant=restaurantRepository.save(restaurantMapper.mapToRestaurant(restaurantRequest, new Restaurant()));
    return restaurantMapper.mapToRestaurantResponse(restaurant);
    }
}
