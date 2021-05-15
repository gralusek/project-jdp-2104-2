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
                orderMapper.mapToOrderList(userDto.getOrders())
        );
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getUserId(),
                user.getUsername(),
                user.isBlocked(),
                user.getUserKey(),
                user.getKeyValidDate(),
                orderMapper.mapToOrderDtoList(user.getOrders())
        );
    }
}
