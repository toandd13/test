package com.example.test.entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_brand")

public class ProductBrand {
    @OneToMany
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
