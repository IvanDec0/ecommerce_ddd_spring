package com.ecommerce_learning.ecommerce_learning.infrastructure.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "products")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String description;
    private double price;
    private String image;
    private int stock;

    @DBRef
    private UserDB seller;

    @DBRef
    private List<DetailOrderDB> detailOrders = new ArrayList<>();
}
