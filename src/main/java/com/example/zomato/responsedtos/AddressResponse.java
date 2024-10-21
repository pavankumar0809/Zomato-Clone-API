package com.example.zomato.responsedtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {

    private String address_id;
    private String addressLine1;
    private String addressLine2;
    private String landmark;
    private String area;
    private String city;
    private String state;
    private String pincode;
    private double latitude;
    private double longitude;
}
