package com.example.logindemo.controller;

import com.example.logindemo.mybatis.entity.User;
import com.example.logindemo.service.UserService;
import com.example.logindemo.utils.TokenUtils;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/demo/register")
    public String registerUser(@RequestBody User user) {
        User existingUser = userService.getUserByUsername(user.getUsername());
        if (existingUser != null) {
            return "Username already exists!";
        } else {
            userService.registerUser(user);
            return "User registered successfully!";
        }
    }

    @PostMapping("/demo/login")
    public String loginUser(@RequestBody User user) {
        User existingUser = userService.getUserByUsername(user.getUsername());
        if (existingUser == null) {
            return "User does not exist!";
        } else {
            if (existingUser.getPassword().equals(user.getPassword())) {
                User currentUser =userService.getUserByUsername(user.getUsername());
                String token = TokenUtils.createToken(currentUser.getId().toString(), currentUser.getPassword());
                return token;
            } else {
                return "Incorrect password!";
            }
        }
    }
}
