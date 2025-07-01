package com.project.car_shop.services.implementation;

import com.project.car_shop.model.dtos.ProductDto;
import com.project.car_shop.model.entities.Product;
import com.project.car_shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements com.project.car_shop.services.ProductService {


    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductDto> findAllProduct() {
        List<ProductDto> productDtos = new ArrayList<>();
        repository.findAll().forEach(product -> fromEntityToDto(productDtos, product));
        return productDtos;
    }

    private void fromEntityToDto(List<ProductDto> productDtos, Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setBrand(product.getBrand());
        productDto.setModel(product.getModel());
        productDto.setColor(product.getColor());
        productDto.setCapacity(product.getCapacity());
        productDto.setPrice(product.getPrice());
        productDto.setYearOfManufacture(product.getYearOfManufacture());
        productDtos.add(productDto);
    }
}
