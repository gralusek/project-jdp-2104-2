package com.kodilla.ecommercee.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private GroupDto groupsDto;
}
