package com.ecommerce_learning.ecommerce_learning.infrastructure.repository.detailOrder;

import com.ecommerce_learning.ecommerce_learning.domain.repository.DetailOrderRepository;
import org.springframework.stereotype.Component;

@Component
public class DetailOrderRepositoryImpl implements DetailOrderRepository {

    private final MongoDetailOrderRepository mongoDetailOrderRepository;

    public DetailOrderRepositoryImpl(MongoDetailOrderRepository mongoDetailOrderRepository) {
        this.mongoDetailOrderRepository = mongoDetailOrderRepository;
    }
}
