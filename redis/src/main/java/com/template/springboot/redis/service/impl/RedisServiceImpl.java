package com.template.springboot.redis.service.impl;

import com.template.springboot.redis.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class RedisServiceImpl implements RedisService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    @Override
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        } catch (Exception e) {
            log.error("redis set(key,value) error:",e);
        }
        return false;
    }

    @Override
    public boolean set(String key, Object value, long expireTime) {
        try {
            if (expireTime > 0) {
                redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            log.error("redis set(key,value,expireTime) error:",e);
            return false;
        }
    }

    @Override
    public Object get(String key) {
        try {
            if (key == null) {
                return null;
            }
            return redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            log.error("redis get error:",e);
        }
        return null;
    }

    @Override
    public String getStrVal(String key) {
        try {
            if (key == null) {
                return null;
            }
            Object res = redisTemplate.opsForValue().get(key);
            if (res != null){
                return res.toString();
            }
        } catch (Exception e) {
            log.error("redis getStrVal error:",e);
        }
        return null;
    }
}
