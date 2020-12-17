package com.template.springboot.redis.service;

import com.template.springboot.redis.model.User;

import java.util.List;

public interface UserService {

    User selectByPrimaryKey(Integer id);


    List<User> selectByAge(Integer age);
}
