package com.dranawhite.study.springcloud.zuul.lesson2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author dranawhite
 * @version : SpringConfig.java, v 0.1 2019-07-12 11:42 dranawhite Exp $$
 */
@Configuration
public class SpringConfig {

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
