package com.example.zomato.service;

import com.example.zomato.entity.MenuCategory;
import com.example.zomato.exception.MenuNotFoundByIdException;
import com.example.zomato.exception.RestaurantNotFoundByIdException;
import com.example.zomato.mapping.MenuCategoryMapper;
import com.example.zomato.repository.MenuCategoryRepository;
import com.example.zomato.repository.RestaurantRepository;
import com.example.zomato.requestdtos.MenuCategoryRequest;
import com.example.zomato.responsedtos.MenuCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MenuCategoryService {
    private final MenuCategoryRepository menuCategoryRepository;
    private final RestaurantRepository restaurantRepository;
    private final MenuCategoryMapper menuCategoryMapper;

    public MenuCategoryResponse addMenuCategory(String restaurantId, MenuCategoryRequest menuCategoryRequest) {
        return restaurantRepository.findById(restaurantId)
                .map(restaurant -> {
                    MenuCategory menuCategory = menuCategoryMapper.mapToMenuCategory(menuCategoryRequest, new MenuCategory());
                    menuCategoryRepository.save(menuCategory);
                    restaurant.getMenuCategories().add(menuCategory);
                    restaurantRepository.save(restaurant);
                    return menuCategoryMapper.mapToMenuCategoryResponse(menuCategory);
                })
                .orElseThrow(() -> new RestaurantNotFoundByIdException("Unable to add Menu Category"));
    }

    public MenuCategoryResponse updateMenuCategory(String menuCategoryId, MenuCategoryRequest menuCategoryRequest) {
        return menuCategoryRepository.findById(menuCategoryId)
                .map(exMenuCategory -> {
                    menuCategoryMapper.mapToMenuCategory(menuCategoryRequest, exMenuCategory);
                    menuCategoryRepository.save(exMenuCategory);
                    return menuCategoryMapper.mapToMenuCategoryResponse(exMenuCategory);
                })
                .orElseThrow(() -> new MenuNotFoundByIdException("Cannot update menu category"));
    }
}
