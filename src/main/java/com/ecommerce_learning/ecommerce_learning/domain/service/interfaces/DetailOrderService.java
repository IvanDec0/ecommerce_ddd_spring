package com.ecommerce_learning.ecommerce_learning.domain.service.interfaces;

import com.ecommerce_learning.ecommerce_learning.domain.model.DetailOrder;

import java.util.List;

public interface DetailOrderService {

    DetailOrder addDetailOrder(DetailOrder detailOrder);

    DetailOrder updateDetailOrder(String id, DetailOrder detailOrder);

    void deleteDetailOrder(String id);

    DetailOrder getDetailOrder(String id);

    List<DetailOrder> getAllDetailOrder();
}
