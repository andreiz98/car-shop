package com.project.car_shop.repository;


import com.project.car_shop.model.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
