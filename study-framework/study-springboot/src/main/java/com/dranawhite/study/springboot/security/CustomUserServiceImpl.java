package com.dranawhite.study.springboot.security;

import com.dranawhite.common.converter.BeanConverter;
import com.dranawhite.study.springboot.model.user.UserSecurityVO;
import com.dranawhite.study.springboot.model.user.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Spring Security判断UserDetailsService是否是UserDetailsPassowrdService的实例，如果是的话，则使用它作为默认的UserDetalsPasswordService
 *
 * @author dranawhite
 * @version : UserService.java, v 0.1 2019-07-27 15:46 dranawhite Exp $$
 */
@Service
public class CustomUserServiceImpl implements UserDetailsService, UserDetailsPasswordService {

    @Autowired
    private UserVO user;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user.setName(username);
        UserSecurityVO userSecurity = BeanConverter.convert(user, UserSecurityVO.class);
        userSecurity.setPassword(passwordEncoder.encode(username));
        return userSecurity;
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        UserSecurityVO userSecurity = (UserSecurityVO) user;
        userSecurity.setPassword(newPassword);
        return userSecurity;
    }
}
