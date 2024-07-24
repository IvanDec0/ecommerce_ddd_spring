package com.ecommerce_learning.ecommerce_learning.application.web.detailOrder.controller;

import com.ecommerce_learning.ecommerce_learning.application.web.detailOrder.request.DetailOrderRequest;
import com.ecommerce_learning.ecommerce_learning.application.web.detailOrder.response.DetailOrderResponse;
import com.ecommerce_learning.ecommerce_learning.domain.service.interfaces.DetailOrderService;
import com.ecommerce_learning.ecommerce_learning.shared.util.mapper.DetailOrderMapper;
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

    public DetailOrderController(DetailOrderService detailOrderService, DetailOrderMapper detailOrderMapper) {
        this.detailOrderService = detailOrderService;
        this.detailOrderMapper = detailOrderMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<DetailOrderResponse> addDetailOrder(@RequestBody DetailOrderRequest detailOrderRequest) {
        return ResponseEntity.ok(detailOrderMapper.toDetailOrderResponse(detailOrderService.addDetailOrder(detailOrderMapper.toDetailOrderNoProdNoOrder(detailOrderRequest))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailOrderResponse> updateDetailOrder(@PathVariable String id, @RequestBody DetailOrderRequest detailOrderRequest) {
        return ResponseEntity.ok(detailOrderMapper.toDetailOrderResponse(detailOrderService.updateDetailOrder(id, detailOrderMapper.toDetailOrderNoProdNoOrder(detailOrderRequest))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatusCode> deleteDetailOrder(@PathVariable String id) {
        detailOrderService.deleteDetailOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailOrderResponse> getDetailOrder(@PathVariable String id) {
        return ResponseEntity.ok(detailOrderMapper.toDetailOrderResponse(detailOrderService.getDetailOrder(id)));
    }

    @GetMapping("/")
    public ResponseEntity<List<DetailOrderResponse>> getAllDetailOrder() {
        return ResponseEntity.ok(detailOrderMapper.mapDetailOrdersResponse(detailOrderService.getAllDetailOrder()));
    }
}
