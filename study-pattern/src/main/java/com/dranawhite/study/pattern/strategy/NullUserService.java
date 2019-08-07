package com.dranawhite.study.pattern.strategy;

import com.dranawhite.common.constants.Separator;
import com.dranawhite.study.pattern.RoleEnum;

/**
 * @author dranawhite
 * @version : NullUserService.java, v 0.1 2019-08-07 18:10 dranawhite Exp $$
 */
public class NullUserService implements IUserService {

    @Override
    public void printUserRole() {
        // 当为null时有特殊逻辑，可以使用空对象模式
        // 否则在RoleEnum中直接抛出异常即可
        StringBuilder roleBuilder = new StringBuilder();
        roleBuilder.append(Separator.CH_LEFT_BRACKET);
        for (RoleEnum roleEnum : RoleEnum.values()) {
            roleBuilder.append(roleEnum.name()).append(Separator.COMMA);
        }
        roleBuilder.replace(roleBuilder.length() - 1, roleBuilder.length(), String.valueOf(Separator.CH_RIGHT_BRACKET));
        System.out.println("无效的用户角色, " + roleBuilder.toString());
    }
}
