
package com.dranawhite.study.springboot.filter.bloom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author dranawhite
 * @version : RedisBitOperation.java, v 0.1 2019-10-25 9:58 dranawhite Exp $$
 */
@Component
public class RedisBitOperation implements IBitOperation {

    @Autowired
    private RedisService redisService;

    @Override
    public boolean setBit(String key, long offset) {
        return redisService.setBit(key, offset, Boolean.TRUE);
    }

    @Override
    public boolean getBit(String key, long offset) {
        return redisService.getBit(key, offset);
    }
}
