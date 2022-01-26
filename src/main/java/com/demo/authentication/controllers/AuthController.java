package com.demo.authentication.controllers;

import com.demo.authentication.model.RegistrationRequest;
import com.demo.authentication.model.RegistrationResponse;
import com.demo.authentication.model.User;
import com.demo.authentication.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    private List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{username}")
    private User getUser(@PathVariable String username) {
        return userService.getUser(username);
    }

    @PostMapping("/register")
    private RegistrationResponse getAllUsers(@RequestBody RegistrationRequest requestBody) {
        return userService.saveUser(requestBody);
    }
}
