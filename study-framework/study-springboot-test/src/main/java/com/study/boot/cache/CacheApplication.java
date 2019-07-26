package com.study.boot.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 *
 * @author dranawhite
 * @version : CacheApplication.java, v 0.1 2019-07-25 17:49 dranawhite Exp $$
 */
@SpringBootApplication(
        scanBasePackages = {
                "com.study.boot.cache"
        }
)
@EnableCaching
public class CacheApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(CacheApplication.class);
        application.run(args);
    }
}
