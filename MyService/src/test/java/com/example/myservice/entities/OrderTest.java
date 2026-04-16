package com.example.myservice.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void shouldCreateOrderAndReturnValues() {
        Order order = new Order();

        order.setId("O1");
        order.setIdCustomer(10);
        order.setTotal(99.5f);

        assertEquals("O1", order.getId());
        assertEquals(10, order.getIdCustomer());
        assertEquals(99.5f, order.getTotal());
    }

    @Test
    void shouldUpdateValues() {
        Order order = new Order();

        order.setId("O2");
        order.setTotal(50.0f);

        assertEquals("O2", order.getId());
        assertEquals(50.0f, order.getTotal());
    }
}