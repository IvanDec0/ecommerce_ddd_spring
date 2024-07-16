package com.ecommerce_learning.ecommerce_learning.shared.util.mapper;

import com.ecommerce_learning.ecommerce_learning.application.web.order.request.OrderRequest;
import com.ecommerce_learning.ecommerce_learning.application.web.order.response.OrderResponse;
import com.ecommerce_learning.ecommerce_learning.domain.model.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {

    private final UserMapper userMapper;
    private final DetailOrderMapper detailOrderMapper;

    public OrderMapper(UserMapper userMapper, DetailOrderMapper detailOrderMapper) {
        this.userMapper = userMapper;
        this.detailOrderMapper = detailOrderMapper;
    }

    public Order toOrder(OrderRequest orderRequest) {
        return Order.builder()
                .id(orderRequest.getOrderNumber())
                .orderDate(orderRequest.getOrderDate())
                .orderShippedDate(orderRequest.getOrderShippedDate())
                .orderStatus(orderRequest.getOrderStatus())
                .orderTotal(orderRequest.getOrderTotal())
                .user(userMapper.toUser(orderRequest.getUser()))
                .build();
    }

    public OrderRequest toOrderRequest(Order order) {
        return OrderRequest.builder()
                .orderNumber(order.getId())
                .orderDate(order.getOrderDate())
                .orderShippedDate(order.getOrderShippedDate())
                .orderStatus(order.getOrderStatus())
                .orderTotal(order.getOrderTotal())
                .user(userMapper.toUserResponse(order.getUser()))
                .build();
    }

    public List<OrderResponse> mapOrders(List<Order> orders) {
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
}
