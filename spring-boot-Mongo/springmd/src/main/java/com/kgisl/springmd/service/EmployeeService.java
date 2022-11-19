package com.kgisl.springmd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.springmd.model.Employee;
import com.kgisl.springmd.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAll() {
	 return	employeeRepository.findAll();
	}
	
	public Optional<Employee> getById(String id) {
	return	employeeRepository.findById(id);
	}
	
	public Employee insert(Employee e) {
	return	employeeRepository.save(e);
	}
	
	public Employee update(Employee e,String id) {
	return	employeeRepository.save(e);
	}
	
	public void delete(String id) {
	 employeeRepository.deleteById(id);
	}
}
