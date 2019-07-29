package com.dranawhite.study.springboot.security;

import com.dranawhite.study.springboot.model.user.UserSecurityVO;
import com.dranawhite.study.springboot.model.user.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author dranawhite
 * @version : UserService.java, v 0.1 2019-07-27 15:46 dranawhite Exp $$
 */
@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserVO user;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user.setName(username);
        return (UserSecurityVO) user;
    }
}
