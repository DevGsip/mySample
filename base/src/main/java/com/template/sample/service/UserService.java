package com.template.sample.service;


import com.template.sample.model.User;
import java.util.List;

public interface UserService {

    User selectByPrimaryKey(Integer id);


    List<User> selectByAge(Integer age);
}
