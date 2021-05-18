package com.kodilla.ecommercee.Dto;

import com.kodilla.ecommercee.domain.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private OrderStatus orderStatus;
    private UserDto userDto;
    private CartDto cartDto;
}
