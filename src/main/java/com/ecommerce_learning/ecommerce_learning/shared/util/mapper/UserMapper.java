package com.ecommerce_learning.ecommerce_learning.shared.util.mapper;

import com.ecommerce_learning.ecommerce_learning.application.web.user.request.LoginRequest;
import com.ecommerce_learning.ecommerce_learning.application.web.user.request.UserRequest;
import com.ecommerce_learning.ecommerce_learning.application.web.user.response.UserResponse;
import com.ecommerce_learning.ecommerce_learning.domain.model.LoginUser;
import com.ecommerce_learning.ecommerce_learning.domain.model.User;
import com.ecommerce_learning.ecommerce_learning.infrastructure.entity.UserDB;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final ProductMapper productMapper;
    private final OrderMapper orderMapper;

    public UserMapper(@Lazy ProductMapper productMapper,
                      @Lazy OrderMapper orderMapper) {
        this.productMapper = productMapper;
        this.orderMapper = orderMapper;
    }

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
                .orders(orderMapper.mapOrders(user.getOrders()))
                .products(productMapper.mapProducts(user.getProducts()))
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

    public User toUser(UserResponse user) {
        return User.builder()
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .address(user.getAddress())
                .phone(user.getPhone())
                .typo(user.getTypo())
                .build();
    }

    public LoginUser toLoginUser(LoginRequest loginRequest) {
        return LoginUser.builder()
                .email(loginRequest.getEmail())
                .password(loginRequest.getPassword())
                .build();
    }

    public UserResponse toUserResponse(UserDB userDB) {
        return UserResponse.builder()
                .id(userDB.getId())
                .name(userDB.getName())
                .username(userDB.getUsername())
                .email(userDB.getEmail())
                .address(userDB.getAddress())
                .phone(userDB.getPhone())
                .typo(userDB.getTypo())
                .build();
    }
}