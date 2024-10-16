package com.jlab.JLabSamleForSpring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jlab.JLabSamleForSpring.model.Customer;
import com.jlab.JLabSamleForSpring.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/JLabSamleForSpring")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Insert a new customer
    @PostMapping("/customers")
    public ResponseEntity<Object> insertCustomer(@Valid @RequestBody Customer customer) {
        try {
            customerService.insertCustomer(customer);
            return new ResponseEntity<>(new ResponseModel("001", "SUCCESS"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseModel("002", "FAILE, " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update customer
    @PutMapping("/customers/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable int id, @Valid @RequestBody Customer customer) {
        try {
            customerService.updateCustomer(customer);
            return new ResponseEntity<>(new ResponseModel("001", "SUCCESS"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseModel("002", "FAILE, " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete a customer by ID
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable int id) {
        try {
            customerService.deleteCustomer(id);
            return new ResponseEntity<>(new ResponseModel("001", "SUCCESS"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseModel("002", "FAILE, " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Find a customer by ID
    @GetMapping("/customers/{id}")
    public ResponseEntity<Object> findCustomerById(@PathVariable int id) {
        try {
            Customer customer = customerService.findCustomerById(id);
            if (customer != null) {
                return new ResponseEntity<>(customer, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ResponseModel("002", "FAILE, Customer not found"), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseModel("002", "FAILE, " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all customers
    @GetMapping("/customers")
    public ResponseEntity<Object> findAllCustomers() {
        try {
            List<Customer> customers = customerService.findAllCustomers();
            if (!customers.isEmpty()) {
                return new ResponseEntity<>(customers, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ResponseModel("002", "FAILE, No customers found"), HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseModel("002", "FAILE, " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Custom response model for status code and message
    public static class ResponseModel {
        private String statusCode;
        private String message;

        public ResponseModel(String statusCode, String message) {
            this.statusCode = statusCode;
            this.message = message;
        }

        // Getters and setters
        public String getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
