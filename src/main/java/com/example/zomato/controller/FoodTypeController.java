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
    public ResponseEntity<ResponseStructure<String>> addFoodtype(@RequestBody FoodTypeRequest foodTypeRequest) {
        String foodTitle = foodTypeService.addFoodType(foodTypeRequest);
        return appResponseBuilder.success(HttpStatus.CREATED, "Food Type added", foodTitle);
    }

    @GetMapping("/foodtypes")
    public ResponseEntity<ResponseStructure<List<String>>> findAllFoodType() {
        List<String> foodTitles = foodTypeService.finadAllFoodType();
        return appResponseBuilder.success(HttpStatus.FOUND, "Food Types Found", foodTitles);
    }
}
