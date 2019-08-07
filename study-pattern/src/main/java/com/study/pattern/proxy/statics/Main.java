package com.study.pattern.proxy.statics;

import com.study.pattern.RoleEnum;
import com.study.pattern.User;

/**
 *
 * @author dranawhite
 * @version : Main.java, v 0.1 2019-08-07 11:35 dranawhite Exp $$
 */
public class Main {

    public static void main(String[] args) {
        // 准备数据
        UserServiceProxy userServiceProxy = new UserServiceProxy();
        userServiceProxy.addUserService(new AdminUserService());
        userServiceProxy.addUserService(new CommonUserService());

        User user = new User();
        user.setName("Jerry");
        user.setRoleEnum(RoleEnum.COMMON);

        // 业务处理
        // 隐藏具体实现
        // 打印实际业务方法执行前后日志
        userServiceProxy.printUserName(user);
    }
}
