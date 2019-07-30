package com.dranawhite.study.springboot.web;

import java.io.File;
import java.net.URL;

import com.dranawhite.api.model.DranaResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dranawhite
 * @version : SpelController.java, v 0.1 2019-07-29 17:49 dranawhite Exp $$
 */
@RestController
@RequestMapping("/spel")
@Slf4j
public class SpelController {

    /**
     * 注入普通字符串
     */
    @Value("Hello World!")
    private String commonString;

    /**
     * 注入操作系统属性
     */
    @Value("#{systemProperties['os.name']}")
    private String osName;

    /**
     * 注入表达式计算结果
     */
    @Value("#{T(org.apache.commons.lang3.RandomUtils).nextInt(1, 10)}")
    private int randomNum;

    /**
     * 注入文件内容,
     *
     * Resource:ClassPathResource File:File
     */
    @Value("classpath:static/index.html")
    private File file;

    /**
     * 注入网址内容
     *
     * Resource:UrlResource Url:Url
     */
    @Value("http://www.baidu.com")
    private URL url;

    /**
     * 注入对象属性
     */
    @Value("#{user.name}")
    private String userName;

    @Value("${server.port}")
    private String port;

    @GetMapping("/value")
    public DranaResponse<Boolean> processValue() {
        log.info("CommonString: " + commonString);
        log.info("OsName: " + osName);
        log.info("UserName: " + userName);
        log.info("RandomNum: " + randomNum);
        log.info("File: " + file.getName());
        log.info("Url: " + url.getPath());
        log.info("Port: " + port);
        return DranaResponse.success(Boolean.TRUE);
    }
}
