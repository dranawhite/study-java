package com.dranawhite.study.springboot.security;

import com.dranawhite.study.springboot.model.user.RoleTypeEnum;
import com.dranawhite.study.springboot.model.user.RoleVO;
import com.dranawhite.study.springboot.model.user.UserSecurityVO;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dranawhite
 * @version : UserService.java, v 0.1 2019-07-27 15:46 dranawhite Exp $$
 */
@Service
public class CustomUserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserSecurityVO user = new UserSecurityVO();
        user.setId(12);
        user.setName(username);
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
