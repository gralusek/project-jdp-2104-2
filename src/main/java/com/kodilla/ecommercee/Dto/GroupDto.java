package com.kodilla.ecommercee.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class GroupDto {
    private Long groupId;
    private String name;
    private List<ProductDto> productDtoList;
}
