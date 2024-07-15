package com.ecommerce_learning.ecommerce_learning.application.web.product.request;

import com.ecommerce_learning.ecommerce_learning.application.web.user.response.UserResponse;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String name;
    private String description;
    private double price;
    private String image;
    private int stock;
    private UserResponse seller;
    // private List<DetailOrderDto> detailOrders = new ArrayList<>();
}
