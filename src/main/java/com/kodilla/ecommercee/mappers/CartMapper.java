package com.kodilla.ecommercee.mappers;

import com.kodilla.ecommercee.Dto.CartDto;
import com.kodilla.ecommercee.domain.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartMapper {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderMapper orderMapper;

    public Cart mapToCart(final CartDto cartDto){
        return new Cart(
                cartDto.getId(),
                productMapper.mapToProductList(cartDto.getProductDtoList()),
                orderMapper.mapToOrder(cartDto.getOrderDto())
        );
    }

    public CartDto mapToCartDto(final Cart cart){
        return new CartDto(
                cart.getCartId(),
                productMapper.mapToProductDtoList(cart.getProducts()),
                orderMapper.mapToOrderDto(cart.getOrder())
        );
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> carts){
        return carts.stream()
                .map(this::mapToCartDto)
                .collect(Collectors.toList());
    }

    public List<Cart> mapToCartList(final List<CartDto> cartsDto){
        return cartsDto.stream()
                .map(this::mapToCart)
                .collect(Collectors.toList());
    }
}
