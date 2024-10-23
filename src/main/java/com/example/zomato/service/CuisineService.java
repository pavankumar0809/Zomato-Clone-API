package com.example.zomato.service;

import com.example.zomato.entity.Cuisine;
import com.example.zomato.exception.RestaurantNotFoundByIdException;
import com.example.zomato.mapping.CuisineMapper;
import com.example.zomato.repository.CuisineRepository;
import com.example.zomato.repository.RestaurantRepository;
import com.example.zomato.requestdtos.CuisineRequest;
import com.example.zomato.responsedtos.CuisineResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CuisineService {
    private final CuisineMapper cuisineMapper;
    private final CuisineRepository cuisineRepository;
    private final RestaurantRepository restaurantRepository;

    public CuisineResponse addCuisine(String restaurantId, CuisineRequest cuisineRequest) {
        return restaurantRepository.findById(restaurantId)
                .map(restaurant -> {
                    Cuisine cuisine = cuisineMapper.mapToCuisine(cuisineRequest, new Cuisine());
                    restaurant.getCuisines().add(cuisine);
                    restaurantRepository.save(restaurant);
                    return cuisineMapper.mapToCuisineResponse(cuisine);
                })
                .orElseThrow(() -> new RestaurantNotFoundByIdException("Restaurant not available with given Id"));
    }

    public List<CuisineResponse> findAllCuisines() {
        List<Cuisine> cuisines= cuisineRepository.findAll();
        List<CuisineResponse> cuisineResponses= new ArrayList<>();
        for (Cuisine cuisine:cuisines){
            cuisineResponses.add(cuisineMapper.mapToCuisineResponse(cuisine));
        }
         return cuisineResponses;
    }
}
