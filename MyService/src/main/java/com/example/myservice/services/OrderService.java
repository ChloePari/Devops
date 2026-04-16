package com.example.myservice.services;

import com.example.myservice.entities.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private List<Order> orders = new ArrayList<>();
    public List<Order> getOrders() {
        return orders;
    }
    public Order getOrder(String orderId) {
        return orders.stream().filter(order -> order.getId().equals(orderId))
                .findFirst().orElse(null);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}