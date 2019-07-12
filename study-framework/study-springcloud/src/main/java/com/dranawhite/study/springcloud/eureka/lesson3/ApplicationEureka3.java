package com.dranawhite.study.springcloud.eureka.lesson3;

import com.dranawhite.study.springcloud.eureka.lesson1.ApplicationEureka1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <pre>
 *     -Dspring.profiles.active=eureka-client
 * </pre>
 *
 * @author dranawhite
 * @version : ApplicationLesson3.java, v 0.1 2019-07-11 10:58 dranawhite Exp $$
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {
        "com.dranawhite.study.springcloud.eureka.lesson3"
})
public class ApplicationEureka3 {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApplicationEureka1.class);
        application.run(args);
    }
}
