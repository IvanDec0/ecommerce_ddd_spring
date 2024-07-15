package com.ecommerce_learning.ecommerce_learning.infrastructure.repository.order;

import com.ecommerce_learning.ecommerce_learning.infrastructure.entity.OrderDB;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoOrderRepository extends MongoRepository<OrderDB, String> {
}
