package com.kgisl.sb1.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.sb1.model.Customer;
import com.kgisl.sb1.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    public CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomer() {
    
        return customerRepository.findAll();
    }

    @Override
    public Customer findByCustomerId(int id){
        customerRepository.findById(id);
        return customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(int id, Customer customer) {
         Optional<Customer> s = customerRepository.findById(id);
         Customer c2=s.get();
         c2.setId(customer.getId());
         c2.setFirstName(customer.getFirstName());
         c2.setLastName(customer.getLastName());
         c2.setEmail(customer.getEmail());
         
         customerRepository.save(customer);
         return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(int id) {
        customerRepository.deleteById(id);         
    }

    @Override
    public Object getAllCustomers() {
        return null;
    }

    @Override
    public Object getAll() {
        return null;
    }
}

/*import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kgisl.springboot.model.Customer;
import com.kgisl.springboot.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService{
     @Autowired
     private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
    @Override
    public Customer findCustomerById(int id) {
        customerRepository.findById(id);
        return  customerRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Not Found"));
    }
    @Override
    public  Customer createCustomer(Customer c) {
       return customerRepository.save(c);
    }
    @Override
    public Customer updatCustomer(int id,Customer currentUser) {
        Optional<Customer> c = customerRepository.findById(id);
        Customer customer = c.get();
        customer.setId(currentUser.getId());
        customer.setEmail(currentUser.getEmail());
        customer.setFirstname(currentUser.getFirstname());
        customer.setLastname(currentUser.getLastname());
        customerRepository.save(customer);
        return customerRepository.save(customer);
    }
    @Override
    public void deleteCustomerById(int id) {
       customerRepository.deleteById(id);
    }
}*/
