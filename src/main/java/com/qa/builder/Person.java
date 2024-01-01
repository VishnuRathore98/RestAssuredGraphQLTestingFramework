package com.qa.builder;

import lombok.Builder;
import lombok.Getter;

// Constructor level @Builder.
@Getter
public class Person {
    String name;
    int age;
    boolean isActive;
    String role;

    @Builder
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}
