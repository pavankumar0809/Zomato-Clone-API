package com.example.zomato.entity;

import com.example.zomato.config.GenerateCustomId;
import com.example.zomato.enums.DietType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
public class Restaurant {

    @Id
    @GenerateCustomId
    @Column(name = "restaurantId")
    private String restaurantId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "diet_types")
    @ElementCollection
    private List<DietType> dietTypes;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "cuisines")
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Cuisine> cuisines;

    @Column(name = "menu_categories")
    @OneToMany(cascade = CascadeType.ALL)
    private List<MenuCategory> menuCategories;
}

