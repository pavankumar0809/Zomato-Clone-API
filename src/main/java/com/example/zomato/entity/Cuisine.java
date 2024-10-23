package com.example.zomato.entity;

import com.example.zomato.config.GenerateCustomId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Table(name = "cuisines")
@Entity
public class Cuisine {

    @Id
    @GenerateCustomId
    @Column(name = "cuisineId")
    private String cuisineId;

    @Column(name = "title")
    private String title;
    @ManyToMany(mappedBy = "cuisines")
    private List<Restaurant> restaurants;
}
