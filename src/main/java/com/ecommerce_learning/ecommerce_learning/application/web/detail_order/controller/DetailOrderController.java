package com.ecommerce_learning.ecommerce_learning.application.web.detail_order.controller;

import com.ecommerce_learning.ecommerce_learning.application.web.detail_order.request.DetailOrderRequest;
import com.ecommerce_learning.ecommerce_learning.application.web.detail_order.response.DetailOrderResponse;
import com.ecommerce_learning.ecommerce_learning.domain.service.interfaces.DetailOrderService;
import com.ecommerce_learning.ecommerce_learning.shared.util.mapper.DetailOrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detailOrder")
public class DetailOrderController {

    private final DetailOrderService detailOrderService;
    private final DetailOrderMapper detailOrderMapper;
    private final Logger logger = LoggerFactory.getLogger(DetailOrderController.class);

    public DetailOrderController(DetailOrderService detailOrderService, DetailOrderMapper detailOrderMapper) {
        this.detailOrderService = detailOrderService;
        this.detailOrderMapper = detailOrderMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<DetailOrderResponse> addDetailOrder(@RequestBody DetailOrderRequest detailOrderRequest) {
        logger.info("Add Order -> DetailOrderRequest: {}", detailOrderRequest);
        return ResponseEntity.ok(detailOrderMapper.toDetailOrderResponse(detailOrderService.addDetailOrder(detailOrderMapper.toDetailOrderNoProdNoOrder(detailOrderRequest))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailOrderResponse> updateDetailOrder(@PathVariable String id, @RequestBody DetailOrderRequest detailOrderRequest) {
        logger.info("Update Order -> DetailOrderRequest: {}", detailOrderRequest);
        return ResponseEntity.ok(detailOrderMapper.toDetailOrderResponse(detailOrderService.updateDetailOrder(id, detailOrderMapper.toDetailOrderNoProdNoOrder(detailOrderRequest))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatusCode> deleteDetailOrder(@PathVariable String id) {
        detailOrderService.deleteDetailOrder(id);
        logger.info("Deleted Order -> DetailOrderID: {}", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailOrderResponse> getDetailOrder(@PathVariable String id) {
        logger.info("Get Order -> DetailOrderID: {}", id);
        return ResponseEntity.ok(detailOrderMapper.toDetailOrderResponse(detailOrderService.getDetailOrder(id)));
    }

    @GetMapping("/")
    public ResponseEntity<List<DetailOrderResponse>> getAllDetailOrder() {
        logger.info("Get All Orders");
        return ResponseEntity.ok(detailOrderMapper.mapDetailOrdersResponse(detailOrderService.getAllDetailOrder()));
    }
}
