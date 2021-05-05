package com.kodilla.ecommercee;

import com.kodilla.ecommercee.Dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    @PostMapping(value = "createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {

    }

    @PutMapping(value = "blockUser")
    public void blockUser(@RequestParam long userId) {

    }

    @PutMapping(value = "generateKey")
    public int generateKey(@RequestParam long userId) {
        int key = 123456789;
        return key;
    }
}
