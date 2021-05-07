package com.kodilla.ecommercee.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class CartDto {
    private Long id;
    private List<ProductDto> productDtoList;
    private OrderDto orderDto;
}
