package com.ecommerce_learning.ecommerce_learning.domain.service;

import com.ecommerce_learning.ecommerce_learning.domain.model.Order;
import com.ecommerce_learning.ecommerce_learning.domain.model.User;
import com.ecommerce_learning.ecommerce_learning.domain.repository.OrderRepository;
import com.ecommerce_learning.ecommerce_learning.domain.repository.UserRepository;
import com.ecommerce_learning.ecommerce_learning.domain.service.interfaces.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Order createOrder(Order order) {
        if (orderRepository.existsByOrderNumber(order.getOrderNumber())) {
            throw new IllegalArgumentException("Order with order number " + order.getOrderNumber() + " already exists");
        }
        User user = userRepository.findByEmail(order.getUser().getEmail()).orElseThrow(() -> new IllegalArgumentException("User with email " + order.getUser().getEmail() + " not found"));
        order.setUser(user);
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(String id) {
        return orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Order with id " + id + " not found"));
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(String id, Order order) {
        Order orderExisted = orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Order with id " + id + " not found"));
        if (orderRepository.existsByOrderNumber(order.getOrderNumber())) {
            throw new IllegalArgumentException("Order with order number " + order.getOrderNumber() + " already exists");
        }
        orderExisted.setOrderNumber(order.getOrderNumber());
        orderExisted.setOrderDate(order.getOrderDate());
        orderExisted.setOrderShippedDate(order.getOrderShippedDate());
        orderExisted.setOrderStatus(order.getOrderStatus());
        orderExisted.setOrderTotal(order.getOrderTotal());
        User user = userRepository.findByEmail(order.getUser().getEmail()).orElseThrow(() -> new IllegalArgumentException("User with email " + order.getUser().getEmail() + " not found"));
        orderExisted.setUser(user);
        // orderExisted.setDetailOrder(order.getDetailOrder());
        return orderRepository.update(orderExisted);

    }

    @Override
    public void deleteOrder(String id) {
        if (!orderRepository.existsById(id)) {
            throw new IllegalArgumentException("Order with id " + id + " not found");
        }
        orderRepository.deleteById(id);
    }
}
