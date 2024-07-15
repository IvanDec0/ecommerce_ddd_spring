package com.ecommerce_learning.ecommerce_learning.application.web.product.response;

import com.ecommerce_learning.ecommerce_learning.application.web.detailOrder.response.DetailOrderResponse;
import com.ecommerce_learning.ecommerce_learning.application.web.user.response.UserResponse;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private String id;
    private String name;
    private String description;
    private double price;
    private String image;
    private int stock;
    private UserResponse seller;
    private List<DetailOrderResponse> detailOrders = new ArrayList<>();
}
