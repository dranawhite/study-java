package com.dranawhite.study.springboot.spring;

import com.dranawhite.study.springboot.model.user.RoleTypeEnum;
import com.dranawhite.study.springboot.model.user.RoleVO;
import com.dranawhite.study.springboot.model.user.UserVO;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dranawhite
 * @version : UserConfig.java, v 0.1 2019-07-29 17:45 dranawhite Exp $$
 */
@Configuration
public class UserConfig {

    @Bean
    public UserVO user() {
        UserVO user = new UserVO();
        user.setId(12);
        user.setName("Jerry");
        RoleVO role = new RoleVO();
        role.setId(1);
        role.setName(RoleTypeEnum.ADMIN.name());
        role.setRoleType(RoleTypeEnum.ADMIN);
        List<RoleVO> roleList = new ArrayList<>();
        roleList.add(role);
        user.setRoleList(roleList);
        return user;
    }
}
