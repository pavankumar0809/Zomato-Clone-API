package com.example.zomato.repository;

import com.example.zomato.entity.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuCategoryRepository extends JpaRepository<MenuCategory, String> {
}
