package com.ecommerce_learning.ecommerce_learning.domain.service;

import com.ecommerce_learning.ecommerce_learning.domain.model.Product;
import com.ecommerce_learning.ecommerce_learning.domain.repository.ProductRepository;
import com.ecommerce_learning.ecommerce_learning.domain.service.interfaces.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ecommerce_learning.ecommerce_learning.shared.util.ReturnConstants.*;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) {
        if (productRepository.existsById(product.getId()) || productRepository.existsByName(product.getName())) {
            throw new RuntimeException(String.format(PRODUCT_ID_EXISTS, product.getId()));
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(String id, Product product) {
        Product productExisted = productRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format(PRODUCT_NOT_FOUND, id)));
        productExisted.setName(product.getName());
        productExisted.setPrice(product.getPrice());
        productExisted.setDescription(product.getDescription());
        productExisted.setImage(product.getImage());
        productExisted.setStock(product.getStock());
        if (productRepository.existsByName(product.getName())) {
            throw new RuntimeException(String.format(PRODUCT_NAME_EXISTS, product.getName()));
        }
        return productRepository.update(productExisted);
    }

    @Override
    public void deleteProduct(String id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException(String.format(PRODUCT_NOT_FOUND, id));
        }
        productRepository.deleteById(id);
    }

    @Override
    public Product getProduct(String id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format(PRODUCT_NOT_FOUND, id)));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
