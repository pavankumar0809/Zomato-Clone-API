package com.example.zomato.entity;

import com.example.zomato.config.GenerateCustomId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Entity
@Getter
@Setter
public class Food {
    @Id
    @GenerateCustomId
    private String foodId;
    private String title;
    private String description;
    private double price;
    private Duration preparationTime;
    private boolean availabilty;
    @ManyToOne
    private Restaurant restaurants;
    @ManyToOne
    private MenuCategory menuCategory;
    @ManyToOne
    private Cuisine cuisine;
    @ManyToOne
    private FoodType foodType;
}
