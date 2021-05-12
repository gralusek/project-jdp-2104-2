package com.kodilla.ecommercee;

import com.kodilla.ecommercee.Dto.OrderDto;
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
        List<OrderDto> orders = new ArrayList<>();
        return  orders;
    }
    @PostMapping(value = "addOrder")
    public OrderDto addOrder(@RequestBody OrderDto orderDto) {
        OrderDto newOrder = new OrderDto();
        return service.createOrder(newOrder);
    }

    @GetMapping(value = "getOrder")
    public OrderDto getOrder(@RequestParam Long id) throws OrderNotExist {
        return orderMapper.maptoOrderDto(
                service.getOrder(id).orElseThrow(OrderNotExist::new));

    }

    @PutMapping(value = "updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        OrderDto updatedOrder = new OrderDto();
        return updatedOrder;
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(@RequestParam Long id) {
        service.deleteOrder(id);
    }
}
