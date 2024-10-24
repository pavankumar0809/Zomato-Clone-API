package com.example.zomato.repository;

import com.example.zomato.entity.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodTypeRepository extends JpaRepository<FoodType, String> {
}
