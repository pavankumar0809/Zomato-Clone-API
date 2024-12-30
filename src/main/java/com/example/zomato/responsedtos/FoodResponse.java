package com.example.zomato.responsedtos;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
public class FoodResponse {

    private String title;
    private String description;
    private double price;
    private Duration preparationTime;
    private boolean availability;
}
