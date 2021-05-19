package com.kodilla.ecommercee.dbServices;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.repositories.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartDbService {

    private final CartRepository cartRepository;

    public List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }

    public Cart saveCart(final Cart copy){
        return cartRepository.save(copy);
    }

    public Optional<Cart> getCart(final Long id){
        return cartRepository.findById(id);
    }

    public void deleteCart(final Long id){
        cartRepository.deleteById(id);
    }
}
