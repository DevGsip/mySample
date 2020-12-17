package com.template.springboot.redis.controller;

import com.alibaba.fastjson.JSON;
import com.template.springboot.redis.model.User;
import com.template.springboot.redis.service.RedisService;
import com.template.springboot.redis.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private RedisService redisService;

    @GetMapping("/{id}")
    public String selectByPrimaryKey(@PathVariable(value = "id") Integer id){
        String key = "UserController:selectByPrimaryKey:" + id;
        Object userObj = redisService.get(key+"obj");
        String userStr = redisService.getStrVal(key);
        if (StringUtils.isNotBlank(userStr)){
            return userStr;
        }

        User user = userService.selectByPrimaryKey(id);
        if (user == null){
            return StringUtils.EMPTY;
        }
        userStr = JSON.toJSONString(user);
        redisService.set(key,userStr);
        redisService.set(key+"obj",user);
        return userStr;
    }

}
