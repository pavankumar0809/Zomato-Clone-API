package com.example.zomato.requestdtos;

import com.example.zomato.enums.DietType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RestaurantRequest {

    private String name;
    private String description;
    private String phoneNumber;
    private String email;
    private List<DietType> dietTypes;
}
