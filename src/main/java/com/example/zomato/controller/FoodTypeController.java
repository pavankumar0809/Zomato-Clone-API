package com.example.zomato.controller;

import com.example.zomato.requestdtos.FoodTypeRequest;
import com.example.zomato.responsedtos.FoodTypeResponse;
import com.example.zomato.service.FoodTypeService;
import com.example.zomato.util.AppResponseBuilder;
import com.example.zomato.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("${zomato.base_url}")
public class FoodTypeController {
    private final FoodTypeService foodTypeService;
    private final AppResponseBuilder appResponseBuilder;

    @PostMapping("/foodtypes")
    public ResponseEntity<ResponseStructure<FoodTypeResponse>> addFoodtype(@RequestBody FoodTypeRequest foodTypeRequest) {
        FoodTypeResponse foodTypeResponse = foodTypeService.addFoodType(foodTypeRequest);
        return appResponseBuilder.success(HttpStatus.CREATED, "Food Type added", foodTypeResponse);
    }

    @GetMapping("/foodtypes")
    public ResponseEntity<ResponseStructure<List<FoodTypeResponse>>> findAllFoodType(){
        List<FoodTypeResponse> foodTypeResponses = foodTypeService.finadAllFoodType();
        return appResponseBuilder.success(HttpStatus.FOUND, "Food Types Found", foodTypeResponses);
    }
}
