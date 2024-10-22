package com.example.zomato.controller;

import com.example.zomato.mapping.RestaurantMapper;
import com.example.zomato.requestdtos.AddressRequest;
import com.example.zomato.responsedtos.AddressResponse;
import com.example.zomato.service.AddressService;
import com.example.zomato.util.AppResponseBuilder;
import com.example.zomato.util.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("${zomato.base_url}")
public class AddressController {
    private final AppResponseBuilder appResponseBuilder;
    private final AddressService addressService;
    private final RestaurantMapper restaurantMapper;

    @PostMapping("/restaurants/{restaurantId}/addresses")
    public ResponseEntity<ResponseStructure<AddressResponse>> addAddress(@Valid @PathVariable String restaurantId, @RequestBody AddressRequest addressRequest) {
        AddressResponse addressResponse = addressService.addAddress(restaurantId, addressRequest);
        return appResponseBuilder.success(HttpStatus.CREATED, "address added", addressResponse);
    }

    @PutMapping("/restaurants/{restaurantId}/addresses")
    public ResponseEntity<ResponseStructure<AddressResponse>> updateAddress(@PathVariable String restaurantId, @RequestBody AddressRequest addressRequest) {
        AddressResponse addressResponse = addressService.updateAddress(restaurantId, addressRequest);
        return appResponseBuilder.success(HttpStatus.OK, "address updated", addressResponse);
    }
}
