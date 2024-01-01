package com.qa.builder;

public class UserTest {
    public static void main(String[] args) {

//      Passing values for both variables.
        User u1 = User.builder().name("Arjun").age(23).build();

//      Passing value only for name.
        User u2 = User.builder().name("Bheem").build();

//      Passing value for none of the variables.
        User u3 = User.builder().build();

//      Will get values for both variables.
        System.out.println("Name = "+u1.getName()+" Age = "+u1.getAge());

//      Will get value for name as passed, and 0 for age which is default value for int.
        System.out.println("Name = "+u2.getName()+" Age = "+u2.getAge());

//      Will get null for name and 0 for age, both of which are the default values.
        System.out.println("Name = "+u3.getName()+" Age = "+u3.getAge());

    }
}
