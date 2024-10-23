package com.example.zomato.exceptionhandler;

import com.example.zomato.exception.MenuNotFoundByIdException;
import com.example.zomato.util.AppResponseBuilder;
import com.example.zomato.util.ErrorStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class MenuCategoryExceptionHandler {
    private AppResponseBuilder appResponseBuilder;

    @ExceptionHandler
    public ResponseEntity<ErrorStructure> handleMenuNotFoundById(MenuNotFoundByIdException ex) {
        return appResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Menu Category Not found by given Id");
    }
}
