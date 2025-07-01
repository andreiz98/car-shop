package com.project.car_shop.services;

import com.project.car_shop.model.dtos.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAllProduct();
}
