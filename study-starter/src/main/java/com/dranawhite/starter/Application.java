package com.dranawhite.starter;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author dranawhite
 * @version : Application.java, v 0.1 2019-08-28 19:11 dranawhite Exp $$
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        ApplicationContext ctx = application.run(args);

        HelloService helloService = ctx.getBean(HelloService.class);
        System.out.println("Invoke SayHello!");
        System.out.println(helloService.sayHello());
    }
}
