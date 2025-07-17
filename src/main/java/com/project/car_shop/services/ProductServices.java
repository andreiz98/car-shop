package com.project.car_shop.services;

import com.project.car_shop.model.dtos.ProductDTO;

import java.util.List;

public interface ProductServices {
    List<ProductDTO> findAllProducts();
    List<ProductDTO> findProductByBrandAndColorAndCapacityAndPrice(String brand, String color, int capacity, double price);
    void deleteProductById(Long id);
}
