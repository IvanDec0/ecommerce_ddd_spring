package com.ecommerce_learning.ecommerce_learning.application.web.product.controller;

import com.ecommerce_learning.ecommerce_learning.application.web.product.request.ProductRequest;
import com.ecommerce_learning.ecommerce_learning.application.web.product.response.ProductResponse;
import com.ecommerce_learning.ecommerce_learning.domain.service.interfaces.ProductService;
import com.ecommerce_learning.ecommerce_learning.shared.util.mapper.ProductMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest product) {
        return ResponseEntity.ok(productMapper.toProductResponse(productService.addProduct(productMapper.toProduct(product))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable String id, @RequestBody ProductRequest product) {
        return ResponseEntity.ok(productMapper.toProductResponse(productService.updateProduct(id, productMapper.toProduct(product))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatusCode> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable String id) {
        return ResponseEntity.ok(productMapper.toProductResponse(productService.getProduct(id)));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productMapper.mapProducts(productService.getAllProducts()));
    }

}
