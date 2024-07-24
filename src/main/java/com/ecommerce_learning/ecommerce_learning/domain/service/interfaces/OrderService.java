package com.ecommerce_learning.ecommerce_learning.domain.service.interfaces;

import com.ecommerce_learning.ecommerce_learning.domain.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);

    Order getOrderById(String id);

    List<Order> getAllOrders();

    Order updateOrder(String id, Order order);

    void deleteOrder(String id);
}
