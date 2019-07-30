package com.dranawhite.study.springboot.strategy;

import com.dranawhite.study.springboot.model.user.RoleTypeEnum;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author dranawhite
 * @version : AdminUserService.java, v 0.1 2019-07-29 16:48 dranawhite Exp $$
 */
@Service
@Order(2)
public class AdminUserService implements IUserService {

    @Override
    public String printRoleName() {
        return RoleTypeEnum.ADMIN.name();
    }

    @Override
    public RoleTypeEnum getRoleType() {
        return RoleTypeEnum.ADMIN;
    }
}
