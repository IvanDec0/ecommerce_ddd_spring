package com.ecommerce_learning.ecommerce_learning.infrastructure.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String username;
    private String email;
    private String address;
    private String phone;
    private String typo;
    private String password;

    @DBRef
    private List<OrderDB> orders = new ArrayList<>();

    @DBRef
    private List<ProductDB> products = new ArrayList<>();
}
