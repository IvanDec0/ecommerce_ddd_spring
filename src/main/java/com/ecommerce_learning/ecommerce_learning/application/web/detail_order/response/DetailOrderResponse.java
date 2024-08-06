package com.ecommerce_learning.ecommerce_learning.application.web.detail_order.response;

import com.ecommerce_learning.ecommerce_learning.application.web.order.response.OrderResponse;
import com.ecommerce_learning.ecommerce_learning.application.web.product.response.ProductResponse;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailOrderResponse {

    private String id;
    private String name;
    private double price;
    private double quantity;
    private double total;
    private OrderResponse order;
    private List<ProductResponse> products = new ArrayList<>();
}
