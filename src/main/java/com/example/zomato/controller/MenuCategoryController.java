package com.example.zomato.controller;

import com.example.zomato.requestdtos.MenuCategoryRequest;
import com.example.zomato.responsedtos.MenuCategoryResponse;
import com.example.zomato.util.AppResponseBuilder;
import com.example.zomato.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${zomato.base_url}")
@AllArgsConstructor
public class MenuCategoryController {
    private final MenuCategoryService menuCategoryService;
    private final AppResponseBuilder appResponseBuilder;

        @PostMapping("/restaurants/{restaurantId}/menu_categories")
        public ResponseEntity<ResponseStructure<MenuCategoryResponse>> addMenuCategory(@PathVariable String restaurantId, @RequestBody MenuCategoryRequest menuCategoryRequest){
            MenuCategoryResponse menuCategoryResponse=menuCategoryService.addMenuCategory(restaurantId, menuCategoryRequest);
            return appResponseBuilder.success(HttpStatus.CREATED,"Menu Added", menuCategoryResponse);
        }
}
