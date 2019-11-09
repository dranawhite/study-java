package com.dranawhite.study.springboot.filter.bloom;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author dranawhite
 * @version : RedisService.java, v 0.1 2019-09-27 14:42 dranawhite Exp $$
 */
@Service
public class RedisService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public boolean setBit(String key, long offset, boolean value) {
        return redisTemplate.opsForValue().setBit(key, offset, value);
    }

    public boolean getBit(String key, long offset) {
        return redisTemplate.opsForValue().getBit(key, offset);
    }
}
