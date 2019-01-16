package com.study.springmvc.service;

import org.springframework.stereotype.Service;

/**
 * @author dranawhite 2018/1/17
 */
@Service("simpleService")
public class SimpleService {

    public void doService() {
        System.out.println("执行Service方法");
    }

}
