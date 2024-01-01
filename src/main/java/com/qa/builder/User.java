package com.qa.builder;

import lombok.Builder;
import lombok.Getter;

// Class level @Builder.
@Builder
@Getter
public class User {
    String name;
    int age;
}
