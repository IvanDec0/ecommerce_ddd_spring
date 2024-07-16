package com.ecommerce_learning.ecommerce_learning.shared.util.mapper;

import com.ecommerce_learning.ecommerce_learning.application.web.product.request.ProductRequest;
import com.ecommerce_learning.ecommerce_learning.application.web.product.response.ProductResponse;
import com.ecommerce_learning.ecommerce_learning.domain.model.Product;
import com.ecommerce_learning.ecommerce_learning.infrastructure.entity.ProductDB;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {

    private final UserMapper userMapper;
    private final OrderMapper orderMapper;
    private final DetailOrderMapper detailOrderMapper;

    public ProductMapper(UserMapper userMapper, OrderMapper orderMapper, DetailOrderMapper detailOrderMapper) {
        this.userMapper = userMapper;
        this.orderMapper = orderMapper;
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
                .detailOrders(detailOrderMapper.mapDetailOrders(product.getDetailOrders()))
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
        List<ProductResponse> productResponses = new ArrayList<>();
        if (!products.isEmpty()) {
            Object firstElement = products.get(0);
            if (firstElement instanceof Product) {
                for (Object obj : products) {
                    Product product = (Product) obj;
                    ProductResponse productResponse = ProductResponse.builder()
                            .id(product.getId())
                            .name(product.getName())
                            .description(product.getDescription())
                            .price(product.getPrice())
                            .stock(product.getStock())
                            .image(product.getImage())
                            .seller(userMapper.toUserResponse(product.getSeller()))
                            .detailOrders(detailOrderMapper.mapDetailOrders(product.getDetailOrders()))
                            .build();
                    productResponses.add(productResponse);
                }
            } else if (firstElement instanceof ProductResponse) {
                // Assuming you want to directly add ProductResponse objects to the list
                // or perform some operations on them before adding
                for (Object obj : products) {
                    ProductResponse productResponse = (ProductResponse) obj;
                    // Perform any necessary operations on ProductResponse objects
                    productResponses.add(productResponse);
                }
            }
        }
        return productResponses;
    }
}
