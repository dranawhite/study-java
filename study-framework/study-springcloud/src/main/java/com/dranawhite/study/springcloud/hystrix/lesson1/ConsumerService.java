package com.dranawhite.study.springcloud.hystrix.lesson1;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author dranawhite
 * @version : RestService.java, v 0.1 2019-07-12 14:39 dranawhite Exp $$
 */
@Service
public class ConsumerService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer() {
        return restTemplate.getForObject("http://study-springcloud/hello", String.class);
    }

    public String fallback() {
        return "error!";
    }
}
