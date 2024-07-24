package com.ecommerce_learning.ecommerce_learning.shared.util.mapper;

import com.ecommerce_learning.ecommerce_learning.application.web.order.request.OrderRequest;
import com.ecommerce_learning.ecommerce_learning.application.web.order.response.OrderResponse;
import com.ecommerce_learning.ecommerce_learning.domain.model.Order;
import com.ecommerce_learning.ecommerce_learning.infrastructure.entity.OrderDB;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {

    private final UserMapper userMapper;
    private final DetailOrderMapper detailOrderMapper;

    public OrderMapper(@Lazy UserMapper userMapper,
                       @Lazy DetailOrderMapper detailOrderMapper) {
        this.userMapper = userMapper;
        this.detailOrderMapper = detailOrderMapper;
    }

    public Order toOrderEmailUser(OrderRequest orderRequest) {
        return Order.builder()
                .id(orderRequest.getOrderNumber())
                .orderDate(orderRequest.getOrderDate())
                .orderShippedDate(orderRequest.getOrderShippedDate())
                .orderStatus(orderRequest.getOrderStatus())
                .orderTotal(orderRequest.getOrderTotal())
                .user(userMapper.toUserEmail(orderRequest.getUser()))
                .build();
    }

    public Order toOrder(OrderDB orderDB) {
        return Order.builder()
                .id(orderDB.getOrderNumber())
                .orderDate(orderDB.getOrderDate())
                .orderShippedDate(orderDB.getOrderShippedDate())
                .orderStatus(orderDB.getOrderStatus())
                .orderTotal(orderDB.getOrderTotal())
                .user(userMapper.toUser(orderDB.getUser()))
                .build();
    }

    public OrderDB toOrderDB(Order order) {
        return OrderDB.builder()
                .orderNumber(order.getId())
                .orderDate(order.getOrderDate())
                .orderShippedDate(order.getOrderShippedDate())
                .orderStatus(order.getOrderStatus())
                .orderTotal(order.getOrderTotal())
                .user(userMapper.toMongoUser(order.getUser()))
                .build();
    }

    public OrderRequest toOrderRequest(Order order) {
        return OrderRequest.builder()
                .orderNumber(order.getId())
                .orderDate(order.getOrderDate())
                .orderShippedDate(order.getOrderShippedDate())
                .orderStatus(order.getOrderStatus())
                .orderTotal(order.getOrderTotal())
                .user(order.getUser().getEmail())
                .build();
    }

    public List<OrderResponse> mapOrders(List<Order> orders) {
        if (orders == null) {
            return null;
        }
        List<OrderResponse> orderResponses = new ArrayList<>();
        for (Order order : orders) {
            OrderResponse orderResponse = OrderResponse.builder()
                    .id(order.getId())
                    .user(userMapper.toUserResponse(order.getUser()))
                    .orderNumber(order.getOrderNumber())
                    .orderDate(order.getOrderDate())
                    .orderShippedDate(order.getOrderShippedDate())
                    .orderTotal(order.getOrderTotal())
                    .orderStatus(order.getOrderStatus())
                    .detailOrder(detailOrderMapper.toDetailOrderResponse(order.getDetailOrder())) // Implement the mapping logic
                    .build();
            orderResponses.add(orderResponse);
        }
        return orderResponses;
    }

    public List<Order> mapOrdersDBtoOrders(List<OrderDB> ordersDB) {
        if (ordersDB == null) {
            return null;
        }
        List<Order> orders = new ArrayList<>();
        for (OrderDB orderDB : ordersDB) {
            Order order = Order.builder()
                    .id(orderDB.getId())
                    .user(userMapper.toUser(orderDB.getUser()))
                    .orderNumber(orderDB.getOrderNumber())
                    .orderDate(orderDB.getOrderDate())
                    .orderShippedDate(orderDB.getOrderShippedDate())
                    .orderTotal(orderDB.getOrderTotal())
                    .orderStatus(orderDB.getOrderStatus())
                    .detailOrder(detailOrderMapper.toDetailOrder(orderDB.getDetailOrder())) // Implement the mapping logic
                    .build();
            orders.add(order);
        }
        return orders;
    }

    public OrderResponse toOrderResponse(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .user(userMapper.toUserResponse(order.getUser()))
                .orderNumber(order.getOrderNumber())
                .orderDate(order.getOrderDate())
                .orderShippedDate(order.getOrderShippedDate())
                .orderTotal(order.getOrderTotal())
                .orderStatus(order.getOrderStatus())
                .detailOrder(detailOrderMapper.toDetailOrderResponse(order.getDetailOrder())) // Implement the mapping logic
                .build();
    }

    public Order toOrderEmpty(String orderNumber) {
        return Order.builder()
                .id(orderNumber)
                .build();
    }
}
