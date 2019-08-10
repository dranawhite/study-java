package com.dranawhite.study.springboot.spring;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * @author dranawhite
 * @version : MethodSecurityConfig.java, v 0.1 2019-08-09 11:34 dranawhite Exp $$
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {


}
