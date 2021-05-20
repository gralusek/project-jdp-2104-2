package com.kodilla.ecommercee.mappers;

import com.kodilla.ecommercee.Dto.OrderDto;
import com.kodilla.ecommercee.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderMapper {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CartMapper cartMapper;

    public Order mapToOrder(final OrderDto orderDto) {
        return new Order(
                orderDto.getId(),
                orderDto.getOrderStatus(),
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

    public List<Order> mapToOrderList(final List<OrderDto> ordersDto){
        return ordersDto.stream()
                .map(this::mapToOrder)
                .collect(Collectors.toList());
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orders){
        return orders.stream()
                .map(this::mapToOrderDto)
                .collect(Collectors.toList());
    }
}
