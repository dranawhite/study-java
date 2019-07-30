package com.dranawhite.study.springboot.strategy;

import com.dranawhite.study.springboot.model.user.RoleTypeEnum;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author dranawhite
 * @version : CommonUserService.java, v 0.1 2019-07-29 16:49 dranawhite Exp $$
 */
@Service
@Order(1)
public class CommonUserService implements IUserService {

    @Override
    public String printRoleName() {
        return RoleTypeEnum.COMMON.name();
    }

    @Override
    public RoleTypeEnum getRoleType() {
        return RoleTypeEnum.COMMON;
    }
}
