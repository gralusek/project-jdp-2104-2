package com.kodilla.ecommercee.mappers;

import com.kodilla.ecommercee.Dto.ProductDto;
import com.kodilla.ecommercee.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMapper {

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private CartMapper cartMapper;

    public Product mapToProduct(final ProductDto productDto){
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                groupMapper.mapToGroup(productDto.getGroupsDto()),
                cartMapper.mapToCartList(productDto.getCartDtoList())
        );
    }

    public ProductDto mapToProductDto(final Product product){
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                groupMapper.mapToGroupDto(product.getGroup()),
                cartMapper.mapToCartDtoList(product.getCarts())
        );
    }

    public List<Product> mapToProductList(final List<ProductDto> products){
        return products.stream()
                .map(this::mapToProduct)
                .collect(Collectors.toList());
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> products){
        return products.stream()
                .map(this::mapToProductDto)
                .collect(Collectors.toList());
    }
}
