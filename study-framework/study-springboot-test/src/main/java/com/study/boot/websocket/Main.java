package com.study.boot.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 *
 * @author dranawhite
 * @version $Id: Main.java, v 0.1 2019-01-15 20:24 dranawhite Exp $$
 */
@SpringBootApplication
@ServletComponentScan(basePackages = {
        "com.study.boot.websocket"
})
public class Main {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Main.class);
        application.run(args);
    }
}
