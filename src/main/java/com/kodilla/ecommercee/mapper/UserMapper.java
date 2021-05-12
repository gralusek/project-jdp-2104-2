package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.Dto.UserDto;
import com.kodilla.ecommercee.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    @Autowired
    OrderMapper orderMapper;

    public User maptoUser(final UserDto userDto) {
        return new User(
                userDto.getUserId(),
                userDto.getUsername(),
                userDto.isBlocked(),
                userDto.getUserKey(),
                userDto.getKeyValidDate(),
                orderMapper.mapToOrderDtoList(userDto.getOrders()) // to w nawiasie też na czerwono
        );
    }
}
