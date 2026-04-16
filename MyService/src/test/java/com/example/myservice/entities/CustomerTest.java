package com.example.myservice.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void shouldCreateCustomerAndReturnCorrectValues() {
        Customer customer = new Customer(
                1,
                "Dupont",
                "Jean",
                "Paris",
                "0600000000",
                "jean@test.com"
        );

        assertEquals(1, customer.getId());
        assertEquals("Dupont", customer.getNom());
        assertEquals("Jean", customer.getPrenom());
        assertEquals("Paris", customer.getAdresse());
        assertEquals("0600000000", customer.getTelephone());
        assertEquals("jean@test.com", customer.getEmail());
    }

    @Test
    void shouldUpdateFields() {
        Customer customer = new Customer(
                1, "A", "B", "C", "D", "E"
        );

        customer.setNom("Martin");
        customer.setPrenom("Paul");

        assertEquals("Martin", customer.getNom());
        assertEquals("Paul", customer.getPrenom());
    }
}