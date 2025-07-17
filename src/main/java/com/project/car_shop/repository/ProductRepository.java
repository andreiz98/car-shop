package com.project.car_shop.repository;

import com.project.car_shop.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findProductByBrandAndColorAndCapacityAndPrice(String brand, String color, int capacity, double price);
}
