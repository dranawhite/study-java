package com.dranawhite.study.springboot;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author dranawhite
 * @version : Application.java, v 0.1 2019-07-26 11:31 dranawhite Exp $$
 */
@SpringBootApplication(scanBasePackages = {
        "com.dranawhite.study.springboot"
})
@EnableCaching
@EnableAdminServer
public class Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.run(args);
    }
}
