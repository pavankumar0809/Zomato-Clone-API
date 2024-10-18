package com.example.zomato.service;

import com.example.zomato.entity.Restaurant;
import com.example.zomato.exception.RestaurantNotFoundByIdException;
import com.example.zomato.mapping.RestaurantMapper;
import com.example.zomato.repository.RestaurantRepository;
import com.example.zomato.requestdtos.RestaurantRequest;
import com.example.zomato.responsedtos.RestaurantResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;



    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) {
    Restaurant restaurant=restaurantRepository.save(restaurantMapper.mapToRestaurant(restaurantRequest, new Restaurant()));
    return restaurantMapper.mapToRestaurantResponse(restaurant);
    }

    public RestaurantResponse findRestaurant(String restaurantId) {
        Optional<Restaurant> optional= restaurantRepository.findById(restaurantId);
        if (optional.isPresent()) {
            Restaurant restaurant=optional.get();
            return restaurantMapper.mapToRestaurantResponse(restaurant);
        }
        else
            throw new RestaurantNotFoundByIdException("failed to find restaurant");
    }
}
