package com.project.car_shop.model.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerDTO {

    private Long id;
    @NotBlank(message = "name must not be null")
    private String name;
    @NotBlank(message = "email must not be null")
    private String email;
    private AddressDto address;
}
