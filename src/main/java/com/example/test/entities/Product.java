package com.example.test.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "subcate_id")
    private SubCategory subCategory;

    @Column(name = "product_name")
    private String name;

    @Column(name = "color")
    private String color;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "sell_price")
    private double sell_price;

    @Column(name = "origin_price")
    private double origin_price;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
}
