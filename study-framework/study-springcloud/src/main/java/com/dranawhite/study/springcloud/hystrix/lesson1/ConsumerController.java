package com.dranawhite.study.springcloud.hystrix.lesson1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * -Dspring.profiles.active=hystrix-1
 *
 * @author dranawhite
 * @version : ConsumerController.java, v 0.1 2019-07-12 14:52 dranawhite Exp $$
 */
@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping(value = "/hello")
    public String consumer() {
        return consumerService.consumer();
    }
}
