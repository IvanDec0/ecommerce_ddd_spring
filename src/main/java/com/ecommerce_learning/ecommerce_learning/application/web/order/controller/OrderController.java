package com.ecommerce_learning.ecommerce_learning.application.web.order.controller;

import com.ecommerce_learning.ecommerce_learning.application.web.order.request.OrderRequest;
import com.ecommerce_learning.ecommerce_learning.application.web.order.response.OrderResponse;
import com.ecommerce_learning.ecommerce_learning.domain.service.interfaces.OrderService;
import com.ecommerce_learning.ecommerce_learning.shared.util.mapper.OrderMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
        return new ResponseEntity<>(orderMapper.toOrderResponse(orderService.createOrder(orderMapper.toOrderEmailUser(orderRequest))), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable String id) {
        return new ResponseEntity<>(orderMapper.toOrderResponse(orderService.getOrderById(id)), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        return new ResponseEntity<>(orderMapper.mapOrders(orderService.getAllOrders()), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderResponse> updateOrder(@PathVariable String id, @RequestBody OrderRequest orderRequest) {
        return new ResponseEntity<>(orderMapper.toOrderResponse(orderService.updateOrder(id, orderMapper.toOrderEmailUser(orderRequest))), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatusCode> deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
