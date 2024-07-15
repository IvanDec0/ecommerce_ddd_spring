package com.ecommerce_learning.ecommerce_learning.domain.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private String id;
    private String name;
    private String username;
    private String email;
    private String address;
    private String phone;
    private String typo;
    private String password;

    private List<Order> orders = new ArrayList<>();

    private List<Product> products = new ArrayList<>();
}
