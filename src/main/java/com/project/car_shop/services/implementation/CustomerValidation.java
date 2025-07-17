package com.project.car_shop.services.implementation;

import com.project.car_shop.services.CustomerValidationService;
import org.springframework.stereotype.Service;

@Service
public class CustomerValidation implements CustomerValidationService {
    @Override
    public void emailValidation(String email) {
        if(!email.trim().contains("@") || email.trim().length() < 5){
            throw new RuntimeException("email is not valid");
        }
    }
}
