package com.jlab.JLabSamleForSpring.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jlab.JLabSamleForSpring.model.Customer;

@Repository
public interface CustomerRepository {
    int insert(Customer customer);
    int update(Customer customer);
    int delete(int id);
    Customer findById(int id);
    List<Customer> findAll();
}