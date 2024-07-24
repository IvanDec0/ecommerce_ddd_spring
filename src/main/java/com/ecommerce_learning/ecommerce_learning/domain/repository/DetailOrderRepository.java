package com.ecommerce_learning.ecommerce_learning.domain.repository;

import com.ecommerce_learning.ecommerce_learning.domain.model.DetailOrder;

import java.util.List;
import java.util.Optional;

public interface DetailOrderRepository {
    DetailOrder save(DetailOrder detailOrder);

    void deleteById(String id);

    Optional<DetailOrder> findById(String id);

    List<DetailOrder> findAll();

    Boolean existsById(String id);

    DetailOrder update(DetailOrder detailOrder);

    Optional<DetailOrder> findByOrderNumber(String orderNumber);
}
