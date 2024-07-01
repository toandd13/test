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
@Table(name = "sub_category")
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sub_cate_code")
    private String sub_cate_code;

    @Column(name = "sub_cate_name")
    private String sub_cate_name;

    @ManyToOne
    @JoinColumn(name = "cate_id")
    private Category category;
}

