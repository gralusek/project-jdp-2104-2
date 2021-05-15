package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.Dto.OrderDto;
import com.kodilla.ecommercee.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderMapper {

    @Autowired
    UserMapper userMapper;

    public Order maptoOrder(final OrderDto orderDto) {
        return new Order(
                orderDto.getId(),
                orderDto.getStatus(),
                userMapper.maptoUser(orderDto.getUserDto())
        );
    }

    public OrderDto maptoOrderDto(final Order order) {
        return new OrderDto(
                order.getOrderId(),
                order.getStatus(),
                userMapper.mapToUserDto(order.getUser())
        );
    }

   public List<OrderDto> mapToOrderDtoList(final List<Order> ordersDtoList) {
        return ordersDtoList.stream()
                .map(orderDto -> new OrderDto(
                        orderDto.getOrderId(),
                        orderDto.getStatus(),
                        userMapper.mapToUserDto(orderDto.getUser())
                ))
                .collect(Collectors.toList());
    }

    public List<Order> mapToOrderList(final List<OrderDto> ordersList) {
        return ordersList.stream()
                .map(order -> new Order(
                        order.getId(),
                        order.getStatus(),
                        userMapper.maptoUser(order.getUserDto())
                ))
                .collect(Collectors.toList());
    }
}