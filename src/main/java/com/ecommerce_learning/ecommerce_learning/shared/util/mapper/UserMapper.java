package com.ecommerce_learning.ecommerce_learning.shared.util.mapper;

import com.ecommerce_learning.ecommerce_learning.application.web.order.response.OrderResponse;
import com.ecommerce_learning.ecommerce_learning.application.web.product.response.ProductResponse;
import com.ecommerce_learning.ecommerce_learning.application.web.user.request.UserRequest;
import com.ecommerce_learning.ecommerce_learning.application.web.user.response.UserResponse;
import com.ecommerce_learning.ecommerce_learning.domain.model.Order;
import com.ecommerce_learning.ecommerce_learning.domain.model.Product;
import com.ecommerce_learning.ecommerce_learning.domain.model.User;
import com.ecommerce_learning.ecommerce_learning.infrastructure.entity.UserDB;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public User toUser(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.getName())
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .address(userRequest.getAddress())
                .phone(userRequest.getPhone())
                .typo(userRequest.getTypo())
                .password(userRequest.getPassword())
                .build();
    }

    public UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .address(user.getAddress())
                .phone(user.getPhone())
                .typo(user.getTypo())
                .orders(mapOrders(user.getOrders()))
                .products(mapProducts(user.getProducts()))
                .build();
    }

    public UserDB toMongoUser(User user) {
        return UserDB.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .address(user.getAddress())
                .phone(user.getPhone())
                .typo(user.getTypo())
                .password(user.getPassword())
                .build();
    }

    public User toUser(UserDB userDB) {
        return User.builder()
                .id(userDB.getId())
                .name(userDB.getName())
                .username(userDB.getUsername())
                .email(userDB.getEmail())
                .address(userDB.getAddress())
                .phone(userDB.getPhone())
                .typo(userDB.getTypo())
                .password(userDB.getPassword())
                .build();
    }

    private List<OrderResponse> mapOrders(List<Order> orders) {
        // Implement the mapping logic
        return new ArrayList<>();
    }

    private List<ProductResponse> mapProducts(List<Product> products) {
        // Implement the mapping logic
        return new ArrayList<>();
    }
}