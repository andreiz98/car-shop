package com.project.car_shop.controllers;

import com.project.car_shop.model.dtos.ProductDTO;
import com.project.car_shop.services.implementation.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order-products")
public class OrderProductController {

    private final OrderProductService orderProductService;

    @Autowired
    public OrderProductController(OrderProductService orderProductService) {
        this.orderProductService = orderProductService;
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<ProductDTO>> getProductsByOrderId(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderProductService.getProductsByOrderId(orderId));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<ProductDTO>> getProductsByCustomerId(@PathVariable Long customerId) {
        return ResponseEntity.ok(orderProductService.getProductsByCustomerId(customerId));
    }
}
