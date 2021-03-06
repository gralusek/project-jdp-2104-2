package com.kodilla.ecommercee.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private GroupDto groupsDto;
    private List<CartDto> cartDtoList;
}