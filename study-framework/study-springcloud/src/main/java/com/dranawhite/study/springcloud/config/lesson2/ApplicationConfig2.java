package com.dranawhite.study.springcloud.config.lesson2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <pre>
 *     -Dspring.profiles.active=config-2
 * </pre>
 *
 * @author dranawhite
 * @version : ApplicationConfig2.java, v 0.1 2019-07-12 18:05 dranawhite Exp $$
 */
@SpringBootApplication(scanBasePackages = {
        "com.dranawhite.study.springcloud.config.lesson2"
})
@EnableDiscoveryClient
public class ApplicationConfig2 {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApplicationConfig2.class);
        application.run(args);
    }
}
