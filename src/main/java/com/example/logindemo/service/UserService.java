package com.example.logindemo.service;

import com.example.logindemo.mybatis.entity.User;

public interface UserService {
    User getUserByUsername(String username);

    void registerUser(User user);

}