package com.example.zomato.requestdtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodTypeRequest {
    @NotNull(message = "title cannot be null")
    @NotBlank(message = "title cannot be blank")
    private String title;

}
