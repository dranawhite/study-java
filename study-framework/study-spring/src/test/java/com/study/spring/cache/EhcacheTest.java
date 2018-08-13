package com.study.spring.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author liangyq 2017/12/28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:cache/spring-ehcache.xml")
public class EhcacheTest {

    @Autowired
    private UserService userService;

    @Test
    public void testCache_Simple() {
        User user1 = userService.getUser(1001).clone();
        userService.updateUserMap(1001);
        User user2 = userService.getUser(1001).clone();
        System.out.println(user1);
        System.out.println(user2);
    }

}
