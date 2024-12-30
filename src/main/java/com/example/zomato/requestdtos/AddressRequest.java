package com.example.zomato.requestdtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {

    @NotNull(message = "addressLine1 should not be null")
    @NotBlank(message = "addressLine1 should not be blank")
    @Pattern(regexp = "^[a-zA-Z0-9\\s#.,-]+$")
    private String addressLine1;

    private String addressLine2;

    @NotNull(message = "landmark cannot be null")
    @NotBlank(message = "landmark cannot be blank")
    private String landmark;

    @NotNull(message = "area cannot be null")
    @NotBlank(message = "area cannot be blank")
    private String area;

    @NotNull(message = "city cannot be null")
    @NotBlank(message = "city cannot be blank")
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String city;

    @NotNull(message = "state cannot be null")
    @NotBlank(message = "state cannot be blank")
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String state;

    @NotNull(message = "pincode cannot be null")
    @NotBlank(message = "pincode cannot be blank")
    @Pattern(regexp = "^\\d{6}$")
    private String pincode;

    @NotNull(message = "latitude cannot be null")
    @NotBlank(message = "latitude cannot be blank")
    private double latitude;

    @NotNull(message = "longitude cannot be null")
    @NotBlank(message = "longitude cannot be blank")
    private double longitude;
}
