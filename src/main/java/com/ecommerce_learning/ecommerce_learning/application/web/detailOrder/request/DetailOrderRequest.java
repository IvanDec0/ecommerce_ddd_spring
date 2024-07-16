package com.ecommerce_learning.ecommerce_learning.application.web.detailOrder.request;

import lombok.*;

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
    //private OrderResponse order;
    //private List<ProductResponse> products = new ArrayList<>();
}
