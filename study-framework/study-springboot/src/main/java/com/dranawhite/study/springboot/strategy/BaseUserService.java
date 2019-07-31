package com.dranawhite.study.springboot.strategy;

import com.dranawhite.study.springboot.model.user.UserVO;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dranawhite
 * @version : BaseUserService.java, v 0.1 2019-07-31 15:33 dranawhite Exp $$
 */
@Slf4j
public abstract class BaseUserService implements IUserService {

    @Override
    public void saveUser(UserVO user) {
        log.info("UserName = [{}]", user.getName());
    }
}
