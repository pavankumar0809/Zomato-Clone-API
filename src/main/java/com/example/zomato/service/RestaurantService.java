package com.example.zomato.service;

import com.example.zomato.entity.Restaurant;
import com.example.zomato.exception.RestaurantNotFoundByIdException;
import com.example.zomato.mapping.RestaurantMapper;
import com.example.zomato.repository.RestaurantRepository;
import com.example.zomato.requestdtos.RestaurantRequest;
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
        Optional<Restaurant> optional = restaurantRepository.findById(restaurantId);
        if (optional.isPresent()) {
            Restaurant restaurant = optional.get();
            return restaurantMapper.mapToRestaurantResponse(restaurant);
        } else
            throw new RestaurantNotFoundByIdException("failed to find restaurant");
    }

    public RestaurantResponse updateRestaurant(RestaurantRequest restaurantRequest, String restaurantId) {
        Optional<Restaurant> optional = restaurantRepository.findById(restaurantId);
        if (optional.isPresent()) {
            return restaurantMapper.
                    mapToRestaurantResponse(restaurantRepository.save(restaurantMapper.mapToRestaurant(restaurantRequest, optional.get())));
        }
        throw new RestaurantNotFoundByIdException("failed to update restaurant");
    }

    public String addImage(String restaurantId, MultipartFile file) throws IOException {
        Optional<Restaurant> optional = restaurantRepository.findById(restaurantId);
        if (optional.isPresent()) {
            Restaurant restaurant = optional.get();
            String url = imageService.uploadImage(file);
            restaurant.setImageUrl(url);
            restaurantRepository.save(restaurant);
            return url;
        }
        throw new RestaurantNotFoundByIdException("failed to add Image to restaurant");
    }

}
