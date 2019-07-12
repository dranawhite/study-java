package com.dranawhite.study.springcloud.zuul.lesson1;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 *
 * @author liangyuquan
 * @version : ApplicationZuul1.java, v 0.1 2019-07-12 10:59 liangyuquan Exp $$
 */
@EnableZuulProxy
@SpringCloudApplication
public class ApplicationZuul1 {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApplicationZuul1.class);
        application.run(args);
    }
}
