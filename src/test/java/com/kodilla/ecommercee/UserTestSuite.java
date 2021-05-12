package com.kodilla.ecommercee;

import com.kodilla.ecommercee.dbServices.UserDbService;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.exceptions.UserNotExist;
import com.kodilla.ecommercee.repositories.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTestSuite {

    @Autowired
    private UserDbService userService;
    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testUserCreate() {
        //Given
        User user = new User("testUserName");

        //When
        userService.saveUser(user);

        //Then
        long id = user.getUserId();
        Optional<User> ifpresent = userService.findUserById(id);
        assertTrue(ifpresent.isPresent());

        //Clean up
        try{
            userService.deleteById(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void testUserRead() {
        //Given
        User user = new User("testUserName");

        //When
        userService.saveUser(user);

        //Then
        long id = user.getUserId();
        Optional<User> result = userService.findUserById(id);
        assertTrue(result.isPresent());

        //Clean up
        try{
            userService.deleteById(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @Test
    public void testUserUpdate() throws UserNotExist {
        //Given
        User user = new User("testUserName");

        //When
        userService.saveUser(user);

        //Then
        long id = user.getUserId();
        User result = userService.findUserById(id).orElseThrow(UserNotExist::new);
        result.setUsername("updatedName");
        assertEquals("updatedName", result.getUsername());

        //CleanUp
        try{
            userService.deleteById(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void testUserDelete() {
        //Given
        User user = new User("testUserName");

        //When
        userService.saveUser(user);

        //Then
        long id = user.getUserId();
        try{
            userService.deleteById(id);
        } catch (Exception e) {
            System.out.println(e);
        }
        Optional<User> resultAfterDelete = userService.findUserById(id);
        assertFalse(resultAfterDelete.isPresent());
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
    public void testOfRelation() {
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
            System.out.println(e);
        }
        assertFalse(orderRepository.findById(orderId).isPresent());
    }

}

