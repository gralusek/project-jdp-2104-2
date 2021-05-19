package com.kodilla.ecommercee.mappers;

import com.kodilla.ecommercee.Dto.OrderDto;
import com.kodilla.ecommercee.domain.Order;

public class OrderMapper {
    public OrderDto mapToOrderDto(final Order order) {
        return new OrderDto();
    }

    public Order mapToOrder(final OrderDto orderDto){
        return new Order();
    }
}
