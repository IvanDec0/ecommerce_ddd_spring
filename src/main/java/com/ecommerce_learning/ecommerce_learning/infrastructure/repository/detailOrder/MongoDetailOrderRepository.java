package com.ecommerce_learning.ecommerce_learning.infrastructure.repository.detailOrder;

import com.ecommerce_learning.ecommerce_learning.infrastructure.entity.DetailOrderDB;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoDetailOrderRepository extends MongoRepository<DetailOrderDB, String> {
}
