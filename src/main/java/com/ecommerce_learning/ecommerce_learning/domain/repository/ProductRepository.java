package com.ecommerce_learning.ecommerce_learning.domain.repository;

import com.ecommerce_learning.ecommerce_learning.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);

    void deleteById(String id);

    Optional<Product> findById(String id);

    List<Product> findAll();

    Boolean existsById(String id);

    Boolean existsByName(String name);

    Product update(Product product);

    List<Product> findAllById(List<String> list);
}
