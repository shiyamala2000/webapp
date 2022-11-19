package com.kgisl.sb1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.sb1.model.Customer;
import com.kgisl.sb1.repository.CustomerRepository;
import com.kgisl.sb1.service.CustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();

    }

    @GetMapping(value = "/{id}")
    public Customer getCustomer(@PathVariable("id") int id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found"));
        return customer;
    }

    // @GetMapping(value="/{id}")
    // public void getCustomer(@PathVariable("id") int id){
    // Optional<Customer> customer = customerRepository.findById(id);
    // }
    @PostMapping(value = "/", headers = "Accept=application/json")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer actualUser = customerService.createCustomer(customer);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(actualUser, headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", headers = "Accept=application/json")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int id, @RequestBody Customer currentCustomer) {
        Customer c = customerService.updateCustomer(id, currentCustomer);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}", headers = "Accept=application/json")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") int id) {
        Customer c1 = customerService.findByCustomerId(id);
        if (c1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

/*import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.kgisl.springboot.model.Customer;
import com.kgisl.springboot.service.CustomerService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/")
    public @ResponseBody ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id) {
        Customer c = customerService.findCustomerById(id);
        if (c == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Customer> deleteCustomersById(@PathVariable("id") int id) {
        Customer cust = customerService.findCustomerById(id);
        if (cust == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Customer> updateCustomerById(@PathVariable("id") long id, @RequestBody Customer currentUser) {
        Customer customer = customerService.updatCustomer((int) id, currentUser);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    @PostMapping(value = "/")
    public ResponseEntity<Customer> createTeam(@RequestBody Customer customer) {
        Customer actualCustomer = customerService.createCustomer(customer);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(actualCustomer, headers, HttpStatus.CREATED);
    }
}*/