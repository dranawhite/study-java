package com.study.pattern.proxy.statics;

import com.study.pattern.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dranawhite
 * @version : UserServiceProxy.java, v 0.1 2019-08-07 11:17 dranawhite Exp $$
 */
public class UserServiceProxy implements IUserService {

    private List<IUserService> userServiceList = new ArrayList<>();

    void addUserService(IUserService userService) {
        userServiceList.add(userService);
    }

    @Override
    public void printUserName(User user) {
        for (IUserService userService : userServiceList) {
            if (userService.isSuitable(user)) {
                System.out.println("Before Invoke!");
                userService.printUserName(user);
                System.out.println("After Invoke!");
                return;
            }
        }
    }

    @Override
    public boolean isSuitable(User user) {
        return false;
    }
}
