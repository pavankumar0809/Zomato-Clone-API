package com.example.zomato.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddressNotFoundException extends RuntimeException {
    private final String message;

}
