package com.study.boot.web;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;

/**
 *
 * @author dranawhite
 * @version $Id: SpringConfig.java, v 0.1 2019-01-15 20:43 dranawhite Exp $$
 */
@Configuration
public class SpringConfig {

    @Bean
    public FilterRegistrationBean webFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new WebFilter());
        registrationBean.setOrder(1);
        registrationBean.setName("web-filter");
        registrationBean.addUrlPatterns("/*");
        registrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD);
        return registrationBean;
    }
}
