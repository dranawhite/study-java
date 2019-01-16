package com.study.springmvc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author dranawhite 2018/1/18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-aop.xml"})
public class SimpleServiceTest {

    @Autowired
    private SimpleService simpleService;

    @Test
    public void testDoService() {
        simpleService.doService();
    }

}
