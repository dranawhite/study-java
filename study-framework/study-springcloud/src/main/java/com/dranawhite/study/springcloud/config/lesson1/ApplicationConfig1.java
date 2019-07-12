package com.dranawhite.study.springcloud.config.lesson1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * -Dspring.profiles.active=config-1
 *
 * <pre>
 *     URL访问localhost:4001/cloudconfig/dev/master
 * </pre>
 *
 * @author dranawhite
 * @version : ApplicationConfig1.java, v 0.1 2019-07-12 17:18 dranawhite Exp $$
 */
@EnableConfigServer
@SpringBootApplication
public class ApplicationConfig1 {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApplicationConfig1.class);
        application.run(args);
    }
}
