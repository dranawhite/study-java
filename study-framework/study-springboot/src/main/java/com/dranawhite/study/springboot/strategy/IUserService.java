package com.dranawhite.study.springboot.strategy;

import com.dranawhite.study.springboot.model.user.RoleTypeEnum;
import com.dranawhite.study.springboot.model.user.UserVO;

import javax.validation.Valid;

/**
 * @author dranawhite
 * @version : IUserService.java, v 0.1 2019-07-29 17:07 dranawhite Exp $$
 */
public interface IUserService {

    /**
     * 打印角色名称
     *
     * @return RoleName
     */
    String printRoleName();

    /**
     * 获取角色类型
     *
     * @return RoleType
     */
    RoleTypeEnum getRoleType();

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     */
    void saveUser(@Valid UserVO user);
}
