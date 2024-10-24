package com.example.zomato.service;

import com.example.zomato.entity.FoodType;
import com.example.zomato.exception.FoodTypeTitleAlreadyExists;
import com.example.zomato.mapping.FoodTypeMapper;
import com.example.zomato.repository.FoodTypeRepository;
import com.example.zomato.requestdtos.FoodTypeRequest;
import com.example.zomato.responsedtos.FoodTypeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FoodTypeService {
    private final FoodTypeRepository foodTypeRepository;
    private final FoodTypeMapper foodTypeMapper;

    public FoodTypeResponse addFoodType(FoodTypeRequest foodTypeRequest) {
        if (foodTypeRepository.existsByTitleIgnoreCase(foodTypeRequest.getTitle())){
            throw new FoodTypeTitleAlreadyExists("Food type with the same title already exists.");
        }
        return foodTypeMapper.mapToFoodTypeResponse(foodTypeRepository.save(foodTypeMapper.mapToFoodType(foodTypeRequest, new FoodType())));
    }
}
