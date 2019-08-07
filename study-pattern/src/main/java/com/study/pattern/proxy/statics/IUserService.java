package com.study.pattern.proxy.statics;

import com.study.pattern.User;

/**
 * @author dranawhite
 * @version : IUserService.java, v 0.1 2019-08-07 11:17 dranawhite Exp $$
 */
public interface IUserService {

    /**
     * 打印用户名称
     *
     * @param user 用户信息
     */
    void printUserName(User user);

    /**
     * 是否可以处理
     *
     * @param user 用户信息
     * @return true or false
     */
    boolean isSuitable(User user);
}
