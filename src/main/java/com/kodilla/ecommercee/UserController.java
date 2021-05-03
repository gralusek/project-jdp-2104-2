package com.kodilla.ecommercee;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group_project/user")
@RequiredArgsConstructor
public class UserController {

    //PLACE FOR PARAMETERS

    @PostMapping(value = "createUser"/*, consumes = MediaType.APPLICATION_JSON_VALUE*/)
    public void createUser(/*@RequestBody userDto userDto*/) {
        
    }

    @PutMapping(value = "blockUser")
    public void blockUser(@RequestParam int userId) {

    }

    @PutMapping(value = "generateKey")
    public int generateKey(@RequestParam int userId) {
        int key = 123456789;
        return key;
    }
}
