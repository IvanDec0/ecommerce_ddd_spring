package com.ecommerce_learning.ecommerce_learning.infrastructure.repository.product;

import com.ecommerce_learning.ecommerce_learning.domain.model.Product;
import com.ecommerce_learning.ecommerce_learning.domain.repository.ProductRepository;
import com.ecommerce_learning.ecommerce_learning.infrastructure.entity.ProductDB;
import com.ecommerce_learning.ecommerce_learning.shared.util.mapper.ProductMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    private final MongoProductRepository mongoProductRepository;
    private final ProductMapper mapper;

    public ProductRepositoryImpl(MongoProductRepository mongoProductRepository, ProductMapper mapper) {
        this.mongoProductRepository = mongoProductRepository;
        this.mapper = mapper;
    }

    @Override
    public Product save(Product product) {
        ProductDB productDB = mapper.toMongoProduct(product);
        ProductDB savedProductDB = mongoProductRepository.save(productDB);
        return mapper.toProduct(savedProductDB);
    }

    @Override
    public void deleteById(String id) {
        mongoProductRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(String id) {
        return mongoProductRepository.findById(id).map(mapper::toProduct);
    }

    @Override
    public List<Product> findAll() {
        return mapper.mapProductsDBToProduct(mongoProductRepository.findAll());
    }

    @Override
    public Boolean existsById(String id) {
        return mongoProductRepository.existsById(id);
    }

    @Override
    public Boolean existsByName(String name) {
        return mongoProductRepository.existsByName(name);
    }
}
