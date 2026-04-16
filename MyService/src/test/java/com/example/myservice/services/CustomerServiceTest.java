package com.example.myservice.services;

import com.example.myservice.entities.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService();
    }

    @Test
    void shouldAddCustomer() {
        Customer customer = new Customer(1, "Dupont", "Jean", "Paris", "0600", "test@test.com");

        customerService.addCustomers(customer);

        List<Customer> customers = customerService.getCustomers();

        assertEquals(1, customers.size());
        assertEquals("Dupont", customers.get(0).getNom());
    }

    @Test
    void shouldGetCustomerById() {
        Customer c1 = new Customer(1, "A", "B", "C", "D", "E");
        Customer c2 = new Customer(2, "X", "Y", "Z", "W", "V");

        customerService.addCustomers(c1);
        customerService.addCustomers(c2);

        Customer result = customerService.getCustomer(2);

        assertNotNull(result);
        assertEquals("X", result.getNom());
    }

    @Test
    void shouldReturnNullIfNotFound() {
        Customer result = customerService.getCustomer(999);

        assertNull(result);
    }
}