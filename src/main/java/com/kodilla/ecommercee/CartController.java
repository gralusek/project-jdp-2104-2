package com.kodilla.ecommercee;

import com.kodilla.ecommercee.Dto.CartDto;
import com.kodilla.ecommercee.Dto.OrderDto;
import com.kodilla.ecommercee.Dto.ProductDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @GetMapping(value = "getCart")
    public CartDto getCart(@RequestParam Long cartId, @RequestParam String status){
        return new CartDto(cartId, new ArrayList<>(), new OrderDto());
    }

    @PostMapping(value = "createCart", consumes = MediaType.APPLICATION_JSON_VALUE )
    public void createCart(@RequestBody CartDto cartDto){

    }

    @GetMapping(value = "getFromCart")
    public List<ProductDto> getFromCart(@RequestParam Long cartId){
        List<ProductDto> products = new ArrayList<>();
        return products;
    }

    @PutMapping(value = "addElementToCart")
    public void addElementToCart(@RequestParam Long productId, @RequestParam Long cartId){
    }

    @DeleteMapping(value = "deleteElementFromCart")
    public void deleteElementFromCart(@RequestParam Long cartId, @RequestParam Long productId){
    }

    @PostMapping(value = "createOrder")
    public void createOrder(@RequestBody OrderDto orderDto){
    }
}