package com.dranawhite.study.springcloud.feign.lesson1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *  <pre>
 *      FeignClient的值为服务名
 *  </pre>
 *
 * @author dranawhite
 * @version : IConsumerService.java, v 0.1 2019-07-12 15:38 dranawhite Exp $$
 */
@FeignClient(value = "study-springcloud")
public interface IConsumerService {

    @GetMapping(value = "/hello")
    String consume();
}
