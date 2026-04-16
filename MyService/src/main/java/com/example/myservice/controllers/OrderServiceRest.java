package com.example.myservice.controllers;

import com.example.myservice.entities.Order;
import com.example.myservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderServiceRest {
    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public List<Order> getOrderss() {
        return orderService.getOrders();
    }

    @PostMapping("/orders")
    public void addCustomer(@RequestBody Order order) {
        orderService.addOrder(order);
    }

    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable String id) {
        return orderService.getOrder(id);
    }
}

