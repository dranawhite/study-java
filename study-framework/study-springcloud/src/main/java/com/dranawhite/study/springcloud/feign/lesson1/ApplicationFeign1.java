package com.dranawhite.study.springcloud.feign.lesson1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author dranawhite
 * @version : ApplicationFeign1.java, v 0.1 2019-07-12 15:04 dranawhite Exp $$
 */
@SpringBootApplication(scanBasePackages = {
        "com.dranawhite.study.springcloud.feign.lesson1"
})
@EnableDiscoveryClient
@EnableFeignClients
public class ApplicationFeign1 {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApplicationFeign1.class);
        application.run(args);
    }
}
