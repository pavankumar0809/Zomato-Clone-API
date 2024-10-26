package com.example.zomato.requestdtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
public class FoodRequest {
    @NotNull(message = "Title cannot be null")
    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotNull(message = "description cannot be null")
    @NotBlank(message = "description cannot be null")
    private String description;

    @NotNull(message = "price cannot be null")
    @NotBlank(message = "price cannot be blank")
    @Pattern(regexp = "\\d+\\.\\d{2}")
    private double price;

    @NotNull(message = "availability cannot be null")
    @NotBlank(message = "availability cannot be blank")
    @Pattern(regexp = "(?i)true|false")
    private boolean availabilty;

    private Duration preparationTime;
}
