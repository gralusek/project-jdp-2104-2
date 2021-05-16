package com.kodilla.ecommercee;

import com.kodilla.ecommercee.Dto.OrderDto;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.exceptions.OrderNotExist;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    private final OrderService service;
    private final OrderMapper orderMapper;

    public OrderController(OrderService service, OrderMapper orderMapper) {
        this.service = service;
        this.orderMapper = orderMapper;
    }

    @GetMapping(value = "getOrders")
    public List<OrderDto> getOrders() {
        List<Order> orders = service.getOrders();
        return orderMapper.mapToOrderDtoList(orders);
    }
    @PostMapping(value = "addOrder")
    public void addOrder(@RequestBody OrderDto orderDto) {
        Order newOrder = orderMapper.mapToOrder(orderDto);
        service.createOrder(newOrder);
    }

    @GetMapping(value = "getOrder")
    public OrderDto getOrder(@RequestParam Long id) throws OrderNotExist {
        return orderMapper.mapToOrderDto(
                service.getOrder(id).orElseThrow(OrderNotExist::new));
    }

    @PutMapping(value = "updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        Order order = orderMapper.mapToOrder(orderDto);
        Order updatedOrder = service.createOrder(order);
        return orderMapper.mapToOrderDto(updatedOrder);
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(@RequestParam Long id) {
        service.deleteOrder(id);
    }
}
