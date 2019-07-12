package com.dranawhite.study.springcloud.eureka.lesson4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author dranawhite
 * @version : ConsumerController.java, v 0.1 2019-07-11 13:56 dranawhite Exp $$
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer")
    public String helloConsumer() {
        return restTemplate.getForObject("http://study-springcloud/hello", String.class);
    }

}
