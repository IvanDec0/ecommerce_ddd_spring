package com.ecommerce_learning.ecommerce_learning.domain.service.interfaces;

import com.ecommerce_learning.ecommerce_learning.domain.model.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(String id);
    Product getProduct(String id);
    List<Product> getAllProducts();
}
