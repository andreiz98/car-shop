package com.project.car_shop.services.implementation;

import com.project.car_shop.model.dtos.ProductDTO;
import com.project.car_shop.model.entities.Product;
import com.project.car_shop.repository.ProductRepository;
import com.project.car_shop.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductServices {


    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductDTO> findAllProducts() {
        List<ProductDTO> productDTOS = new ArrayList<>();
        repository.findAll().forEach(product -> fromEntityToDto(productDTOS, product));
        return productDTOS;
    }

    @Override
    public List<ProductDTO> findProductByBrandAndColorAndCapacityAndPrice(String brand, String color, int capacity, double price) {
        List<Product> products = repository.findProductByBrandAndColorAndCapacityAndPrice(brand, color, capacity, price);
        List<ProductDTO> productDTOS = new ArrayList<>();
        products.forEach(product -> fromEntityToDto(productDTOS, product));
        return productDTOS;
    }

    @Override
    public void deleteProductById(Long id) {
        repository.deleteById(id);
    }

    private void fromEntityToDto(List<ProductDTO> productDTOS, Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setBrand(product.getBrand());
        productDTO.setModel(product.getModel());
        productDTO.setColor(product.getColor());
        productDTO.setCapacity(product.getCapacity());
        productDTO.setPrice(product.getPrice());
        productDTO.setYearOfManufacture(product.getYearOfManufacture());
        productDTO.setDiscount(product.getDiscount());
        productDTOS.add(productDTO);
    }
}
