package com.study.spring.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liangyq 2017/12/27
 */
@Service
public class UserService {

    private static Map<Integer, User> userMap = new HashMap();

    static {
        User user = new User();
        user.setId(1001);
        user.setAge(25);
        user.setName("tony");
        userMap.put(1001, user);
    }

    @Cacheable(cacheNames = "user")
    public User getUserById(int id) {
        //缓存的KEY默认是按照所有的入参组装而成
        System.out.println("直接执行方法，不走缓存");
        return userMap.get(id);
    }

    @Cacheable(cacheNames = "ehcache")
    public User getUser(int id) {
        //缓存的KEY默认是按照所有的入参组装而成
        System.out.println("直接执行方法，不走缓存");
        return userMap.get(id);
    }

    public void updateUserMap(int id) {
        User user = userMap.get(id).clone();
        user.setName("tom");
        userMap.put(id, user);
    }

    public User getUserFromMap(int id) {
        return userMap.get(id);
    }
}
