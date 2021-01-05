package com.example.mongo.dao;

import com.example.mongo.model.User;

import java.util.List;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    long updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> listUser();
}
