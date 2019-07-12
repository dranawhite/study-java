package com.dranawhite.study.springcloud.hystrix.lesson1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author dranawhite
 * @version : ApplicationHystrix1.java, v 0.1 2019-07-12 14:37 dranawhite Exp $$
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {
        "com.dranawhite.study.springcloud.hystrix.lesson1"
})
@EnableCircuitBreaker
public class ApplicationHystrix1 {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApplicationHystrix1.class);
        application.run(args);
    }

}
