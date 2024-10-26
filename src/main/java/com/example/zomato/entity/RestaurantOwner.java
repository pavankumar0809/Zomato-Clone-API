package com.example.zomato.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class RestaurantOwner extends User {
    @OneToMany(mappedBy = "restaurantOwner", cascade = CascadeType.ALL)
    private List<Restaurant> restaurant;
}
