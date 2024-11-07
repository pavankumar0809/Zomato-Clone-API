package com.example.zomato.entity;

import com.example.zomato.config.GenerateCustomId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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
}
