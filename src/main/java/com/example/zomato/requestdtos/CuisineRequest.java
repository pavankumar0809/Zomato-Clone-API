package com.example.zomato.requestdtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CuisineRequest {

    @NotNull(message = "title cannot be Null")
    @NotBlank(message = "title cannot be blank")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "The title must only contains alphabetic")
    private String title;
}
