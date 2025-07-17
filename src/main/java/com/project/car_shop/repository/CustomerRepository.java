package com.project.car_shop.repository;

import com.project.car_shop.model.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    List<Customer> findByNameAndEmail(String name, String email);

    @Query(value = "SELECT * from customers where name = :name AND email =:email", nativeQuery = true)
    List<Customer> findByNameAndEmail2(String name, String email);
}
