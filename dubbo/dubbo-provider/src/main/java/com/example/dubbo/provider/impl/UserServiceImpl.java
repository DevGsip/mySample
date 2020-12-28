package com.example.dubbo.provider.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.example.dubbo.api.model.User;
import com.example.dubbo.api.service.UserService;
import com.example.dubbo.provider.mapper.UserMapper;

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
        return userMapper.selectByAge(age);
    }
}
