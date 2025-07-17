package com.project.car_shop.controllers;

import com.project.car_shop.model.dtos.CustomerDTO;
import com.project.car_shop.services.implementation.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer (@RequestBody @Valid CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.createCustomer(customerDTO));
    }

    @GetMapping("/jpa-method")
    public ResponseEntity<List<CustomerDTO>> findCustomersJpa(@RequestParam String name, @RequestParam String email){
        return ResponseEntity.ok(customerService.findCustomers(name,email));
    }

    @GetMapping("/query-method")
    public ResponseEntity<List<CustomerDTO>> findCustomersQuery(@RequestParam String name, @RequestParam String email){
        return ResponseEntity.ok(customerService.findCustomersByQuery(name, email));
    }

}
