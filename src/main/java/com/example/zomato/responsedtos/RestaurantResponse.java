package com.example.zomato.responsedtos;

import com.example.zomato.enums.DietType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantResponse {

    private String restaurantId;
    private String name;
    private String description;
    private DietType dietType;
}
