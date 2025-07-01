package com.project.car_shop.controllers;

import com.project.car_shop.model.dtos.ProductDto;
import com.project.car_shop.services.implementation.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAllProducts(){
        return ResponseEntity.ok(productService.findAllProduct());
    }
}
