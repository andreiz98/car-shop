package com.project.car_shop.controllers;

import com.project.car_shop.model.dtos.ProductDTO;
import com.project.car_shop.services.implementation.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAllProducts(){
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ProductDTO>> findProductByBrandAndColourAndCapacityAndPrice
            (
                    @RequestParam String brand,
                    @RequestParam String color,
                    @RequestParam Integer capacity,
                    @RequestParam Double price
            ){
        return ResponseEntity.ok(productService.findProductByBrandAndColorAndCapacityAndPrice(brand, color, capacity, price));
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable long id){
        productService.deleteProductById(id);
    }
}
