package com.qa.builder;

public class PersonTest {
    public static void main(String[] args) {
//      Setting Person values.
        Person p1 = Person.builder().name("Udhistra").age(45).build();
//      Getting Person values.
        System.out.println("Name = "+p1.getName()+" Age = "+p1.getAge()+" Role = "+p1.getRole()+" Active = "+p1.isActive);
    }
}