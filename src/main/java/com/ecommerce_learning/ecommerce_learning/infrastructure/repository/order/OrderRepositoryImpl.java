package com.ecommerce_learning.ecommerce_learning.infrastructure.repository.order;

import com.ecommerce_learning.ecommerce_learning.domain.model.Order;
import com.ecommerce_learning.ecommerce_learning.domain.repository.OrderRepository;
import com.ecommerce_learning.ecommerce_learning.infrastructure.entity.OrderDB;
import com.ecommerce_learning.ecommerce_learning.shared.util.mapper.OrderMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderRepositoryImpl implements OrderRepository {

    private final MongoOrderRepository mongoOrderRepository;
    private final OrderMapper mapper;

    public OrderRepositoryImpl(MongoOrderRepository mongoOrderRepository, OrderMapper mapper) {
        this.mongoOrderRepository = mongoOrderRepository;
        this.mapper = mapper;
    }

    @Override
    public Order save(Order order) {
        OrderDB orderDB = mapper.toOrderDB(order);
        OrderDB savedOrderDB = mongoOrderRepository.save(orderDB);
        return mapper.toOrder(savedOrderDB);
    }

    @Override
    public void deleteById(String id) {
        mongoOrderRepository.deleteById(id);
    }

    @Override
    public Optional<Order> findById(String id) {
        return mongoOrderRepository.findById(id).map(mapper::toOrder);
    }

    @Override
    public List<Order> findAll() {
        return mapper.mapOrdersDBtoOrders(mongoOrderRepository.findAll());
    }

    @Override
    public Boolean existsById(String id) {
        return mongoOrderRepository.existsById(id);
    }

    @Override
    public Boolean existsByOrderNumber(String orderNumber) {
        return mongoOrderRepository.existsByOrderNumber(orderNumber);
    }

    @Override
    public Order update(Order order) {
        OrderDB orderDB = mapper.toOrderDB(order);
        OrderDB updatedOrderDB = mongoOrderRepository.save(orderDB);
        return mapper.toOrder(updatedOrderDB);
    }
}