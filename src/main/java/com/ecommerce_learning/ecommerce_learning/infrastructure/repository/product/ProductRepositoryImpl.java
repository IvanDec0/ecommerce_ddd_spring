package com.ecommerce_learning.ecommerce_learning.infrastructure.repository.product;

import com.ecommerce_learning.ecommerce_learning.domain.repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    private MongoProductRepository mongoProductRepository;

    public ProductRepositoryImpl(MongoProductRepository mongoProductRepository) {
        this.mongoProductRepository = mongoProductRepository;
    }
}
