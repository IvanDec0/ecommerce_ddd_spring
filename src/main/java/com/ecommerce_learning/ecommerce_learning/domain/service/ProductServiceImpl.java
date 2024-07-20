package com.ecommerce_learning.ecommerce_learning.domain.service;

import com.ecommerce_learning.ecommerce_learning.domain.model.Product;
import com.ecommerce_learning.ecommerce_learning.domain.repository.ProductRepository;
import com.ecommerce_learning.ecommerce_learning.domain.service.interfaces.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) {
        if (productRepository.existsById(product.getId()) || productRepository.existsByName(product.getName())) {
            throw new RuntimeException("Product already exist");
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productExisted = productRepository.findById(product.getId()).orElseThrow(() -> new RuntimeException("Product not found"));
        productExisted.setName(product.getName());
        productExisted.setPrice(product.getPrice());
        productExisted.setDescription(product.getDescription());
        productExisted.setImage(product.getImage());
        productExisted.setStock(product.getStock());
        if (productRepository.existsByName(product.getName())) {
            throw new RuntimeException("Product already exist");
        }
        return productRepository.save(productExisted);
    }

    @Override
    public void deleteProduct(String id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);
    }

    @Override
    public Product getProduct(String id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
