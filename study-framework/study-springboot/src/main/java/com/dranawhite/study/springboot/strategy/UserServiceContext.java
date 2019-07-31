package com.dranawhite.study.springboot.strategy;

import com.dranawhite.study.springboot.model.user.RoleTypeEnum;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Spring注入集合类型
 *
 * @author dranawhite
 * @version : UserServiceConfig.java, v 0.1 2019-07-29 17:11 dranawhite Exp $$
 */
@Service
@Slf4j
public class UserServiceContext {

    @Autowired
    private List<IUserService> userServiceList;

    @Autowired
    private Set<IUserService> userServiceSet;

    @Autowired
    private Map<String, IUserService> userServiceMap;

    public String printRoleName(RoleTypeEnum typeEnum) {
        return findUserService(typeEnum).printRoleName();
    }

    private IUserService findUserService(RoleTypeEnum typeEnum) {
        for (IUserService userService : userServiceList) {
            if (userService.getRoleType() == typeEnum) {
                return userService;
            }
        }
        return null;
    }
}
