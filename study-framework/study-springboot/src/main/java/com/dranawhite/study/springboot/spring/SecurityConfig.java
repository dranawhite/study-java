package com.dranawhite.study.springboot.spring;

import com.dranawhite.common.exception.DranaRuntimeException;
import com.dranawhite.common.exception.ResultCodeEnum;
import com.dranawhite.study.springboot.filter.LoginFilter;
import com.dranawhite.study.springboot.model.user.RoleTypeEnum;
import com.dranawhite.study.springboot.security.CustomUserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author dranawhite
 * @version : SecurityConfig.java, v 0.1 2019-07-27 15:45 dranawhite Exp $$
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserServiceImpl customUserService;

    @Autowired
    private LoginFilter loginFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        // AuthenticationConfiguration$LazyPasswordEncoder从ApplicationContext中获取PasswordEncoder的bean作为默认的PasswordEncoder
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        // 进行认证相关的配置，暴露一个AuthenticationManager的构造器
        try {
            auth.userDetailsService(customUserService);
        } catch (Exception ex) {
            throw new DranaRuntimeException("Spring Security异常!", ResultCodeEnum.SYSTEM_ERR, ex);
        }
    }

    @Override
    public void configure(HttpSecurity httpSecurity) {
        // 资源请求相关的鉴权
        try {
            validateRequestUrl(httpSecurity).and()
                    .formLogin();
        } catch (Exception ex) {
            throw new DranaRuntimeException("Spring Security异常!", ResultCodeEnum.SYSTEM_ERR, ex);
        }
    }

    private ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry validateRequestUrl(HttpSecurity httpSecurity) {
        try {
            // 路径/security/**都需要进行登录校验
            // security/noLogin/**无需进行校验
            ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry =
                    httpSecurity.authorizeRequests();
            registry.antMatchers("/security/noLogin/**").permitAll();
            registry.antMatchers("/security/admin/**").hasAnyRole(RoleTypeEnum.ROOT.name(), RoleTypeEnum.ADMIN.name());
            registry.antMatchers("/security/**").authenticated();
            registry.requestMatchers(EndpointRequest.toAnyEndpoint()).authenticated();
            registry.anyRequest().permitAll();
            return registry;
        } catch (Exception ex) {
            throw new DranaRuntimeException("Spring Security异常!", ResultCodeEnum.SYSTEM_ERR, ex);
        }
    }
}
