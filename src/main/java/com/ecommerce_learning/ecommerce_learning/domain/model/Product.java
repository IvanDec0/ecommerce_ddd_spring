package com.ecommerce_learning.ecommerce_learning.domain.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String id;
    private String name;
    private String description;
    private double price;
    private String image;
    private int stock;
    private User seller;
    private List<DetailOrder> detailOrders = new ArrayList<>();
}
