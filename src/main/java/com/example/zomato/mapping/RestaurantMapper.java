package com.example.zomato.mapping;

import com.example.zomato.entity.Restaurant;
import com.example.zomato.requestdtos.RestaurantRequest;
import com.example.zomato.responsedtos.RestaurantResponse;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {
    public Restaurant mapToRestaurant(RestaurantRequest restaurantRequest, Restaurant restaurant){
        restaurant.setName(restaurantRequest.getName());
        restaurant.setDescription(restaurantRequest.getDescription());
        restaurant.setEmail(restaurantRequest.getEmail());
        restaurant.setPhoneNumber(restaurantRequest.getPhoneNumber());
        restaurant.setDietTypes(restaurantRequest.getDietTypes());
        return restaurant;
    }

    public RestaurantResponse mapToRestaurantResponse(Restaurant restaurant){
        RestaurantResponse response= new RestaurantResponse();
        response.setRestaurantId(restaurant.getRestaurantId());
        response.setName(restaurant.getName());
        response.setDescription(restaurant.getDescription());
        response.setDietTypes(restaurant.getDietTypes());
        return  response;
    }
}
