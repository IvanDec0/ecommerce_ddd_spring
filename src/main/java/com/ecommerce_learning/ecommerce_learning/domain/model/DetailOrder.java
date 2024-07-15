package com.ecommerce_learning.ecommerce_learning.domain.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailOrder {

    private String id;
    private String name;
    private double price;
    private double quantity;
    private double total;
    private Order order;
    private List<Product> products = new ArrayList<>();
}
