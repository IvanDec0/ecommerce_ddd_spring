package com.ecommerce_learning.ecommerce_learning.domain.service;

import com.ecommerce_learning.ecommerce_learning.domain.model.DetailOrder;
import com.ecommerce_learning.ecommerce_learning.domain.model.Product;
import com.ecommerce_learning.ecommerce_learning.domain.repository.DetailOrderRepository;
import com.ecommerce_learning.ecommerce_learning.domain.repository.OrderRepository;
import com.ecommerce_learning.ecommerce_learning.domain.repository.ProductRepository;
import com.ecommerce_learning.ecommerce_learning.domain.service.interfaces.DetailOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

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
            throw new IllegalArgumentException("Detail Order id must be null");
        }
        detailOrder.setOrder(orderRepository.findById(detailOrder.getOrder().getId()).orElseThrow(() -> new IllegalArgumentException("Order not found")));
        detailOrder.setProducts(productRepository.findAllById(detailOrder.getProducts().stream().map(Product::getId).toList()));
        return detailOrderRepository.save(detailOrder);
    }

    @Override
    public DetailOrder updateDetailOrder(String id, DetailOrder detailOrder) {
        if (id == null) {
            throw new IllegalArgumentException("Detail Order id must not be null");
        }
        DetailOrder detailOrderExisted = detailOrderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Detail Order not found"));
        detailOrderExisted.setName(detailOrder.getName());
        detailOrderExisted.setPrice(detailOrder.getPrice());
        detailOrderExisted.setQuantity(detailOrder.getQuantity());
        detailOrderExisted.setTotal(detailOrder.getTotal());
        detailOrderExisted.setOrder(orderRepository.findById(detailOrder.getOrder().getId()).orElseThrow(() -> new IllegalArgumentException("Order not found"))); // Find order by id
        detailOrderExisted.setProducts(productRepository.findAllById(detailOrder.getProducts().stream().map(Product::getId).toList())); // Find products by id list
        return detailOrderRepository.update(detailOrder);
    }

    @Override
    public void deleteDetailOrder(String id) {
        detailOrderRepository.deleteById(id);
    }

    @Override
    public DetailOrder getDetailOrder(String id) {
        return detailOrderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Detail Order not found"));
    }

    @Override
    public List<DetailOrder> getAllDetailOrder() {
        return detailOrderRepository.findAll();
    }
}
