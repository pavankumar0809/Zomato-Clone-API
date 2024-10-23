package com.example.zomato.entity;

import com.example.zomato.config.GenerateCustomId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
}
