package com.project.car_shop.model.dtos;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductDTO implements Serializable {

    private Long id;
    private String brand;
    private String model;
    private String color;
    private Integer capacity;
    private Double price;
    private Date yearOfManufacture;
    private BigDecimal discount;
}
