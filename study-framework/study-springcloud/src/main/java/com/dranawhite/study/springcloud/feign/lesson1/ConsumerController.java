package com.dranawhite.study.springcloud.feign.lesson1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * -Dspring.profiles.active=feign-1
 *
 * @author liangyuquan
 * @version : ConsumerController.java, v 0.1 2019-07-12 15:41 liangyuquan Exp $$
 */
@RestController
public class ConsumerController {

    @Autowired
    private IConsumerService consumerService;

    @GetMapping(value = "/consume")
    public String consume() {
        return consumerService.consume();
    }
}
