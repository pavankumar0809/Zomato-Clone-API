package com.example.zomato.controller;

import com.example.zomato.entity.Restaurant;
import com.example.zomato.mapping.RestaurantMapper;
import com.example.zomato.requestdtos.AddressRequest;
import com.example.zomato.responsedtos.AddressRespone;
import com.example.zomato.service.AddressService;
import com.example.zomato.util.AppResponseBuilder;
import com.example.zomato.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("${zomato.base_url}")
public class AddressController {
    private final AppResponseBuilder appResponseBuilder;
    private final AddressService addressService;
    private final RestaurantMapper restaurantMapper;

    @PostMapping("addresses/add")
    public ResponseEntity<ResponseStructure<AddressRespone>> addAddress(@RequestParam String restaurantId, @RequestBody AddressRequest addressRequest) {
        AddressRespone addressRespone = addressService.addAddress(restaurantId ,addressRequest);
        return appResponseBuilder.success(HttpStatus.CREATED, "address added", addressRespone);
    }
}
