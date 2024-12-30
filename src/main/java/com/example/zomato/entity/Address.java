package com.example.zomato.entity;

import com.example.zomato.config.GenerateCustomId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "addresses")
@Getter
@Setter
public class Address {
    @Id
    @GenerateCustomId
    @Column(name = "address_id")
    private String address_id;

    @Column(name = "addressLine1")
    private String addressLine1;

    @Column(name = "addressLine2")
    private String addressLine2;

    @Column(name = "landmark")
    private String landmark;

    @Column(name = "area")
    private String area;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @ManyToOne
    private Customer customer;
}
