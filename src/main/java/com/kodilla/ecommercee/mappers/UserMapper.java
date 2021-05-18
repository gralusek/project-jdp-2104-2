package com.kodilla.ecommercee.mappers;

import com.kodilla.ecommercee.Dto.OrderDto;
import com.kodilla.ecommercee.Dto.UserDto;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import java.util.*;
import java.util.stream.Collectors;

public class UserMapper {
    private OrderMapper orderMapper;
    public UserDto mapToUserDto(final User user) {
        List<OrderDto> orderDtoList = user.getOrders().stream()
                .map(order -> orderMapper.mapToOrderDto(order))
                .collect(Collectors.toList());

        return new UserDto(user.getUserId(),
                user.getUsername(),
                user.isBlocked(),
                user.getUserKey(),
                user.getKeyValidDate(),
                orderDtoList
                );
    }

    public User mapToUser(final UserDto userDto) {
        List<Order> orderList = userDto.getOrders().stream()
                .map(orderDto -> orderMapper.mapToOrder(orderDto))
                .collect(Collectors.toList());

        return new User(userDto.getUserId(),
                userDto.getUsername(),
                userDto.isBlocked(),
                userDto.getUserKey(),
                userDto.getKeyValidDate(),
                orderList);
    }
}
