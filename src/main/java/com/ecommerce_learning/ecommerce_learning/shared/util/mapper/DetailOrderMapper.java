package com.ecommerce_learning.ecommerce_learning.shared.util.mapper;

import com.ecommerce_learning.ecommerce_learning.application.web.detailOrder.request.DetailOrderRequest;
import com.ecommerce_learning.ecommerce_learning.application.web.detailOrder.response.DetailOrderResponse;
import com.ecommerce_learning.ecommerce_learning.domain.model.DetailOrder;
import com.ecommerce_learning.ecommerce_learning.infrastructure.entity.DetailOrderDB;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DetailOrderMapper {

    private final ProductMapper productMapper;
    private final OrderMapper orderMapper;

    public DetailOrderMapper(@Lazy ProductMapper productMapper,
                             @Lazy OrderMapper orderMapper) {
        this.productMapper = productMapper;
        this.orderMapper = orderMapper;
    }

    public List<DetailOrderResponse> mapDetailOrdersResponse(List<?> detailOrders) {
        if (detailOrders == null) {
            return null;
        }
        List<DetailOrderResponse> detailOrderResponses = new ArrayList<>();
        if (!detailOrders.isEmpty()) {
            Object firstElement = detailOrders.get(0);
            if (firstElement instanceof DetailOrder) {
                for (Object obj : detailOrders) {
                    DetailOrder detailOrder = (DetailOrder) obj;
                    DetailOrderResponse detailOrderResponse = DetailOrderResponse.builder()
                            .id(detailOrder.getId())
                            .products(productMapper.mapProducts(detailOrder.getProducts()))
                            .order(orderMapper.toOrderResponse(detailOrder.getOrder()))
                            .quantity(detailOrder.getQuantity())
                            .total(detailOrder.getTotal())
                            .build();
                    detailOrderResponses.add(detailOrderResponse);
                }
            } else if (firstElement instanceof DetailOrderResponse) {
                for (Object obj : detailOrders) {
                    DetailOrderResponse detailOrderResponse = (DetailOrderResponse) obj;
                    detailOrderResponses.add(detailOrderResponse);
                }
            }
        }
        return detailOrderResponses;
    }

    public DetailOrderResponse toDetailOrderResponse(DetailOrder detailOrder) {
        return DetailOrderResponse.builder()
                .id(detailOrder.getId())
                .products(productMapper.mapProducts(detailOrder.getProducts()))
                .order(orderMapper.toOrderResponse(detailOrder.getOrder()))
                .quantity(detailOrder.getQuantity())
                .total(detailOrder.getTotal())
                .build();
    }

    public DetailOrder toDetailOrder(DetailOrderDB detailOrder) {
        return DetailOrder.builder()
                .id(detailOrder.getId())
                .products(productMapper.mapProductsDBToProduct(detailOrder.getProducts()))
                .order(orderMapper.toOrder(detailOrder.getOrder()))
                .quantity(detailOrder.getQuantity())
                .total(detailOrder.getTotal())
                .build();
    }

    public DetailOrder toDetailOrderNoProdNoOrder(DetailOrderRequest detailOrder) {
        return DetailOrder.builder()
                .name(detailOrder.getName())
                .products(productMapper.mapProductsEmpty(detailOrder.getProducts()))
                .order(orderMapper.toOrderEmpty(detailOrder.getOrderNumber()))
                .quantity(detailOrder.getQuantity())
                .price(detailOrder.getPrice())
                .total(detailOrder.getTotal())
                .build();
    }

    public List<DetailOrder> mapDetailOrders(List<DetailOrderDB> detailOrdersDB) {
        if (detailOrdersDB == null) {
            return null;
        }
        List<DetailOrder> detailOrders = new ArrayList<>();
        for (DetailOrderDB detailOrderDB : detailOrdersDB) {
            DetailOrder detailOrder = DetailOrder.builder()
                    .id(detailOrderDB.getId())
                    .products(productMapper.mapProductsDBToProduct(detailOrderDB.getProducts()))
                    .order(orderMapper.toOrder(detailOrderDB.getOrder()))
                    .quantity(detailOrderDB.getQuantity())
                    .total(detailOrderDB.getTotal())
                    .build();
            detailOrders.add(detailOrder);
        }
        return detailOrders;
    }

    public DetailOrderDB toDetailOrderDB(DetailOrder detailOrder) {
        return DetailOrderDB.builder()
                .id(detailOrder.getId())
                .products(productMapper.mapProductsToProductDB(detailOrder.getProducts()))
                .order(orderMapper.toOrderDB(detailOrder.getOrder()))
                .quantity(detailOrder.getQuantity())
                .total(detailOrder.getTotal())
                .build();
    }

    public List<DetailOrderDB> mapDetailOrdersDB(List<DetailOrder> detailOrders) {
        if (detailOrders == null) {
            return null;
        }
        List<DetailOrderDB> detailOrdersDB = new ArrayList<>();
        for (DetailOrder detailOrder : detailOrders) {
            DetailOrderDB detailOrderDB = DetailOrderDB.builder()
                    .id(detailOrder.getId())
                    .products(productMapper.mapProductsToProductDB(detailOrder.getProducts()))
                    .order(orderMapper.toOrderDB(detailOrder.getOrder()))
                    .quantity(detailOrder.getQuantity())
                    .total(detailOrder.getTotal())
                    .build();
            detailOrdersDB.add(detailOrderDB);
        }
        return detailOrdersDB;
    }
}
