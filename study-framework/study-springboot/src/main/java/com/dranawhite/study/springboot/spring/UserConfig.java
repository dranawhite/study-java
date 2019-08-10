package com.dranawhite.study.springboot.spring;

import com.dranawhite.study.springboot.model.user.RoleTypeEnum;
import com.dranawhite.study.springboot.model.user.RoleVO;
import com.dranawhite.study.springboot.model.user.UserVO;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
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
        RoleVO adminRole = new RoleVO();
        adminRole.setId(1);
        adminRole.setName(RoleTypeEnum.ADMIN.name());
        adminRole.setRoleType(RoleTypeEnum.ADMIN);
        RoleVO rootRole = new RoleVO();
        rootRole.setId(2);
        rootRole.setName(RoleTypeEnum.ROOT.name());
        rootRole.setRoleType(RoleTypeEnum.ROOT);
        List<RoleVO> roleList = new ArrayList<>();
        roleList.add(adminRole);
        roleList.add(rootRole);
        user.setRoleList(roleList);
        return user;
    }
}
