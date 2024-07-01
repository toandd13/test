package com.example.test.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    private String name;

    private String color;

    private int quantity;

    private double sell_price;

    private double origin_price;

    private String description;

}
