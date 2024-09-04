package com.zip.Product.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private String type;
    private Integer quantity;
    private Integer price;
    private String requirements;
}
