package com.ecommerce_learning.ecommerce_learning.application.web.detail_order.request;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailOrderRequest {
    private String name;
    private double price;
    private double quantity;
    private double total;
    private String orderNumber; // OrderNumber (Change to OrderId?)
    private List<String> products = new ArrayList<>(); // List of product ids
}
