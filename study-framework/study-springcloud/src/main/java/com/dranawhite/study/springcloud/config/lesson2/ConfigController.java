package com.dranawhite.study.springcloud.config.lesson2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dranawhite
 * @version : ConfigController.java, v 0.1 2019-07-12 18:10 dranawhite Exp $$
 */
@RefreshScope
@RestController
@EnableAutoConfiguration
public class ConfigController {

    @Value("${from}")
    private String from = "World!";

    @GetMapping(value = "/config")
    public String config() {
        return "Hello " + this.from;
    }
}
