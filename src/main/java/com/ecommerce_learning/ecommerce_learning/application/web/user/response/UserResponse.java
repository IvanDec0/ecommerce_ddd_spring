package com.ecommerce_learning.ecommerce_learning.application.web.user.response;

import com.ecommerce_learning.ecommerce_learning.application.web.order.response.OrderResponse;
import com.ecommerce_learning.ecommerce_learning.application.web.product.response.ProductResponse;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private String id;
    private String name;
    private String username;
    private String email;
    private String address;
    private String phone;
    private String typo;

    private List<OrderResponse> orders = new ArrayList<>();

    private List<ProductResponse> products = new ArrayList<>();
}
