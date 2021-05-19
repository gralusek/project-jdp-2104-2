package com.kodilla.ecommercee;

import com.kodilla.ecommercee.Dto.CartDto;
import com.kodilla.ecommercee.Dto.OrderDto;
import com.kodilla.ecommercee.Dto.ProductDto;
import com.kodilla.ecommercee.dbServices.CartDbService;
import com.kodilla.ecommercee.dbServices.OrderDbService;
import com.kodilla.ecommercee.dbServices.ProductDbService;
import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderStatus;
import com.kodilla.ecommercee.exceptions.CartNotExist;
import com.kodilla.ecommercee.exceptions.ProductNotExist;
import com.kodilla.ecommercee.mappers.CartMapper;
import com.kodilla.ecommercee.mappers.OrderMapper;
import com.kodilla.ecommercee.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {
    private final CartMapper cartMapper;
    private final CartDbService cartDbService;
    private final ProductMapper productMapper;
    private final ProductDbService productDbService;
    private final OrderMapper orderMapper;
    private final OrderDbService orderDbService;

    @Autowired
    public CartController(CartMapper cartMapper, CartDbService cartDbService, ProductMapper productMapper, ProductDbService productDbService, OrderMapper orderMapper, OrderDbService orderDbService) {
        this.cartMapper = cartMapper;
        this.cartDbService = cartDbService;
        this.productMapper = productMapper;
        this.productDbService = productDbService;
        this.orderMapper = orderMapper;
        this.orderDbService = orderDbService;
    }

    @GetMapping(value = "getCart")
    public CartDto getCart(@RequestParam Long cartId, @RequestParam OrderStatus status) throws CartNotExist{
        Cart cart = cartDbService.getCart(cartId).orElseThrow(CartNotExist::new);
        return cartMapper.mapToCartDto(cart);
    }

    @PostMapping(value = "createCart", consumes = MediaType.APPLICATION_JSON_VALUE )
    public void createCart(@RequestBody CartDto cartDto){
        Cart cart = cartMapper.mapToCart(cartDto);
        cartDbService.saveCart(cart);
    }

    @GetMapping(value = "getFromCart")
    public List<ProductDto> getFromCart(@RequestParam Long cartId) throws CartNotExist{
        CartDto cartDto = cartMapper.mapToCartDto(cartDbService.getCart(cartId).orElseThrow(CartNotExist::new));
        List<ProductDto> products = cartDto.getProductDtoList();
        return products;
    }

    @PutMapping(value = "addElementToCart")
    public void addElementToCart(@RequestParam Long productId, @RequestParam Long cartId) throws CartNotExist, ProductNotExist {
        CartDto cartDto = cartMapper.mapToCartDto(cartDbService.getCart(cartId).orElseThrow(CartNotExist::new));
        cartDto.getProductDtoList().add(productMapper.mapToProductDto(productDbService.getProduct(productId).orElseThrow(ProductNotExist::new)));
    }

    @DeleteMapping(value = "deleteElementFromCart")
    public void deleteElementFromCart(@RequestParam Long cartId, @RequestParam Long productId) throws CartNotExist, ProductNotExist {
        CartDto cartDto = cartMapper.mapToCartDto(cartDbService.getCart(cartId).orElseThrow(CartNotExist::new));
        cartDto.getProductDtoList().remove(productMapper.mapToProductDto(productDbService.getProduct(productId).orElseThrow(ProductNotExist::new)));
    }

    @PostMapping(value = "createOrder")
    public void createOrder(@RequestBody OrderDto orderDto){
        Order order = orderMapper.mapToOrder(orderDto);
        orderDbService.saveOrder(order);
    }
}