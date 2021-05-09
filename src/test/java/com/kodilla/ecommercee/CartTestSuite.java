package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderStatus;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.exceptions.CartNotExist;
import com.kodilla.ecommercee.exceptions.ProductNotExist;
import com.kodilla.ecommercee.repositories.CartRepository;
import com.kodilla.ecommercee.repositories.OrderRepository;
import com.kodilla.ecommercee.repositories.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTestSuite {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void cartCreateTest () {
        //Given
        Cart cart = new Cart();
        Product product = new Product();
        Order order = new Order();
        cart.getProducts().add(product);
        cart.setOrder(order);
        product.getCarts().add(cart);
        order.setStatus(OrderStatus.ACCEPTED_FOR_REALISATION);
        cartRepository.save(cart);

        //When
        long cartId = cart.getCartId();
        long result = cartRepository.count();

        //Then
        assertEquals(1, result);

        //Clean up
        try {
            cartRepository.deleteById(cartId);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void cartReadTest () throws CartNotExist {
        //Given
        Cart cart = new Cart();
        Product product = new Product();
        Order order = new Order();
        cart.getProducts().add(product);
        cart.setOrder(order);
        product.getCarts().add(cart);
        order.setStatus(OrderStatus.ACCEPTED_FOR_REALISATION);
        cartRepository.save(cart);

        //When
        long cartId = cart.getCartId();
        Cart result = cartRepository.findById(cartId).orElseThrow(CartNotExist::new);

        //Then
        assertEquals(cartId, result.getCartId());

        //Clean up
        try {
            cartRepository.deleteById(cartId);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void cartUpdateTest () throws CartNotExist {
        //Given
        Cart cart = new Cart();
        Product product = new Product();
        Order order = new Order();
        cart.getProducts().add(product);
        cart.setOrder(order);
        product.getCarts().add(cart);
        order.setStatus(OrderStatus.ACCEPTED_FOR_REALISATION);
        cartRepository.save(cart);

        //When
        long cartId = cart.getCartId();
        Cart result = cartRepository.findById(cartId).orElseThrow(CartNotExist::new);
        result.getOrder().setStatus(OrderStatus.CANCELLED);

        //Then
        assertEquals(OrderStatus.CANCELLED, result.getOrder().getStatus());

        //Clean up
        try {
            cartRepository.deleteById(cartId);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void cartDeleteTest () {
        //Given
        Cart cart = new Cart();
        Product product = new Product();
        Order order = new Order();
        cart.getProducts().add(product);
        cart.setOrder(order);
        product.getCarts().add(cart);
        order.setStatus(OrderStatus.ACCEPTED_FOR_REALISATION);
        cartRepository.save(cart);

        //When
        long cartId = cart.getCartId();

        try {
            cartRepository.deleteById(cartId);
        } catch (Exception e) {
            //do nothing
        }

        //Then
        assertFalse(cartRepository.existsById(cartId));
    }

    @Test
    public void relationsTest () throws ProductNotExist {
        //Given
        Cart cart = new Cart();
        Product product = new Product();
        Product product2 = new Product();
        Order order = new Order();
        cart.getProducts().add(product);
        cart.getProducts().add(product2);
        cart.setOrder(order);
        product.getCarts().add(cart);
        product2.getCarts().add(cart);
        order.setStatus(OrderStatus.ACCEPTED_FOR_REALISATION);
        cartRepository.save(cart);

        //When & Then
        assertEquals(1,orderRepository.count());
        assertEquals(2,productRepository.count());

        //Clean Up
        try{
            cartRepository.deleteById(cart.getCartId());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
