package com.example.myservice.controllers;

import com.example.myservice.entities.Customer;
import com.example.myservice.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerServiceRest.class)
class CustomerServiceRestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    void shouldReturnCustomers() throws Exception {

        when(customerService.getCustomers())
                .thenReturn(List.of(
                        new Customer(1, "Dupont", "Jean", "Paris", "0600", "test@test.com")
                ));

        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].nom").value("Dupont"));
    }

    @Test
    void shouldReturnCustomerById() throws Exception {

        when(customerService.getCustomer(1))
                .thenReturn(new Customer(1, "Dupont", "Jean", "Paris", "0600", "test@test.com"));

        mockMvc.perform(get("/customers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("Dupont"));
    }

    @Test
    void shouldCreateCustomer() throws Exception {

        String json = """
        {
            "id": 1,
            "nom": "Dupont",
            "prenom": "Jean",
            "adresse": "Paris",
            "telephone": "0600",
            "email": "test@test.com"
        }
        """;

        mockMvc.perform(post("/customers")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk());

        verify(customerService, times(1)).addCustomers(any(Customer.class));
    }
}