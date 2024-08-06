package com.ecommerce_learning.ecommerce_learning.shared.util.mapper;

import com.ecommerce_learning.ecommerce_learning.application.web.product.request.ProductRequest;
import com.ecommerce_learning.ecommerce_learning.application.web.product.response.ProductResponse;
import com.ecommerce_learning.ecommerce_learning.domain.model.Product;
import com.ecommerce_learning.ecommerce_learning.infrastructure.entity.ProductDB;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {

    private final UserMapper userMapper;
    private final DetailOrderMapper detailOrderMapper;

    public ProductMapper(@Lazy UserMapper userMapper,
                         @Lazy DetailOrderMapper detailOrderMapper) {
        this.userMapper = userMapper;
        this.detailOrderMapper = detailOrderMapper;
    }

    public Product toProduct(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .stock(productRequest.getStock())
                .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .detailOrders(detailOrderMapper.mapDetailOrdersResponse(product.getDetailOrders()))
                .build();
    }

    public ProductDB toMongoProduct(Product product) {
        return ProductDB.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }

    public Product toProduct(ProductDB productDB) {
        return Product.builder()
                .id(productDB.getId())
                .name(productDB.getName())
                .description(productDB.getDescription())
                .price(productDB.getPrice())
                .stock(productDB.getStock())
                .build();
    }

    public List<ProductResponse> mapProducts(List<?> products) {
        if (products == null) {
            return null;
        }
        List<ProductResponse> productResponses = new ArrayList<>();
        if (!products.isEmpty()) {
            Object firstElement = products.get(0);
            if (firstElement instanceof Product) {
                mapProductList(products, productResponses);
            } else if (firstElement instanceof ProductResponse) {
                mapProductResponseList(products, productResponses);
            }
        }
        return productResponses;
    }

    private void mapProductList(List<?> products, List<ProductResponse> productResponses) {
        for (Object obj : products) {
            Product product = (Product) obj;
            ProductResponse productResponse = ProductResponse.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .stock(product.getStock())
                    .image(product.getImage())
                    .seller(product.getSeller() == null ? null : userMapper.toUserResponse(product.getSeller()))
                    .detailOrders(product.getDetailOrders() == null ? null : detailOrderMapper.mapDetailOrdersResponse(product.getDetailOrders()))
                    .build();
            productResponses.add(productResponse);
        }
    }

    private void mapProductResponseList(List<?> products, List<ProductResponse> productResponses) {
        for (Object obj : products) {
            ProductResponse productResponse = (ProductResponse) obj;
            // Perform any necessary operations on ProductResponse objects
            productResponses.add(productResponse);
        }
    }

    public List<Product> mapProductsDBToProduct(List<ProductDB> productsDB) {
        if (productsDB == null) {
            return null;
        }
        List<Product> products = new ArrayList<>();
        for (ProductDB prod : productsDB) {
            Product product = Product.builder()
                    .id(prod.getId())
                    .name(prod.getName())
                    .description(prod.getDescription())
                    .price(prod.getPrice())
                    .stock(prod.getStock())
                    .image(prod.getImage())
                    .seller(prod.getSeller() == null ? null : userMapper.toUser(prod.getSeller()))
                    .detailOrders(prod.getDetailOrders() == null ? null : detailOrderMapper.mapDetailOrders(prod.getDetailOrders()))
                    .build();
            products.add(product);
        }
        return products;
    }

    public List<ProductDB> mapProductsToProductDB(List<Product> products) {
        if (products == null) {
            return null;
        }
        List<ProductDB> productsDB = new ArrayList<>();
        for (Product prod : products) {
            ProductDB product = ProductDB.builder()
                    .id(prod.getId())
                    .name(prod.getName())
                    .description(prod.getDescription())
                    .price(prod.getPrice())
                    .stock(prod.getStock())
                    .image(prod.getImage())
                    .seller(prod.getSeller() == null ? null : userMapper.toMongoUser(prod.getSeller()))
                    .detailOrders(prod.getDetailOrders() == null ? null : detailOrderMapper.mapDetailOrdersDB(prod.getDetailOrders()))
                    .build();
            productsDB.add(product);
        }
        return productsDB;
    }

    public List<Product> mapProductsEmpty(List<String> products) {
        if (products == null) {
            return null;
        }
        List<Product> productResponses = new ArrayList<>();
        for (String product : products) {
            Product productResponse = Product.builder()
                    .id(product)
                    .build();
            productResponses.add(productResponse);
        }
        return productResponses;
    }
}
