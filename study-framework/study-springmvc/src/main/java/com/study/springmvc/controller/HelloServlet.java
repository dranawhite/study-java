package com.study.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求URL路径解析，如URL="http://localhost:8080/test-springmvc/hello/print"
 * 则context = study-springmvc; servlet = /hello/print; path = null
 *
 * @author dranawhite 2017/12/14
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/hello")
public class HelloServlet {

    @RequestMapping(value = "/sayHello")
    public void sayHello() {
        System.out.println("Hello World!");
    }

    /**
     * 打印Servlet上下文路径
     */
    @RequestMapping(value = "/print")
    public void printContext(HttpServletRequest request) {
        String contextUrl = request.getContextPath();
        String servletUrl = request.getServletPath();
        String pathUrl = request.getPathInfo();
        System.out.println("context = " + contextUrl);
        System.out.println("servlet = " + servletUrl);
        System.out.println("path = " + pathUrl);
    }

}
