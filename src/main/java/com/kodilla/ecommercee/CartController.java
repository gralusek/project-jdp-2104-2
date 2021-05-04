package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @PostMapping(value = "createCart")
    public void createCart(@RequestBody CartDto cartDto){

    }

    @GetMapping(value = "getFromCart")
    public List<CartDto> getFromCart(){
        List<CartDto> cart = new ArrayList<>();
        return cart;
    }

    @PutMapping(value = "addElementToCart")
    public void addElementToCart(@RequestBody CartDto cartDto){
    }

    @DeleteMapping(value = "deleteElementFromCart")
    public void deleteElementFromCart(@RequestParam Long id){
    }

    @PostMapping(value = "createOrder")
    public void createOrder(@RequestBody CartDto cartDto){
    }
}
