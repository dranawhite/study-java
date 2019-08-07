package com.dranawhite.study.pattern.strategy;

import com.dranawhite.study.pattern.RoleEnum;

/**
 * @author dranawhite
 * @version : UserContext.java, v 0.1 2019-08-07 18:01 dranawhite Exp $$
 */
public class UserContext {

    IUserService select(String role) {
        RoleEnum roleEnum = RoleEnum.findByName(role);
        switch (roleEnum) {
            case ADMIN:
                return new AdminUserService();
            case COMMON:
                return new CommonUserService();
            case ROOT:
                return new RootUserService();
            default:
                return new NullUserService();
        }
    }
}
