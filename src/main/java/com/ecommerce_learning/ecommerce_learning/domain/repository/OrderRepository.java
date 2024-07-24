package com.ecommerce_learning.ecommerce_learning.domain.repository;

import com.ecommerce_learning.ecommerce_learning.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);

    void deleteById(String id);

    Optional<Order> findById(String id);

    List<Order> findAll();

    Boolean existsById(String id);

    Boolean existsByOrderNumber(String orderNumber);

    Order update(Order order);
}
