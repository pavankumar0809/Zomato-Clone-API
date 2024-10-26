package com.example.zomato.service;

import com.example.zomato.entity.Food;
import com.example.zomato.mapping.FoodMapper;
import com.example.zomato.repository.FoodRepository;
import com.example.zomato.requestdtos.FoodRequest;
import com.example.zomato.responsedtos.FoodResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;

    public FoodResponse addFood(FoodRequest foodRequest) {
        if (foodRepository.existsByTitleIgnoreCase(foodRequest.getTitle())) {
            return null;
        }
        Food food = foodMapper.mapToFood(foodRequest, new Food());
        foodRepository.save(food);
       FoodResponse foodResponse= foodMapper.mapToFoodResponse(food);
       return foodResponse;
    }
}
