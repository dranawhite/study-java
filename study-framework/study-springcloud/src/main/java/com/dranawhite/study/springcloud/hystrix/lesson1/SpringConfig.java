package com.dranawhite.study.springcloud.hystrix.lesson1;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author dranawhite
 * @version : SpringConfig.java, v 0.1 2019-07-12 14:39 dranawhite Exp $$
 */
@Configuration
public class SpringConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
