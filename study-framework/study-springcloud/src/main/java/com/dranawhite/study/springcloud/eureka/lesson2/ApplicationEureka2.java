package com.dranawhite.study.springcloud.eureka.lesson2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka测试工程
 * <pre>
 *     -Dspring.profiles.active=eureka-peer1
 *     -Dspring.profiles.active=eureka-peer2
 * </pre>
 *
 * @author dranawhite
 * @version : Application.java, v 0.1 2019-07-10 17:08 dranawhite Exp $$
 */
@EnableEurekaServer
@SpringBootApplication(scanBasePackages = {
        "com.dranawhite.study.springcloud.eureka.lesson2"
})
public class ApplicationEureka2 {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApplicationEureka2.class);
        application.run(args);
    }
}
