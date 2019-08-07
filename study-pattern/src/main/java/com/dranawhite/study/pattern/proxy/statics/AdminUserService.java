package com.dranawhite.study.pattern.proxy.statics;

import com.dranawhite.study.pattern.RoleEnum;
import com.dranawhite.study.pattern.User;

/**
 *
 * @author dranawhite
 * @version : AdminUserService.java, v 0.1 2019-08-07 11:32 dranawhite Exp $$
 */
public class AdminUserService implements IUserService {

    @Override
    public void printUserName(User user) {
        System.out.println(user.getName());
    }

    @Override
    public boolean isSuitable(User user) {
        return user.getRoleEnum() == RoleEnum.ADMIN;
    }
}
