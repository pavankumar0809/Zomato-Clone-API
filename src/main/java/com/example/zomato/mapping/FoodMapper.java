package com.example.zomato.mapping;

import com.example.zomato.entity.Food;
import com.example.zomato.requestdtos.FoodRequest;
import com.example.zomato.responsedtos.FoodResponse;
import org.springframework.stereotype.Component;

@Component
public class FoodMapper {

    public Food mapToFood(FoodRequest foodRequest, Food food) {
        food.setTitle(foodRequest.getTitle());
        food.setDescription(foodRequest.getDescription());
        food.setPrice(foodRequest.getPrice());
        food.setAvailabilty(foodRequest.isAvailabilty());
        food.setPreparationTime(foodRequest.getPreparationTime());
        return food;
    }
    public FoodResponse mapToFoodResponse(Food food){
        FoodResponse foodResponse= new FoodResponse();
        foodResponse.setTitle(food.getTitle());
        foodResponse.setAvailability(food.isAvailabilty());
        foodResponse.setDescription(food.getDescription());
        foodResponse.setPrice(food.getPrice());
        foodResponse.setPreparationTime(food.getPreparationTime());
        return foodResponse;
    }
}
