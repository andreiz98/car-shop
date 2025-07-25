package com.project.car_shop.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "color")
    private String color;
    @Column(name = "capacity")
    private Integer capacity;
    @Column(name = "price")
    private Double price;
    @Column(name = "year_of_manufacture")
    private Date yearOfManufacture;

    @Column(name = "discount", precision = 5, scale = 2, nullable = false)
    private BigDecimal discount;

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private List<Order> orders;
}
