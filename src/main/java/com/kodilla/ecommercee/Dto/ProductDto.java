package com.kodilla.ecommercee.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductDto {
    private Long productId;
    private String productName;
    private String productDescription;
    private int price;
}
