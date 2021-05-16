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

    @Autowired
    CartMapper cartMapper;

    public Order mapToOrder(final OrderDto orderDto) {
        return new Order(
                orderDto.getId(),
                orderDto.getStatus(),
                userMapper.mapToUser(orderDto.getUserDto()),
                cartMapper.mapToCart(orderDto.getCartDto())
        );
    }

    public OrderDto mapToOrderDto(final Order order) {
        return new OrderDto(
                order.getOrderId(),
                order.getStatus(),
                userMapper.mapToUserDto(order.getUser()),
                cartMapper.mapToCartDto(order.getCart())
        );
    }

   public List<OrderDto> mapToOrderDtoList(final List<Order> ordersList) {
        return ordersList.stream()
                .map(order -> new OrderDto(
                        order.getOrderId(),
                        order.getStatus(),
                        userMapper.mapToUserDto(order.getUser()),
                        cartMapper.mapToCartDto(order.getCart())
                ))
                .collect(Collectors.toList());
    }

    public List<Order> mapToOrderList(final List<OrderDto> ordersDtoList) {
        return ordersDtoList.stream()
                .map(orderDto -> new Order(
                        orderDto.getId(),
                        orderDto.getStatus(),
                        userMapper.mapToUser(orderDto.getUserDto()),
                        cartMapper.mapToCart(orderDto.getCartDto())
                ))
                .collect(Collectors.toList());
    }
}