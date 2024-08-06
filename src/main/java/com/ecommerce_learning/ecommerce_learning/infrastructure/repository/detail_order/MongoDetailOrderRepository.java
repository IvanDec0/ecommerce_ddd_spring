package com.ecommerce_learning.ecommerce_learning.infrastructure.repository.detail_order;

import com.ecommerce_learning.ecommerce_learning.infrastructure.entity.DetailOrderDB;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MongoDetailOrderRepository extends MongoRepository<DetailOrderDB, String> {
    @Query("{ 'order.orderNumber' : ?0 }")
    Optional<DetailOrderDB> findByOrderNumber(String orderNumber);
}
