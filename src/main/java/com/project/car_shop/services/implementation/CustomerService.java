package com.project.car_shop.services.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.car_shop.model.dtos.CustomerDTO;
import com.project.car_shop.model.entities.Customer;
import com.project.car_shop.repository.CustomerRepository;
import com.project.car_shop.services.CustomerServices;
import com.project.car_shop.services.CustomerValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements CustomerServices {

    private CustomerValidationService customerValidationService;
    private ObjectMapper objectMapper;
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerValidationService customerValidationService,
                           ObjectMapper objectMapper,
                           CustomerRepository customerRepository) {
        this.customerValidationService = customerValidationService;
        this.objectMapper = objectMapper;
        this.customerRepository = customerRepository;
    }


    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        customerValidationService.emailValidation(customerDTO.getEmail());
        Customer customer = objectMapper.convertValue(customerDTO, Customer.class);
        Customer customerDuble =  customerRepository.save(customer);
        return objectMapper.convertValue(customerDuble, CustomerDTO.class);
    }

    @Override
    public List<CustomerDTO> findCustomers(String name, String email) {
        return customerRepository.findByNameAndEmail(name, email)
                .stream()
                .map(customer -> objectMapper.convertValue(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDTO> findCustomersByQuery(String name, String email) {
        return customerRepository.findByNameAndEmail2(name, email)
                .stream()
                .map(customer -> objectMapper.convertValue(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }
}
