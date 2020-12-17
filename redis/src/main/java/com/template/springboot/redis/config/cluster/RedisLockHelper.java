package com.template.springboot.redis.config.cluster;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @ClassName RedisLockHelper
 * @Description: redis实现分布式锁核心类
 * @Author tangzy
 * @Date 2020/8/10
 * @Version V1.0
 **/
@Component
public class RedisLockHelper {

    @Resource

    RedisTemplate<String, Object> redisTemplate;
    /**
     * 最终加强分布式锁
     *
     * @param lock lock值
     * @return 是否获取到
     */
    public boolean lock(String lock,long lockExpire) {
        // 利用lambda表达式
        return (Boolean) redisTemplate.execute((RedisCallback) connection -> {

            long expireAt = System.currentTimeMillis() + lockExpire + 1;
            Boolean acquire = connection.setNX(lock.getBytes(), String.valueOf(expireAt).getBytes());

            if (acquire) {
                return true;
            } else {

                byte[] value = connection.get(lock.getBytes());

                if (Objects.nonNull(value) && value.length > 0) {

                    long expireTime = Long.parseLong(new String(value));
                    // 如果锁已经过期
                    if (expireTime < System.currentTimeMillis()) {
                        // 重新加锁，防止死锁
                        byte[] oldValue = connection.getSet(lock.getBytes(), String.valueOf(System.currentTimeMillis() + lockExpire + 1).getBytes());
                        return Long.parseLong(new String(oldValue)) < System.currentTimeMillis();
                    }
                }
            }
            return false;
        });
    }

    public void safedUnLock(String key, String val) {
        String luaScript = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        redisTemplate.execute(
                (RedisConnection connection) ->connection.eval(
                        luaScript.getBytes(),
                        ReturnType.INTEGER,
                        1,
                        key.getBytes(),
                        val.getBytes())
        );
    }
}
