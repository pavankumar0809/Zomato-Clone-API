package com.example.zomato.controller;

import com.example.zomato.requestdtos.FoodRequest;
import com.example.zomato.responsedtos.FoodResponse;
import com.example.zomato.service.FoodService;
import com.example.zomato.util.AppResponseBuilder;
import com.example.zomato.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${zomato.base_url}")
@AllArgsConstructor
public class FoodController {

    private final FoodService foodService;
    private AppResponseBuilder appResponseBuilder;

    @PostMapping("/foods")
    public ResponseEntity<ResponseStructure<FoodResponse>> addFood(@RequestBody FoodRequest foodRequest){
        FoodResponse foodResponse= foodService.addFood(foodRequest);
        return  appResponseBuilder.success(HttpStatus.CREATED, "Food inserted", foodResponse);
    }
}
