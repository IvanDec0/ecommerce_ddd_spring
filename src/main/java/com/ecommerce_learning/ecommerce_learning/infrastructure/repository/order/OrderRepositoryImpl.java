package com.ecommerce_learning.ecommerce_learning.infrastructure.repository.order;

import com.ecommerce_learning.ecommerce_learning.domain.repository.OrderRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderRepositoryImpl implements OrderRepository {

    private MongoOrderRepository mongoOrderRepository;

    public OrderRepositoryImpl(MongoOrderRepository mongoOrderRepository) {
        this.mongoOrderRepository = mongoOrderRepository;
    }
}
