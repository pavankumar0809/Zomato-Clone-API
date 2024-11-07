package com.example.zomato.service;

import com.example.zomato.entity.Restaurant;
import com.example.zomato.exception.RestaurantNotFoundByIdException;
import com.example.zomato.mapping.RestaurantMapper;
import com.example.zomato.repository.RestaurantRepository;
import com.example.zomato.requestdtos.CuisineRequest;
import com.example.zomato.requestdtos.RestaurantRequest;
import com.example.zomato.responsedtos.CuisineResponse;
import com.example.zomato.responsedtos.RestaurantResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;
    private final ImageService imageService;



    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) {
        Restaurant restaurant = restaurantRepository.save(restaurantMapper.mapToRestaurant(restaurantRequest, new Restaurant()));
        return restaurantMapper.mapToRestaurantResponse(restaurant);
    }

    public RestaurantResponse findRestaurant(String restaurantId) {
        return restaurantRepository.findById(restaurantId)
                .map(restaurantMapper::mapToRestaurantResponse)
                .orElseThrow(() -> new RestaurantNotFoundByIdException("Failed to find Restaurant."));

    }

    public RestaurantResponse updateRestaurant(RestaurantRequest restaurantRequest, String restaurantId) {
        return restaurantRepository.findById(restaurantId)
                .map(restaurant -> {
                    restaurantMapper.mapToRestaurant(restaurantRequest, restaurant);
                    restaurant = restaurantRepository.save(restaurant);
                    return restaurantMapper.mapToRestaurantResponse(restaurant);
                }).orElseThrow(() -> new RestaurantNotFoundByIdException("Failed to update the restaurant"));
    }

    public String addImage(String restaurantId, MultipartFile file) {

        return restaurantRepository.findById(restaurantId)
                .map(restaurant -> {
                    try {
                        String url = imageService.uploadImage(file);
                        restaurant.setImageUrl(url);
                        restaurantRepository.save(restaurant);
                        return url;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }).orElseThrow(() -> new RestaurantNotFoundByIdException("Failed to add Image to restaurant"));
    }
}
