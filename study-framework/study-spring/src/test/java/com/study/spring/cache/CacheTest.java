package com.study.spring.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author liangyq 2017/12/27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:cache/spring-cache.xml")
public class CacheTest {

    @Autowired
    private UserService userService;

    @Test
    public void testCache_simple() {
        User user1 = userService.getUserFromMap(1001).clone();
        User user2 = userService.getUserById(1001).clone();
        userService.updateUserMap(1001);
        User user3 = userService.getUserFromMap(1001).clone();
        User user4 = userService.getUserById(1001).clone();

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        System.out.println(user4);
    }
}
