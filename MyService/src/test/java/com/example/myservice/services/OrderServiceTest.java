package com.example.myservice.services;

import com.example.myservice.entities.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderService = new OrderService();
    }

    @Test
    void shouldAddOrder() {
        Order order = new Order();
        order.setId("O1");
        order.setIdCustomer(1);
        order.setTotal(100f);

        orderService.addOrder(order);

        List<Order> orders = orderService.getOrders();

        assertEquals(1, orders.size());
        assertEquals("O1", orders.get(0).getId());
    }

    @Test
    void shouldGetOrderById() {
        Order o1 = new Order();
        o1.setId("A1");

        Order o2 = new Order();
        o2.setId("B2");

        orderService.addOrder(o1);
        orderService.addOrder(o2);

        Order result = orderService.getOrder("B2");

        assertNotNull(result);
        assertEquals("B2", result.getId());
    }

    @Test
    void shouldReturnNullIfOrderNotFound() {
        Order result = orderService.getOrder("NOT_EXIST");

        assertNull(result);
    }
}