package com.kodilla.ecommercee.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Getter
@AllArgsConstructor
public class ProductDto {

    private Long productId;
    private String productName;
    private String productDescription;
    private double price;

}