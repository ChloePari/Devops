package com.example.myservice.services;

import com.example.myservice.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private List<Customer> customers = new ArrayList<>();

    public Customer getCustomer(int idCustomer) {
        return  customers.stream()
                .filter(customer -> customer.getId() == idCustomer)
                .findFirst()
                .orElse(null);
    }
    public void addCustomers(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }
}