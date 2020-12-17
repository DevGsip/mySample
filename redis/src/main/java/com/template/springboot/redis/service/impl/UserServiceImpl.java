package com.template.springboot.redis.service.impl;

import com.template.springboot.redis.mapper.UserMapper;
import com.template.springboot.redis.model.User;
import com.template.springboot.redis.service.UserService;
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
