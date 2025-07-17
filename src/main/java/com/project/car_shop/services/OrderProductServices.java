package com.project.car_shop.services;

import com.project.car_shop.model.dtos.ProductDTO;

import java.util.List;

public interface OrderProductServices {
    List<ProductDTO> getProductsByOrderId(Long orderId);
    List<ProductDTO> getProductsByCustomerId(Long customerId);
}
