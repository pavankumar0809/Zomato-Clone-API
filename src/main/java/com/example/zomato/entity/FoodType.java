package com.example.zomato.entity;

import com.example.zomato.config.GenerateCustomId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "food_type")
public class FoodType {
    @Id
    @Column(name = "type_id")
    @GenerateCustomId
    private String typeId;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "foodType")
    private List<Food> food;
}
