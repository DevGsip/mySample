package com.example.mongo.controller;

import com.alibaba.fastjson.JSON;
import com.example.mongo.dao.UserDao;
import com.example.mongo.model.User;
import com.example.mongo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private UserDao userDao;

    @GetMapping("/{id}")
    public String selectByPrimaryKey(@PathVariable(value = "id") Integer id){
        User user = userService.selectByPrimaryKey(id);
        if (user == null){
            return StringUtils.EMPTY;
        }
        userDao.insert(user);
        return JSON.toJSONString(user);
    }


    @GetMapping("/list")
    public String listUser(){
        List<User> users = userDao.listUser();
        return JSON.toJSONString(users);
    }

    @GetMapping("/update/{id}")
    public String updateByPrimaryKey(@PathVariable(value = "id") Integer id){
        User user = userService.selectByPrimaryKey(id);
        if (user == null){
            return StringUtils.EMPTY;
        }
        user.setAccount(user.getAccount() + "-update");

        userDao.updateByPrimaryKeySelective(user);
        return JSON.toJSONString(user);
    }

}
