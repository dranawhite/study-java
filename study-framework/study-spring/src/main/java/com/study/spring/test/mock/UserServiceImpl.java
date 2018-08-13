package com.study.spring.test.mock;

public class UserServiceImpl implements UserService {

    @Override
    public User findUser() {
        User user = new User();
        user.setUserId(1001);
        user.setPassword("admin");
        return user;
    }
}
