package com.example.dubbo.consumer.service.impl;



import com.alibaba.dubbo.config.annotation.Reference;
import com.example.dubbo.api.model.User;
import com.example.dubbo.consumer.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Reference
    private com.example.dubbo.api.service.UserService  userService;

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userService.selectByPrimaryKey(id);
    }

    @Override
    public List<User> selectByAge(Integer age) {
        return userService.selectByAge(age);
    }
}
