package com.kodilla.ecommercee.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Getter
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private GroupDto groupsDto;
    private List<CartDto> cartDtoList;
}
