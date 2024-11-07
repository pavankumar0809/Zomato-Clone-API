package com.example.zomato.controller;

import com.example.zomato.mapping.RestaurantMapper;
import com.example.zomato.requestdtos.AddressRequest;
import com.example.zomato.responsedtos.AddressResponse;
import com.example.zomato.service.AddressService;
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

@RestController
@AllArgsConstructor
@RequestMapping("${zomato.base_url}")
@Tag(name = "Address Controller", description = "Address Controller gives endpoint for Address Entity")
public class AddressController {
    private final AppResponseBuilder appResponseBuilder;
    private final AddressService addressService;
    private final RestaurantMapper restaurantMapper;

    @Operation(description = "This endpoint used to add the address to restaurant", responses = {
            @ApiResponse(responseCode = "201", description = "address inserted"),
            @ApiResponse(responseCode = "400", description = "address not inserted", content = {
                    @Content(schema = @Schema(implementation = ErrorStructure.class))
            })
    })
    @PostMapping("/restaurants/{restaurantId}/addresses")
    public ResponseEntity<ResponseStructure<AddressResponse>> addAddress(@Valid @PathVariable String restaurantId, @RequestBody AddressRequest addressRequest) {
        AddressResponse addressResponse = addressService.addAddress(restaurantId, addressRequest);
        return appResponseBuilder.success(HttpStatus.CREATED, "address added", addressResponse);
    }

    @Operation(description = "This endpoint used to update the address to restaurant", responses = {
            @ApiResponse(responseCode = "200", description = "address updated"),
            @ApiResponse(responseCode = "400", description = "address not updated", content = {
                    @Content(schema = @Schema(implementation = ErrorStructure.class))
            })
    })
    @PutMapping("/restaurants/{restaurantId}/addresses")
    public ResponseEntity<ResponseStructure<AddressResponse>> updateAddress(@PathVariable String restaurantId, @RequestBody AddressRequest addressRequest) {
        AddressResponse addressResponse = addressService.updateAddress(restaurantId, addressRequest);
        return appResponseBuilder.success(HttpStatus.OK, "address updated", addressResponse);
    }
}
