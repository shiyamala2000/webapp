package com.kgisl.springmd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kgisl.springmd.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee,String>{

}
