package com.controller;

import com.model.User;
import com.model.Users;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public Users loadAll(@RequestHeader(name = "X-COM-PERSIST", required = true) String persistHeader,
                         @RequestHeader(name = "X-COM-LOCATION", required = false) String locationHeader) {
        return userService.getList();
    }

    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        userService.addUser(user);

        return ResponseEntity.ok("User created successfully");
    }

}
