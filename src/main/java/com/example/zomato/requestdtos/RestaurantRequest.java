package com.example.zomato.requestdtos;

import com.example.zomato.enums.DietType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RestaurantRequest {

    @NotNull(message = "name cannot be null")
    @NotBlank(message = "name cannot be blank")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "The name must only contains alphabetics")
    private String name;

    @NotNull(message = "description cannot be null")
    @NotBlank(message = "description cannot be blank")
    private String description;

    @NotNull(message = "phoneNumber cannot be null")
    @NotBlank(message = "phoneNumber cannot be blank")
    @Pattern(regexp = "^\\+91[6-9]\\d{9}$", message = "Invalid PhoneNumber")
    private String phoneNumber;

    @NotNull(message = "email cannot be null")
    @NotBlank(message = "email cannot be blank")
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$", message = "Invalid EmailId")
    private String email;

    @NotNull(message = "dietTypes cannot be null")
    private List<DietType> dietTypes;
}
