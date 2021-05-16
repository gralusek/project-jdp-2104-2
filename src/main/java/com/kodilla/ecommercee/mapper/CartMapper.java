package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.Dto.CartDto;
import com.kodilla.ecommercee.Dto.OrderDto;
import com.kodilla.ecommercee.Dto.ProductDto;
import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartMapper {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    OrderMapper orderMapper;

    public Cart mapToCart(final CartDto cartDto) {
        return new Cart(
                cartDto.getId(),
                productMapper.mapToProductList(cartDto.getProductDtoList()),
                orderMapper.mapToOrder(cartDto.getOrderDto())
        );
    }

    public CartDto mapToCartDto(final Cart cart) {
        return new CartDto(
                cart.getCartId(),
                productMapper.mapToProductDtoList(cart.getProducts()),
                orderMapper.mapToOrderDto(cart.getOrder())
        );
    }

    public List<Cart> mapToCartsList(final List<CartDto> carstDtoList) {
        return carstDtoList.stream()
                .map(cartDto -> new Cart(
                        cartDto.getId(),
                        productMapper.mapToProductList(cartDto.getProductDtoList()),
                        orderMapper.mapToOrder(cartDto.getOrderDto())
                ))
                .collect(Collectors.toList());
    }

    public List<CartDto> mapToCartsListDto(final List<Cart> cartsList) {
        return cartsList.stream()
                .map(cart -> new CartDto(
                        cart.getCartId(),
                        productMapper.mapToProductDtoList(cart.getProducts()),
                        orderMapper.mapToOrderDto(cart.getOrder())
                ))
                .collect(Collectors.toList());
    }
}

