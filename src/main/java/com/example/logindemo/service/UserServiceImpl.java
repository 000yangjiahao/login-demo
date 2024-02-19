package com.example.logindemo.service;

import com.example.logindemo.mappers.UserMapper;
import com.example.logindemo.mybatis.entity.User;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public void registerUser(User user) {
        userMapper.insertUser(user);
    }

}
