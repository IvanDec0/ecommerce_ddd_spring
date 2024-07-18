package com.ecommerce_learning.ecommerce_learning.application.web.user.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
public class UserRequest {
    @NotNull(message = "Name is required")
    @NotBlank(message = "Name is required")
    @NotEmpty(message = "Name is required")
    private String name;

    @NotNull(message = "Username is required")
    @NotBlank(message = "Username is required")
    @NotEmpty(message = "Username is required")
    private String username;

    @NotNull(message = "Email is required")
    @NotBlank(message = "Email is required")
    @NotEmpty(message = "Email is required")
    private String email;

    @NotNull(message = "Address is required")
    @NotBlank(message = "Address is required")
    @NotEmpty(message = "Address is required")
    private String address;

    @NotNull(message = "Phone is required")
    @NotBlank(message = "Phone is required")
    @NotEmpty(message = "Phone is required")
    private String phone;

    private String typo;

    @NotNull(message = "Password is required")
    @NotBlank(message = "Password is required")
    @NotEmpty(message = "Password is required")
    private String password;

    // private List<OrderDto> orders = new ArrayList<>();

    // private List<ProductDto> products = new ArrayList<>();
}
