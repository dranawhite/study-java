package com.dranawhite.study.springcloud.eureka.lesson1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka测试工程
 *
 * @author dranawhite
 * @version : Application.java, v 0.1 2019-07-10 17:08 dranawhite Exp $$
 */
@EnableEurekaServer
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {
        "com.dranawhite.study.springcloud.eureka.lesson1"
})
public class ApplicationLesson1 {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApplicationLesson1.class);
        application.run(args);
    }
}
