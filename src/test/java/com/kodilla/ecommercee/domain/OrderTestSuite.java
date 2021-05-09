package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.Repository.OrderRepository;

import com.kodilla.ecommercee.Repository.UserRespository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrderTestSuite {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRespository userRespository;

    @Test
    public void testCreateOrder() {
        //Given
        Order order = new Order();

        //When
        orderRepository.save(order);
        Long id = order.getOrderId();
        Optional<Order> isPresent = orderRepository.findById(id);

        //Then
        assertTrue(isPresent.isPresent());

        //CleanUp
        orderRepository.deleteById(id);
        System.out.println(1);
    }

    @Test
    public void testReadOrder() {
        //Given
        Order order = new Order();
        User user = new User(1L, "Josh", false, 1,
                LocalDateTime.of(2021,5,5,10, 10), new ArrayList<>());

        //When
        order.setStatus(OrderStatus.SUBMITTED);
        order.setUser(user);
        userRespository.save(user);
        orderRepository.save(order);
        Long id = order.getOrderId();
        Long id2 = user.getUserId();
        Optional<Order> ifPresent = orderRepository.findById(id);
        OrderStatus status = OrderStatus.SUBMITTED;

        //Then
        assertTrue(ifPresent.isPresent());
        assertEquals("Josh", order.getUser().getUsername());
        assertEquals(1, order.getUser().getUserKey());
        assertEquals(status,order.getStatus());

        //CleanUp
        orderRepository.deleteById(id);
        userRespository.deleteById(id2);
    }

    @Test
    public void testUpdateOrder() {
        //Given
        Order order = new Order();

        //When&Then
        order.setStatus(OrderStatus.SUBMITTED);
        OrderStatus status1 = OrderStatus.SUBMITTED;
        orderRepository.save(order);
        assertEquals(status1, order.getStatus());

        order.setStatus(OrderStatus.SHIPPED);
        OrderStatus status2 = OrderStatus.SHIPPED;
        orderRepository.save(order);
        assertEquals(status2, order.getStatus());

        Long id = order.getOrderId();

        //Cleanup
        orderRepository.deleteById(id);
        System.out.println(2);
    }

    @Test
    public void testDeleteOrder() {
        //Given
        Order order = new Order();

        //When
        orderRepository.save(order);
        Long id = order.getOrderId();
        orderRepository.deleteById(id);
        Optional<Order> ifPresent = orderRepository.findById(id);

        //Then
        assertFalse(ifPresent.isPresent());
        System.out.println(3);
    }

    @Test
    public void testManyToOne() {
        //Given
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        List<Order> orders = new ArrayList<>();
        User user = new User(1L, "Josh", false, 1,
                LocalDateTime.of(2021,5,5,10, 10), orders);

        //When
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        user.setOrders(orders);
        orderRepository.save(order1);
        Long id1 = order1.getOrderId();
        orderRepository.save(order2);
        Long id2 = order2.getOrderId();
        orderRepository.save(order3);
        Long id3 = order3.getOrderId();
        userRespository.save(user);

        //Then
        assertEquals(3, user.getOrders().size());

        //Cleanup
        orderRepository.deleteById(id1);
        orderRepository.deleteById(id2);
        orderRepository.deleteById(id3);
        userRespository.delete(user);
        System.out.println(4);
    }
}