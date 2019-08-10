package com.dranawhite.study.springboot.spring;

import com.dranawhite.common.exception.DranaRuntimeException;
import com.dranawhite.common.exception.ResultCodeEnum;
import com.dranawhite.study.springboot.filter.LoginFilter;
import com.dranawhite.study.springboot.model.user.RoleTypeEnum;
import com.dranawhite.study.springboot.security.CustomUserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

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
        // csrf跨站请求伪造，要求传送一个X-XSRF-TOKEN的header或者在参数中添加一个_csrf
        // CookieCsrfTokenRepository用cookie中的token跟header或者param中的token比较
        // 在分布式应用中，为了节省效率，多根据一定的规则计算一个token，避免从各种存储中查询token的问题
        try {
            httpSecurity.addFilterBefore(loginFilter, LogoutFilter.class)
                    .csrf().csrfTokenRepository(new CookieCsrfTokenRepository());
            validateRequestUrl(httpSecurity);
        } catch (Exception ex) {
            throw new DranaRuntimeException("Spring Security异常!", ResultCodeEnum.SYSTEM_ERR, ex);
        }
    }

    private ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry validateRequestUrl(HttpSecurity httpSecurity) {
        try {
            // 路径/security/**都需要进行登录校验
            // security/noLogin/**无需进行校验
            // Spring Security的校验流程，登录然后把用户认证信息放到SecurityContextHolder的authentication中
            // 如果没有的话，就通过AnonymousAuthenticationFilter生成一个匿名的用户，判断authenticated()既判断用户是否是匿名的
            // permitAll()不做任何判断，直接返回true; denyAll()不做任何判断，直接返回false
            ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry =
                    httpSecurity.authorizeRequests();
            registry.antMatchers("/security/noLogin/**").permitAll();
            registry.antMatchers("/security/admin/**").hasAnyRole(RoleTypeEnum.ROOT.name(), RoleTypeEnum.ADMIN.name());
            registry.antMatchers("/security/**").authenticated();
            registry.antMatchers("/method/security/**").authenticated();
            registry.anyRequest().permitAll();
            return registry;
        } catch (Exception ex) {
            throw new DranaRuntimeException("Spring Security异常!", ResultCodeEnum.SYSTEM_ERR, ex);
        }
    }
}
