package com.template.kafka.service.impl;

import com.template.kafka.mapper.UserMapper;
import com.template.kafka.model.User;
import com.template.kafka.service.UserService;
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
