package com.kodilla.ecommercee.dbServices;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderDbService {

    private final OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order saveOrder(final Order order){
        return orderRepository.save(order);
    }

    public Optional<Order> getOrder(final Long id){
        return orderRepository.findById(id);
    }

    public void deleteOrder(final Long id){
        orderRepository.deleteById(id);
    }
}
