package com.template.sample.service.impl;

import com.template.sample.mapper.UserMapper;
import com.template.sample.model.User;
import com.template.sample.service.UserService;
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
