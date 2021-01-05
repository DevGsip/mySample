package com.example.mongo.service.impl;


import com.example.mongo.mapper.UserMapper;
import com.example.mongo.model.User;
import com.example.mongo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> selectByAge(Integer age) {
        return null;
    }
}
