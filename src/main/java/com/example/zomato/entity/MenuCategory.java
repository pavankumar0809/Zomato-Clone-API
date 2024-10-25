package com.example.zomato.entity;

import com.example.zomato.config.GenerateCustomId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "menu_category")
@Getter
@Setter
public class MenuCategory {
    @GenerateCustomId
    @Id
    @Column(name = "category_id")
    private String categoryId;
    @Column(name = "title")
    private  String title;
    @OneToMany(mappedBy = "menuCategory")
    private Food food;

    @ManyToOne
    private Restaurant restaurant;
}
