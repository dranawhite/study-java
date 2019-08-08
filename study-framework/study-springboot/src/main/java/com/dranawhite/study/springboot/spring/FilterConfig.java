package com.dranawhite.study.springboot.spring;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.DispatcherType;

/**
 * 配置Filter拦截的URL，并指定Filter顺序
 *
 * @author dranawhite
 * @version : FilterConfig.java, v 0.1 2019-08-06 14:36 dranawhite Exp $$
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<CorsFilter> corsRegistrationBean(CorsFilter corsFilter) {
        FilterRegistrationBean<CorsFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(corsFilter);
        registration.setOrder(1);
        registration.setName("cors-filter");
        registration.addUrlPatterns("/*");
        registration.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD);
        return registration;
    }
}
