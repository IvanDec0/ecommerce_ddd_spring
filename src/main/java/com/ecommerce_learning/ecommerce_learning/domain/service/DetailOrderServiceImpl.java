package com.ecommerce_learning.ecommerce_learning.domain.service;

import com.ecommerce_learning.ecommerce_learning.domain.model.DetailOrder;
import com.ecommerce_learning.ecommerce_learning.domain.model.Product;
import com.ecommerce_learning.ecommerce_learning.domain.repository.DetailOrderRepository;
import com.ecommerce_learning.ecommerce_learning.domain.repository.OrderRepository;
import com.ecommerce_learning.ecommerce_learning.domain.repository.ProductRepository;
import com.ecommerce_learning.ecommerce_learning.domain.service.interfaces.DetailOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ecommerce_learning.ecommerce_learning.shared.util.ReturnConstants.*;

@Service
public class DetailOrderServiceImpl implements DetailOrderService {

    private final DetailOrderRepository detailOrderRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public DetailOrderServiceImpl(DetailOrderRepository detailOrderRepository,
                                  ProductRepository productRepository,
                                  OrderRepository orderRepository) {
        this.detailOrderRepository = detailOrderRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public DetailOrder addDetailOrder(DetailOrder detailOrder) {
        if (detailOrder.getId() != null) {
            throw new IllegalArgumentException(DETAIL_ORDER_ID_MUST_BE_NULL);
        }
        detailOrder.setOrder(orderRepository.findById(detailOrder.getOrder().getId()).orElseThrow(() -> new IllegalArgumentException(String.format(ORDER_NOT_FOUND_BY_ID, detailOrder.getOrder().getId()))));
        detailOrder.setProducts(productRepository.findAllById(detailOrder.getProducts().stream().map(Product::getId).toList()));
        return detailOrderRepository.save(detailOrder);
    }

    @Override
    public DetailOrder updateDetailOrder(String id, DetailOrder detailOrder) {
        if (id == null) {
            throw new IllegalArgumentException(DETAIL_ORDER_ID_MUST_BE_NULL);
        }
        DetailOrder detailOrderExisted = detailOrderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.format(DETAIL_ORDER_NOT_FOUND, id)));
        detailOrderExisted.setName(detailOrder.getName());
        detailOrderExisted.setPrice(detailOrder.getPrice());
        detailOrderExisted.setQuantity(detailOrder.getQuantity());
        detailOrderExisted.setTotal(detailOrder.getTotal());
        detailOrderExisted.setOrder(orderRepository.findById(detailOrder.getOrder().getId()).orElseThrow(() -> new IllegalArgumentException(String.format(ORDER_NOT_FOUND_BY_ID, detailOrder.getOrder().getId())))); // Find order by id
        detailOrderExisted.setProducts(productRepository.findAllById(detailOrder.getProducts().stream().map(Product::getId).toList())); // Find products by id list
        return detailOrderRepository.update(detailOrder);
    }

    @Override
    public void deleteDetailOrder(String id) {
        if (!detailOrderRepository.existsById(id)) {
            throw new IllegalArgumentException(String.format(DETAIL_ORDER_NOT_FOUND, id));
        }
        detailOrderRepository.deleteById(id);
    }

    @Override
    public DetailOrder getDetailOrder(String id) {
        return detailOrderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.format(DETAIL_ORDER_NOT_FOUND, id)));
    }

    @Override
    public List<DetailOrder> getAllDetailOrder() {
        return detailOrderRepository.findAll();
    }
}
