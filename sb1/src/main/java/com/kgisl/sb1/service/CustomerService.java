package com.kgisl.sb1.service;

import java.util.List;

import com.kgisl.sb1.model.Customer;

public interface CustomerService {
    public List<Customer> getCustomer();
    public Customer findByCustomerId(int id);
    public Customer createCustomer(Customer team);
    public Customer updateCustomer(int id,Customer team);
    public void deleteCustomerById(int id);
    public Object getAllCustomers();
    public Object getAll(); 
}

/*import java.util.List;
import com.kgisl.springboot.model.Customer;
public interface CustomerService {
    public List<Customer> getAll();
    public Customer findCustomerById(int id);
    public Customer createCustomer(Customer c);
    public Customer updatCustomer(int id,Customer currentUser);
    public void deleteCustomerById(int id);
}*/