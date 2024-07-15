package com.ecommerce_learning.ecommerce_learning.application.web.user.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    private String name;
    private String username;
    private String email;
    private String address;
    private String phone;
    private String typo;
    private String password;

    // private List<OrderDto> orders = new ArrayList<>();

    // private List<ProductDto> products = new ArrayList<>();
}
