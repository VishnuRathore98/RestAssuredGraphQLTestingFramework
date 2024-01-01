package com.qa.Serialization_Deserialization;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.juneau.annotation.Beanc;

import java.util.Arrays;

@Getter
@Setter
// Must be here if you wish not to use the @Beanc annotation from juneau library.
@NoArgsConstructor
public class Product {
    private String name;
    private int price;
    private String color;
    private String[] sellerNames;

//  This will be used to display the POJO and JSON/XML/HTML keys.
//    @Beanc(properties = "name, price, color, sellerNames")
    public Product(String name, int price, String color, String[] sellerNames) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.sellerNames = sellerNames;
    }

    @Override
    public String toString() {
        return "Product{" +
            "name='" + name + '\'' +
            ", price=" + price +
            ", color='" + color + '\'' +
            ", sellerNames=" + Arrays.toString(sellerNames) +
            '}';
    }
}
