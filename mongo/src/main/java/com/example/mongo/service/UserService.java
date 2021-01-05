package com.example.mongo.service;



import com.example.mongo.model.User;

import java.util.List;

public interface UserService {

    User selectByPrimaryKey(Integer id);


    List<User> selectByAge(Integer age);
}
