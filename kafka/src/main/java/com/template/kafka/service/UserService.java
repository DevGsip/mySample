package com.template.kafka.service;


import com.template.kafka.model.User;

import java.util.List;

public interface UserService {

    User selectByPrimaryKey(Integer id);


    List<User> selectByAge(Integer age);
}
