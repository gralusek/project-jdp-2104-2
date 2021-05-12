package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> getOrders() {
        return repository.findAll();
    }

    public Order createOrder(Order order) {
        return repository.save(order);
    }

    public Optional<Order> getOrder(Long id) {
        return  repository.findById(id);
    }

    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }
}
