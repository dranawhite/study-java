package com.study.boot.cache;

import com.study.boot.model.User;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author liangyuquan
 * @version : UserService.java, v 0.1 2019-07-25 17:50 liangyuquan Exp $$
 */
@Service
public class UserService {

    @Cacheable(cacheNames = "user", key = "#id")
    public User getUser(int id) {
        User user = new User();
        user.setId(id);
        user.setAge(RandomUtils.nextInt(10, 90));
        user.setName(RandomStringUtils.random(3));
        user.setAddress(RandomStringUtils.random(10));
        return user;
    }

}
