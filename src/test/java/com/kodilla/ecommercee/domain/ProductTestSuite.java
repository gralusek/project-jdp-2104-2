package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.exceptions.ProductNotExist;
import com.kodilla.ecommercee.repositories.CartRepository;
import com.kodilla.ecommercee.repositories.GroupRepository;
import com.kodilla.ecommercee.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductTestSuite {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private CartRepository cartRepository;

    @Test
    public void testCreate(){
        //Given
        Product product = new Product();
        //When
        productRepository.save(product);
        //Then
        assertTrue(productRepository.existsById(product.getId()));
//        assertEquals(1,productRepository.count());
        //Cleanup
        try{
            productRepository.deleteAll();
        } catch (Exception e){
            //do nothing
        }
    }

    @Test
    public void testRead(){
        //Given
        Product product = new Product();
        product.setName("test");
        //When
        productRepository.save(product);
        Optional<Product> output = productRepository.findById(product.getId());
        //Then
        assertTrue(output.isPresent());
        assertEquals("test", product.getName());
        //Cleanup
        try {
            productRepository.deleteAll();
        }catch (Exception e){
            //do nothing
        }
    }

    @Test
    public void testDelete(){
        //Given
        Product product = new Product();
        //When
        productRepository.save(product);
        long id = product.getId();
        productRepository.deleteById(product.getId());
        Optional<Product> output = productRepository.findById(id);
        //Then
        assertFalse(output.isPresent());
    }

    @Test
    public void testUpdate() throws ProductNotExist {
        //Given
        Product product = new Product();
        product.setName("test");
        //When
        productRepository.save(product);
        long id = product.getId();
        Product output = productRepository.findById(id).orElseThrow(ProductNotExist::new);
        output.setName("updated");
        //Then
        assertEquals("updated",output.getName());
        //Cleanup
        try {
            productRepository.deleteAll();
        }catch (Exception e){
            //do nothing
        }
    }

    @Test
    public void testRelations(){
        //Given
        Product product = new Product();
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        Group group = new Group("test");
        //When
        product.setGroup(group);
        product.getCarts().add(cart1);
        product.getCarts().add(cart2);
        productRepository.save(product);
        //Then
        assertTrue(cartRepository.existsById(cart1.getCartId()));
        assertTrue(cartRepository.existsById(cart2.getCartId()));
        assertTrue(groupRepository.existsById(group.getGroupId()));
        //Cleanup
        productRepository.deleteAll();
        groupRepository.deleteAll();
        cartRepository.deleteAll();
    }
}