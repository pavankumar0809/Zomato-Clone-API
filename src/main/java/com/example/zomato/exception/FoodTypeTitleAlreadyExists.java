package com.example.zomato.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FoodTypeTitleAlreadyExists extends RuntimeException {
    private String message;
}
