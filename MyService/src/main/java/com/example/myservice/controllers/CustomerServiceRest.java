package com.example.myservice.controllers;

import com.example.myservice.entities.Customer;
import com.example.myservice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerServiceRest {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping("/customers")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomers(customer);
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable int id) {
        return customerService.getCustomer(id);
    }
}
