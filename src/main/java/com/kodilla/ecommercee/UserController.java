package com.kodilla.ecommercee;

import com.kodilla.ecommercee.dbServices.UserDbService;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.exceptions.UserNotExist;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserDbService service;

    @PostMapping(value = "createUser")
    public void createUser(@RequestParam String username) {
        User newUser = new User(username);
        service.saveUser(newUser);
    }

    @PutMapping(value = "blockUser")
    public void blockUser(@RequestParam long userId) throws UserNotExist {
        User user = service.findUserById(userId).orElseThrow(UserNotExist::new);
        user.setBlocked(true);
        service.saveUser(user);
    }

    @PutMapping(value = "generateKey")
    public int generateKey(@RequestParam long userId) throws UserNotExist {
        User user = service.findUserById(userId).orElseThrow(UserNotExist::new);
        int key = service.generateKey(user);
        service.saveUser(user);
        return key;
    }
}
