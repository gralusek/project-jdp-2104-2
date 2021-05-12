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
                userMapper. //co tutaj dalej
        );
    }

   public List<OrderDto> mapToOrderDtoList(final List<Order> ordersList) {
        return ordersList.stream()
                .map(this::mapToOrderDtoList) // to na czerowno mi świeci
                .collect(Collectors.toList());
    }
}