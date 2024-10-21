package com.example.zomato.controller;

import com.example.zomato.entity.Restaurant;
import com.example.zomato.requestdtos.RestaurantRequest;
import com.example.zomato.responsedtos.RestaurantResponse;
import com.example.zomato.service.RestaurantService;
import com.example.zomato.util.AppResponseBuilder;
import com.example.zomato.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("${zomato.base_url}")
@AllArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantservice;
    private final AppResponseBuilder responseBuilder;

    @PostMapping("/restaurants/add")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> addRestaurant(@RequestBody RestaurantRequest restaurantRequest) {
        RestaurantResponse response = restaurantservice.addRestaurant(restaurantRequest);
        return responseBuilder.success(HttpStatus.CREATED, "restaurant inserted", response);
    }

    @GetMapping("/restaurants/find")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> findRestaurant(@RequestParam String restaurantId) {
        RestaurantResponse response = restaurantservice.findRestaurant(restaurantId);
        return responseBuilder.success(HttpStatus.FOUND, "restaurant found", response);
    }

    @PutMapping("/restaurants/update")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> updateRestaurant(@RequestBody RestaurantRequest restaurantRequest, @RequestParam("restaurant_id") String restaurantId) {
        RestaurantResponse response = restaurantservice.updateRestaurant(restaurantRequest, restaurantId);
        return responseBuilder.success(HttpStatus.OK, "restaurant updated", response);
    }

    public ResponseEntity<ResponseStructure<RestaurantResponse>> uploadImage(@PathVariable String restaurantId, @RequestParam MultipartFile file){
        return  null;
    }

}
