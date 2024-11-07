package com.example.zomato.repository;

import com.example.zomato.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, String> {

    public boolean existsByTitleIgnoreCase(String title);
}
