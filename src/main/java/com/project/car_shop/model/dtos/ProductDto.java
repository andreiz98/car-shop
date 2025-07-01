package com.project.car_shop.model.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProductDto implements Serializable {

    private Long id;
    private String brand;
    private String model;
    private String color;
    private Integer capacity;
    private Double price;
    private Date yearOfManufacture;
}
