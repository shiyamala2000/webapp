package com.kgisl.springmd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.kgisl.springmd.model.Employee;
import com.kgisl.springmd.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	Gson gson = new Gson();
	
	@GetMapping("/")
	public ResponseEntity<String> getAllEmployee() {
		List<Employee> l = employeeService.getAll();
		String element=gson.toJson(l);
	    return	new ResponseEntity<>(element, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getEmployeeById(@PathVariable String id) {
		Object l = employeeService.getById(id);
		return new ResponseEntity<>(l, HttpStatus.FOUND);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<String> insertEmployee(@RequestBody Employee e) {
		Employee l = employeeService.insert(e);
		String element=gson.toJson(l);
		return new ResponseEntity<>(element, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee e,@PathVariable String id) {
     Employee l = employeeService.update(e, id);
     String element=gson.toJson(l);
      return new  ResponseEntity<>(element, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable String id) {
	   employeeService.delete(id);
	   return new ResponseEntity<>(HttpStatus.GONE);
	}
	
}
