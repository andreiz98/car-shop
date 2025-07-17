package com.project.car_shop.model.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class AddressDto implements Serializable {
    private String street;
    private String city;
    private String country;
}
