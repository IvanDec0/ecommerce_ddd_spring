package com.ecommerce_learning.ecommerce_learning.infrastructure.repository.detailOrder;

import com.ecommerce_learning.ecommerce_learning.domain.model.DetailOrder;
import com.ecommerce_learning.ecommerce_learning.domain.repository.DetailOrderRepository;
import com.ecommerce_learning.ecommerce_learning.infrastructure.entity.DetailOrderDB;
import com.ecommerce_learning.ecommerce_learning.shared.util.mapper.DetailOrderMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DetailOrderRepositoryImpl implements DetailOrderRepository {

    private final MongoDetailOrderRepository mongoDetailOrderRepository;
    private final DetailOrderMapper detailOrderMapper;

    public DetailOrderRepositoryImpl(MongoDetailOrderRepository mongoDetailOrderRepository, DetailOrderMapper detailOrderMapper) {
        this.mongoDetailOrderRepository = mongoDetailOrderRepository;
        this.detailOrderMapper = detailOrderMapper;
    }

    @Override
    public DetailOrder save(DetailOrder detailOrder) {
        DetailOrderDB detailOrderDB = detailOrderMapper.toDetailOrderDB(detailOrder);
        DetailOrderDB savedDetailOrderDB = mongoDetailOrderRepository.save(detailOrderDB);
        return detailOrderMapper.toDetailOrder(savedDetailOrderDB);
    }

    @Override
    public void deleteById(String id) {
        mongoDetailOrderRepository.deleteById(id);
    }

    @Override
    public Optional<DetailOrder> findById(String id) {
        return mongoDetailOrderRepository.findById(id).map(detailOrderMapper::toDetailOrder);
    }

    @Override
    public List<DetailOrder> findAll() {
        return detailOrderMapper.mapDetailOrders(mongoDetailOrderRepository.findAll());
    }

    @Override
    public Boolean existsById(String id) {
        return mongoDetailOrderRepository.existsById(id);
    }

    @Override
    public DetailOrder update(DetailOrder detailOrder) {
        DetailOrderDB detailOrderDB = detailOrderMapper.toDetailOrderDB(detailOrder);
        DetailOrderDB updatedDetailOrderDB = mongoDetailOrderRepository.save(detailOrderDB);
        return detailOrderMapper.toDetailOrder(updatedDetailOrderDB);
    }

    @Override
    public Optional<DetailOrder> findByOrderNumber(String orderNumber) {
        return mongoDetailOrderRepository.findByOrderNumber(orderNumber).map(detailOrderMapper::toDetailOrder);
    }
}
