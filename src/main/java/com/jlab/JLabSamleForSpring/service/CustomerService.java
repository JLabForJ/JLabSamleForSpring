package com.jlab.JLabSamleForSpring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlab.JLabSamleForSpring.model.Customer;
import com.jlab.JLabSamleForSpring.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public int insertCustomer(Customer customer) {
        return customerRepository.insert(customer);
    }

    public int updateCustomer(Customer customer) {
    	return customerRepository.update(customer);
    }

    public int deleteCustomer(int id) {
        return customerRepository.delete(id);
    }

    public Customer findCustomerById(int id) {
        return customerRepository.findById(id);
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
}