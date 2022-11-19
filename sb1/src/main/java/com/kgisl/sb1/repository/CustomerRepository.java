package com.kgisl.sb1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kgisl.sb1.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    
}
