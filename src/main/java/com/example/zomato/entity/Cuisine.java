package com.example.zomato.entity;

import com.example.zomato.config.GenerateCustomId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
}
