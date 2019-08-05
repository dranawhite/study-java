package com.dranawhite.study.springboot.spring;

import com.dranawhite.common.exception.DranaRuntimeException;
import com.dranawhite.common.exception.ResultCodeEnum;
import com.dranawhite.study.springboot.filter.LoginFilter;
import com.dranawhite.study.springboot.model.user.RoleTypeEnum;
import com.dranawhite.study.springboot.security.CustomUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutFilter;

/**
 * @author dranawhite
 * @version : SecurityConfig.java, v 0.1 2019-07-27 15:45 dranawhite Exp $$
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserService customUserService;

    @Autowired
    private LoginFilter loginFilter;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        try {
            auth.userDetailsService(customUserService);
        } catch (Exception ex) {
            throw new DranaRuntimeException("Spring Security异常!", ResultCodeEnum.SYSTEM_ERR, ex);
        }
    }

    @Override
    public void configure(HttpSecurity httpSecurity) {
        try {
            // 路径/security/**都需要进行登录校验
            // security/noLogin/**无需进行校验
            httpSecurity.antMatcher("/security/**").addFilterBefore(loginFilter, LogoutFilter.class).authorizeRequests()
                    .antMatchers("/security/noLogin/**").permitAll()
                    .antMatchers("/security/admin/**").hasAnyRole(RoleTypeEnum.ROOT.name(), RoleTypeEnum.ADMIN.name())
                    .anyRequest().authenticated();
//            httpSecurity.requestMatcher(EndpointRequest.toAnyEndpoint()).authorizeRequests().anyRequest().authenticated();
        } catch (Exception ex) {
            throw new DranaRuntimeException("Spring Security异常!", ResultCodeEnum.SYSTEM_ERR, ex);
        }
    }

}
