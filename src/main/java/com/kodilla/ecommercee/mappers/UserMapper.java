package com.kodilla.ecommercee.mappers;

import com.kodilla.ecommercee.Dto.UserDto;
import com.kodilla.ecommercee.domain.User;

public class UserMapper {
    public UserDto mapToUserDto(final User user) {
        return new UserDto(user.getUserId(),
                user.getUsername(),
                user.isBlocked(),
                user.getUserKey(),
                user.getKeyValidDate(),
                user.getOrders());
    }

    public User mapToUser(final UserDto userDto) {
        return new User(userDto.getUserId(),
                userDto.getUsername(),
                userDto.isBlocked(),
                userDto.getUserKey(),
                userDto.getKeyValidDate(),
                userDto.getOrders());
    }
}
