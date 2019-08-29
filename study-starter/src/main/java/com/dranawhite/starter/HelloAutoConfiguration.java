package com.dranawhite.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * EnableConfigurationProperties 开启使用配置参数
 * ConditionalOnClass 当IoC中存在指定class时执行
 * ConditionalOnBean  当IoC中存在指定bean时执行
 * ConditionalOnProperty  指定的属性是否有指定的值
 *
 * @author dranawhite
 * @version : HelloAutoConfiguration.java, v 0.1 2019-08-28 19:05 dranawhite Exp $$
 */
@Configuration
@EnableConfigurationProperties(HelloProperties.class)
@ConditionalOnClass(HelloService.class)
@ConditionalOnProperty(
        prefix = "hello",
        value = "enabled",
        matchIfMissing = true
)
public class HelloAutoConfiguration {

    @Autowired
    private HelloProperties properties;

    @Bean
    @ConditionalOnMissingBean(HelloService.class)
    public HelloService service() {
        HelloService service = new HelloService();
        service.setMsg(properties.getMsg());
        service.setShow(properties.isShow());
        return service;
    }
}
