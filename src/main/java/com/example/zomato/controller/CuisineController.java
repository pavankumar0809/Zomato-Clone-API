package com.example.zomato.controller;

import com.example.zomato.entity.Cuisine;
import com.example.zomato.requestdtos.CuisineRequest;
import com.example.zomato.responsedtos.CuisineResponse;
import com.example.zomato.service.CuisineService;
import com.example.zomato.util.AppResponseBuilder;
import com.example.zomato.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("${zomato.base_url}")
public class CuisineController {

    private final CuisineService cuisineService;
    private final AppResponseBuilder appResponseBuilder;
    @PreAuthorize("hasAuthority('RESTAURANT_WRITE') AND hasAuthority('RESTAURANT_READ')")
    @PostMapping("/restaurants/{restaurantId}/cuisines")
    public ResponseEntity<ResponseStructure<CuisineResponse>> addCuisine(@PathVariable String restaurantId, @RequestBody CuisineRequest cuisineRequest) {
        CuisineResponse cuisineResponse = cuisineService.addCuisine(restaurantId, cuisineRequest);
        return appResponseBuilder.success(HttpStatus.CREATED, "Cuisine added", cuisineResponse);
    }

    @GetMapping("/restaurants/cuisines")
    public ResponseEntity<ResponseStructure<List<CuisineResponse>>> findAllCuisines() {
        List<CuisineResponse> cuisineResponses = cuisineService.findAllCuisines();
        return appResponseBuilder.success(HttpStatus.FOUND, "Cuisines Found", cuisineResponses);
    }
}
