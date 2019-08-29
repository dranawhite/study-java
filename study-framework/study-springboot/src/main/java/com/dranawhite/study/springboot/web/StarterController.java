package com.dranawhite.study.springboot.web;

import com.dranawhite.api.model.DranaResponse;
import com.dranawhite.starter.HelloService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Starter
 * <pre>
 *     加载META-INF/spring.factories中配置的信息
 *     引入spring-boot-configuration-processor包生成json元文件
 * </pre>
 *
 * @author dranawhite
 * @version : StarterController.java, v 0.1 2019-08-29 9:44 dranawhite Exp $$
 */
@RestController
@RequestMapping("/starter")
@Slf4j
public class StarterController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/say")
    public DranaResponse<Boolean> sayHello() {
        log.info("Say Hello!");
        log.info(helloService.sayHello());
        return DranaResponse.success(Boolean.TRUE);
    }
}
