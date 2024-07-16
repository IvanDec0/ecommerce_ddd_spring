package com.ecommerce_learning.ecommerce_learning.shared.util.mapper;

import com.ecommerce_learning.ecommerce_learning.application.web.detailOrder.response.DetailOrderResponse;
import com.ecommerce_learning.ecommerce_learning.domain.model.DetailOrder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DetailOrderMapper {

    private final ProductMapper productMapper;
    private final OrderMapper orderMapper;

    public DetailOrderMapper(ProductMapper productMapper, OrderMapper orderMapper) {
        this.productMapper = productMapper;
        this.orderMapper = orderMapper;
    }

    public List<DetailOrderResponse> mapDetailOrders(List<?> detailOrders) {
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

}
