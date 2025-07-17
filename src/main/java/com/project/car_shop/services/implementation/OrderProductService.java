package com.project.car_shop.services.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.car_shop.model.dtos.ProductDTO;
import com.project.car_shop.model.entities.Product;
import com.project.car_shop.repository.OrderProductRepository;
import com.project.car_shop.services.OrderProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderProductService implements OrderProductServices {
    private final OrderProductRepository orderProductRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public OrderProductService(OrderProductRepository orderProductRepository,
                               ObjectMapper objectMapper) {
        this.orderProductRepository = orderProductRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<ProductDTO> getProductsByOrderId(Long orderId) {
        List<Product> products = orderProductRepository.findProductsByOrderId(orderId);
        return products.stream()
                .map(product -> objectMapper.convertValue(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductsByCustomerId(Long customerId) {
        List<Product> products = orderProductRepository.findProductsByCustomerId(customerId);
        return products.stream()
                .map(product -> objectMapper.convertValue(product, ProductDTO.class))
                .collect(Collectors.toList());
    }
}
