package com.project.car_shop.uniiTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.car_shop.model.dtos.CustomerDTO;
import com.project.car_shop.model.entities.Customer;
import com.project.car_shop.repository.CustomerRepository;
import com.project.car_shop.services.CustomerValidationService;
import com.project.car_shop.services.implementation.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerValidationService customerValidationService;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private ObjectMapper objectMapper;

    @Test
    void testCreateCustomer_ShouldPass(){
        //given
        CustomerDTO customerDTO = CustomerDTO.builder()
                .name("Marcus")
                .email("marcus@gmail.com")
                .build();
        Customer customerEntity = Customer.builder()
                .name("Marcus")
                .email("marcus@gmail.com")
                .build();
        when(objectMapper.convertValue(customerDTO, Customer.class)).thenReturn(customerEntity);
        when(customerRepository.save(customerEntity)).thenReturn(customerEntity);
        when(objectMapper.convertValue(customerEntity, CustomerDTO.class)).thenReturn(customerDTO);
        //when
        CustomerDTO resultCustomerDTO = customerService.createCustomer(customerDTO);
        //then
        Assertions.assertEquals(customerDTO, resultCustomerDTO);
    }


}
