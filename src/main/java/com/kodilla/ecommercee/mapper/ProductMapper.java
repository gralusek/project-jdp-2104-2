package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.Dto.OrderDto;
import com.kodilla.ecommercee.Dto.ProductDto;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMapper {

    @Autowired
    GroupMapper groupMapper;

    @Autowired
    CartMapper cartMapper;

    public List<ProductDto> mapToProductDtoList(final List<Product> productsList) {
        return productsList.stream()
                .map(product -> new ProductDto(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        groupMapper.mapToGroupDto(product.getGroup()),
                        cartMapper.mapToCartsListDto(product.getCarts())
                ))
                .collect(Collectors.toList());
    }

    public List<Product> mapToProductList(final List<ProductDto> productsDtoList) {
        return productsDtoList.stream()
                .map(productDto -> new Product(
                        productDto.getId(),
                        productDto.getName(),
                        productDto.getDescription(),
                        productDto.getPrice(),
                        groupMapper.mapToGroup(productDto.getGroupsDto()),
                        cartMapper.mapToCartsList(productDto.getCartDtoList())
                ))
                .collect(Collectors.toList());
    }
}