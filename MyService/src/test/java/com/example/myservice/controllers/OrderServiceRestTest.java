package com.example.myservice.controllers;

import com.example.myservice.entities.Order;
import com.example.myservice.services.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrderServiceRest.class)
class OrderServiceRestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    void shouldReturnOrders() throws Exception {

        Order order = new Order();
        order.setId("O1");
        order.setIdCustomer(1);
        order.setTotal(50f);

        when(orderService.getOrders())
                .thenReturn(List.of(order));

        mockMvc.perform(get("/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value("O1"));
    }

    @Test
    void shouldReturnOrderById() throws Exception {

        Order order = new Order();
        order.setId("O2");

        when(orderService.getOrder("O2"))
                .thenReturn(order);

        mockMvc.perform(get("/orders/O2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("O2"));
    }

    @Test
    void shouldCreateOrder() throws Exception {

        String json = """
        {
            "id": "O3",
            "idCustomer": 1,
            "total": 120.5
        }
        """;

        mockMvc.perform(post("/orders")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk());

        verify(orderService, times(1)).addOrder(any(Order.class));
    }
}