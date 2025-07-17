package com.project.car_shop.services;

import com.project.car_shop.model.dtos.CustomerDTO;

import java.util.List;

public interface CustomerServices {
    CustomerDTO createCustomer(CustomerDTO customerDto);
    List<CustomerDTO> findCustomers(String name, String email);
    List<CustomerDTO> findCustomersByQuery(String name, String email);
}
