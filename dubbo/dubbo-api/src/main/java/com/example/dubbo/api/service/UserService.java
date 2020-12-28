package com.example.dubbo.api.service;


import com.example.dubbo.api.model.User;

import java.util.List;

public interface UserService {

    User selectByPrimaryKey(Integer id);


    List<User> selectByAge(Integer age);
}
