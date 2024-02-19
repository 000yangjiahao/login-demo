package com.example.logindemo.mappers;

import com.example.logindemo.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUserByUsername(String username);

    void insertUser(User user);

    User selectById(Integer id);
}
