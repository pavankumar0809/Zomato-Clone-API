package com.example.zomato.controller;

import com.example.zomato.entity.Restaurant;
import com.example.zomato.requestdtos.CuisineRequest;
import com.example.zomato.requestdtos.RestaurantRequest;
import com.example.zomato.responsedtos.CuisineResponse;
import com.example.zomato.responsedtos.RestaurantResponse;
import com.example.zomato.service.RestaurantService;
import com.example.zomato.util.AppResponseBuilder;
import com.example.zomato.util.ErrorStructure;
import com.example.zomato.util.ResponseStructure;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("${zomato.base_url}")
@AllArgsConstructor
@Tag(name = "Restaurant Controller", description = "Restaurant Controller gives endpoint for Restaurant Entity")
public class RestaurantController {
    private final RestaurantService restaurantservice;
    private final AppResponseBuilder responseBuilder;

    @Operation(description = "This endpoint used to add the restaurant", responses = {
            @ApiResponse(responseCode = "201", description = "restaurant inserted"),
            @ApiResponse(responseCode = "400", description = "Restaurant not inserted", content = {
                    @Content(schema = @Schema(implementation = ErrorStructure.class))
            })
    })
    @PostMapping("/restaurants")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> addRestaurant(@Valid @RequestBody RestaurantRequest restaurantRequest) {
        RestaurantResponse response = restaurantservice.addRestaurant(restaurantRequest);
        return responseBuilder.success(HttpStatus.CREATED, "restaurant inserted", response);
    }

    @Operation(description = "This endpoint used to find a restaurant by Id", responses = {
            @ApiResponse(responseCode = "304", description = "Restaurant found"),
            @ApiResponse(responseCode = "404", description = "Restaurant not found", content = {
                    @Content(schema = @Schema(implementation = ErrorStructure.class))
            })
    })
    @GetMapping("/restaurants/{restaurantId}")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> findRestaurant(@PathVariable String restaurantId) {
        RestaurantResponse response = restaurantservice.findRestaurant(restaurantId);
        return responseBuilder.success(HttpStatus.FOUND, "restaurant found", response);
    }

    @Operation(description = "This endpoint used to update the restaurant", responses = {
            @ApiResponse(responseCode = "201", description = "Restaurant updated"),
            @ApiResponse(responseCode = "400", description = "Restaurant not updated", content = {
                    @Content(schema = @Schema(implementation = ErrorStructure.class))
            })
    })
    @PutMapping("/restaurants/{restaurantId}")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> updateRestaurant(@RequestBody RestaurantRequest restaurantRequest, @PathVariable String restaurantId) {
        RestaurantResponse response = restaurantservice.updateRestaurant(restaurantRequest, restaurantId);
        return responseBuilder.success(HttpStatus.OK, "restaurant updated", response);
    }

    @Operation(description = "This endpoint used to add the image to restaurant", responses = {
            @ApiResponse(responseCode = "201", description = "image inserted"),
            @ApiResponse(responseCode = "400", description = "image not inserted", content = {
                    @Content(schema = @Schema(implementation = ErrorStructure.class))
            })
    })
    @PutMapping("restaurants/{restaurantId}/images")
    public ResponseEntity<ResponseStructure<String>> addImage(@PathVariable String restaurantId, @RequestParam MultipartFile file) throws IOException {
        String url = restaurantservice.addImage(restaurantId, file);
        return responseBuilder.success(HttpStatus.OK, "restaurant updated", url);
    }

}
