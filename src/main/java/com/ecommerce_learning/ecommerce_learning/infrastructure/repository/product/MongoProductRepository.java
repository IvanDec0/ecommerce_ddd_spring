package com.ecommerce_learning.ecommerce_learning.infrastructure.repository.product;

import com.ecommerce_learning.ecommerce_learning.infrastructure.entity.ProductDB;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoProductRepository extends MongoRepository<ProductDB, String> {

    Boolean existsByName(String name);
}
