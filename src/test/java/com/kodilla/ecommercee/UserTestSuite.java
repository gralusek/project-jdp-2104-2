package com.kodilla.ecommercee;

import com.kodilla.ecommercee.dbServices.UserDbService;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.exceptions.OrderNotExist;
import com.kodilla.ecommercee.exceptions.UserNotExist;
import com.kodilla.ecommercee.repositories.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTestSuite {

    @Autowired
    private UserDbService userService;
    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testUserDbService() {
        //Given
        User user = new User("testUserName");

        //When
        userService.saveUser(user);

        //Then
        long id = user.getUserId();
        System.out.println("User id and name: " + user.getUserId() + ", " + user.getUsername());
        Optional<User> result = userService.findUserById(id);
        assertTrue(result.isPresent());

        //CleanUp
        try{
        userService.deleteById(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void testUserGenerateKey() throws UserNotExist {
        //Given
        User user = new User("testUserName");
        user.generateKey();

        //When
        userService.saveUser(user);

        //Then
        long id = user.getUserId();
        User result = userService.findUserById(id).orElseThrow(UserNotExist::new);
        System.out.println("User key and valid: " + result.getUserKey() + ", " + result.getKeyValidDate());
        assertNotNull(result.getUserKey());
        assertNotNull(result.getKeyValidDate());

        //CleanUp
        try{
            userService.deleteById(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void testOfRelations() throws UserNotExist, OrderNotExist {
        //Given
        User user = new User("testUserName");
        Order order = new Order(user);
        user.addOrder(order);

        //When
        userService.saveUser(user);

        //Then
        long userId = user.getUserId();
        long orderId = order.getOrderId();

        assertTrue(orderRepository.findById(orderId).isPresent());
        try {
            userService.deleteById(userId);
        } catch (Exception e) {
            //do nothing
        }
        assertFalse(orderRepository.findById(orderId).isPresent());
    }
}
