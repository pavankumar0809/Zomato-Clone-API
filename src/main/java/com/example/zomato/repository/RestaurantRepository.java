package com.example.zomato.repository;

import com.example.zomato.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, String> {
}
