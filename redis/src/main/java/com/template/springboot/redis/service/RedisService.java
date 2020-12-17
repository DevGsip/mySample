package com.template.springboot.redis.service;

public interface RedisService {

    boolean set(String key,Object value);

    boolean set(String key,Object value,long expireTime);

    Object get(String key);

    String getStrVal(String key);
}
