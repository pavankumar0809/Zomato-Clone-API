package com.example.zomato.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public enum UserRole {
    RESTAURANT_OWNER(List.of(
            Privilege.RESTAURANT_WRITE,
            Privilege.RESTAURANT_READ
    )),
    CUSTOMER(List.of(
            Privilege.WRITE,
            Privilege.READ,
            Privilege.RESTAURANT_READ
    ));

    private List<Privilege> privileges;
}
