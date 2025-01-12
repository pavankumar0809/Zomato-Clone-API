package com.example.zomato.config;

import org.hibernate.annotations.IdGeneratorType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)          //Where
@Retention(RetentionPolicy.RUNTIME)     // When
@IdGeneratorType(CustomIdGenerator.class)   //What
public @interface GenerateCustomId {
}
