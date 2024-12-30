package com.example.zomato.exceptionhandler;

import com.example.zomato.exception.FoodTypeTitleAlreadyExists;
import com.example.zomato.util.AppResponseBuilder;
import com.example.zomato.util.ErrorStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class FoodTypeExceptionHandler {
    private final AppResponseBuilder appResponseBuilder;

    @ExceptionHandler(FoodTypeTitleAlreadyExists.class)
    public ResponseEntity<ErrorStructure> handleFoodTypeAlreadyExists(FoodTypeTitleAlreadyExists ex) {
        return appResponseBuilder.error(HttpStatus.BAD_REQUEST, ex.getMessage(), "Title already exists");
    }
}
