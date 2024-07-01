package com.example.test.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

    private int id;

    private String name;

    private String color;

    private int quantity;

    private double sell_price;

    private double origin_price;

    private String description;
}
