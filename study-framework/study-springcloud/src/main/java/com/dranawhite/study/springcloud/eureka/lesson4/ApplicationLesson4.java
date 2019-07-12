package com.dranawhite.study.springcloud.eureka.lesson4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @author dranawhite
 * @version : ApplicationLesson4.java, v 0.1 2019-07-11 11:51 dranawhite Exp $$
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {
        "com.dranawhite.study.springcloud.eureka.lesson4"
})
public class ApplicationLesson4 {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApplicationLesson4.class);
        application.run(args);
    }
}
