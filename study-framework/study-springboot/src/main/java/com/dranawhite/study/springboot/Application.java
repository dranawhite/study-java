package com.dranawhite.study.springboot;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * D:/mail              java -jar fakeSTMP-2.0.jar开启mail测试服务器 D:/redis             redis-server开启Redis服务端
 * D:/apache-kafka      bin/zookeeper-server-start.sh config/zookeeper.properties开启zk D:/apache-kafka
 * bin/kafka-server-start.sh config/server.properties开启kafka
 *
 * @author dranawhite
 * @version : Application.java, v 0.1 2019-07-26 11:31 dranawhite Exp $$
 */
@SpringBootApplication(scanBasePackages = {
        "com.dranawhite.study.springboot"
})
@EnableAdminServer
public class Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.run(args);
    }
}
