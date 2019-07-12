package com.dranawhite.study.springcloud.eureka.lesson3;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dranawhite
 * @version : HelloController.java, v 0.1 2019-07-10 18:50 dranawhite Exp $$
 */
@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/hello")
    public String index() {
        List<String> serviceIdList = discoveryClient.getServices();
        for (String serviceId : serviceIdList) {
            List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances(serviceId);
            if (CollectionUtils.isEmpty(serviceInstanceList)) {
                continue;
            }
            for (ServiceInstance serviceInstance : serviceInstanceList) {
                logger.info("Host: {}, ServiceId: {}", serviceInstance.getHost(), serviceId);
            }
        }
        return "Hello World!";
    }
}
