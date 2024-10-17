package com.example.zomato.controller;

import com.example.zomato.requestdtos.RestaurantRequest;
import com.example.zomato.responsedtos.RestaurantResponse;
import com.example.zomato.service.RestaurantService;
import com.example.zomato.util.AppResponseBuilder;
import com.example.zomato.util.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${zomato.base_url}")
public class RestaurantController {
    private final RestaurantService restaurantservice;
    private final AppResponseBuilder responseBuilder;

    public RestaurantController(RestaurantService restaurantservice, AppResponseBuilder responseBuilder) {
        this.restaurantservice = restaurantservice;
        this.responseBuilder=responseBuilder;
    }

    @PostMapping("/restaurants/add")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> addRestaurant(@RequestBody RestaurantRequest restaurantRequest){
            RestaurantResponse response= restaurantservice.addRestaurant(restaurantRequest);
            return responseBuilder.success(HttpStatus.CREATED,"restaurant inserted", response);
    }

}
