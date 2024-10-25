package com.example.zomato.mapping;

import com.example.zomato.entity.Food;
import com.example.zomato.requestdtos.FoodRequest;

public class FoodMapper {

    public Food mapToFood(FoodRequest foodRequest, Food food) {
        food.setTitle(foodRequest.getTitle());
        food.setDescription(foodRequest.getDescription());
        food.setPrice(foodRequest.getPrice());
        food.setAvailabilty(foodRequest.isAvailabilty());
        return null;
    }
}
