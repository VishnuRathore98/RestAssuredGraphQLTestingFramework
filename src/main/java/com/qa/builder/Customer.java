package com.qa.builder;

import lombok.Builder;
import lombok.Getter;

// Method level @Builder.
@Getter
public class Customer {
    String name;
    int age;
    String city;
    boolean isActive;

    public Customer(String name, int age, String city, boolean isActive) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.isActive = isActive;
    }

    @Builder
    public static Customer createInstance(String name, int age){
        return new Customer(name, age, "Jodhpur", true);
    }
}
