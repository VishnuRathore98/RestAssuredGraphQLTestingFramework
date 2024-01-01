package com.qa.builder;

public class CustomerTest {
    public static void main(String[] args) {
//      Providing two values and getting remaining two from default.
        Customer c1 = Customer.builder().name("Nakul").age(26).build();
        System.out.println("Name = "+c1.getName()+" Age = "+c1.getAge()+" City = "+c1.getCity()+" Active = "+c1.isActive);
    }
}
