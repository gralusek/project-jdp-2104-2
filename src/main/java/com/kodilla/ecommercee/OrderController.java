package com.kodilla.ecommercee;

import com.kodilla.ecommercee.Dto.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @GetMapping(value = "getOrders")
    public List<OrderDto> getOrders() {
        List<OrderDto> orders = new ArrayList<>();
        return  orders;
    }
    @PostMapping(value = "addOrder")
    public OrderDto addOrder(@RequestBody OrderDto orderDto) {
        OrderDto newOrder = new OrderDto(1L,"new Order");
        return newOrder;
    }

    @GetMapping(value = "getOrder")
    public OrderDto getOrder(@RequestParam OrderDto id) {
        OrderDto exampleOrder = new OrderDto(1L,"example Order");
        return exampleOrder;
    }

    @PutMapping(value = "updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        OrderDto updatedOrder = new OrderDto(2L, "updated status");
        return updatedOrder;
    }

    @DeleteMapping(value = "deleteOrder")
    public OrderDto deleteOrder(@RequestParam OrderDto id) {
        return null;
    }
}
