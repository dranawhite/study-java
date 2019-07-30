package com.dranawhite.study.springboot.cache;

import com.dranawhite.study.springboot.model.user.UserVO;

import lombok.extern.slf4j.Slf4j;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 开启EnableCaching注解
 *
 * @author dranawhite
 * @version : CacheService.java, v 0.1 2019-07-27 11:31 dranawhite Exp $$
 */
@Service
@Slf4j
public class CacheService {

    @Cacheable(value = "study:user", key = "#id")
    public UserVO getUser(int id) {
        log.info("缓存穿透");
        UserVO user = new UserVO();
        user.setId(id);
        user.setName("Tony");
        return user;
    }

    @CachePut(value = "study:user", key = "#user.id")
    public UserVO saveUser(UserVO user) {
        // Do Nothing
        return user;
    }

    @CacheEvict(value = "study:user", key = "#id")
    public void removeUser(int id) {
        // Do Nothing
    }
}
