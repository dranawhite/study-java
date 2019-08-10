package com.dranawhite.study.springboot.spring;

import com.dranawhite.study.springboot.security.spel.AdminSecurityExpressionHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * @author dranawhite
 * @version : MethodSecurityConfig.java, v 0.1 2019-08-09 11:34 dranawhite Exp $$
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Bean
    public AdminSecurityExpressionHandler adminSecurityExpressionHandler() {
        return new AdminSecurityExpressionHandler();
    }

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return adminSecurityExpressionHandler();
    }
}
