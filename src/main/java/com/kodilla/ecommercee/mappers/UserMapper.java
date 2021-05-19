package com.kodilla.ecommercee.mappers;
import com.kodilla.ecommercee.Dto.UserDto;
import com.kodilla.ecommercee.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    @Autowired
    private OrderMapper orderMapper;

    public User mapToUser(final UserDto userDto){
        return new User(
                userDto.getUserId(),
                userDto.getUsername(),
                userDto.isBlocked(),
                userDto.getUserKey(),
                userDto.getKeyValidDate(),
                orderMapper.mapToOrderList(userDto.getOrderDtos())
        );
    }

    public UserDto mapToUserDto(final User user){
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
