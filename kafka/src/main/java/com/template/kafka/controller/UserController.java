package com.template.kafka.controller;

import com.alibaba.fastjson.JSON;
import com.template.kafka.service.UserService;
import com.template.kafka.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/{id}")
    public String selectByPrimaryKey(@PathVariable(value = "id") Integer id){
        log.info("com.template.sample.controller.UserController.selectByPrimaryKey id:{}",id);
        User user = userService.selectByPrimaryKey(id);
        log.info("com.template.sample.controller.UserController.selectByPrimaryKey user:{}",user);
        if (user == null){
            return StringUtils.EMPTY;
        }

        String topic = "";// TODO:为配置topic
        kafkaTemplate.send(topic, user.toString());

        return JSON.toJSONString(user);
    }

}
