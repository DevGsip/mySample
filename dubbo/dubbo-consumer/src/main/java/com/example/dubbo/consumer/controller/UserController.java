package com.example.dubbo.consumer.controller;

import com.alibaba.fastjson.JSON;
import com.example.dubbo.api.model.User;
import com.example.dubbo.consumer.service.UserService;
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

    @GetMapping("/{id}")
    public String selectByPrimaryKey(@PathVariable(value = "id") Integer id){
        log.info("com.template.sample.controller.UserController.selectByPrimaryKey id:{}",id);
        User user = userService.selectByPrimaryKey(id);
        log.info("com.template.sample.controller.UserController.selectByPrimaryKey user:{}",user);
        if (user == null){
            return StringUtils.EMPTY;
        }
        return JSON.toJSONString(user);
    }

    @GetMapping("/list/{age}")
    public String selectByAge(@PathVariable(value = "age") Integer age){
        log.info("com.template.sample.controller.UserController.selectByPrimaryKey id:{}",age);
        List<User> users = userService.selectByAge(age);
        log.info("com.template.sample.controller.UserController.selectByPrimaryKey user:{}",users);
        if (users == null){
            return StringUtils.EMPTY;
        }
        return JSON.toJSONString(users);
    }

}
