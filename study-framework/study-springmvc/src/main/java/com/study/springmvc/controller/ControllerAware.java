/**
 * ymm56.com Inc. Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.study.springmvc.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author liangyq
 * @version $Id: ControllerAware.java, v 0.1 2018-08-16 20:40 liangyq Exp $$
 */
@Controller("controllerAware")
@RequestMapping("/controllerAware")
public class ControllerAware implements ApplicationContextAware {

    private ApplicationContext ctx;

    @Autowired
    private HttpServletRequest request;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }

    @RequestMapping("/ctx")
    public void bean() {
        System.out.println("Context = " + ctx);
        System.out.println("Request = " + request);
        System.out.println("URL = " + request.getRequestURL());
    }
}
