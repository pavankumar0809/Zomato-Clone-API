package com.example.zomato.entity;

import com.example.zomato.config.GenerateCustomId;
import com.example.zomato.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @Column(name = "user_id")
    @GenerateCustomId
    private String userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "role")
    private UserRole role;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}