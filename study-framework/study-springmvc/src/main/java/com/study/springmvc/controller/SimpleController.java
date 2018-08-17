package com.study.springmvc.controller;

import com.study.springmvc.service.SimpleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Spring MVC简易实现
 *
 * <pre>
 *     控制器职责划分：
 *     1）前端控制器——DispatcherServlet
 *     2）应用控制器——拆分为处理器映射器(Handler Mapping)进行处理器管理和视图解析器(View Resovler)进行视图管理
 *     3）页面处理器——Controller接口（仅包含ModelAndView handleRquest(request, response)方法的实现）
 *
 *     图片：
 *          /src/main/java/docs/controller/简易MVC运行原理图.png
 *          /src/main/java/docs/controller/MVC处理请求图.png
 *          /src/main/java/docs/controller/Spring MVC架构运行图.png
 * </pre>
 *
 * @author dranawhite 2017/12/14
 * @version 1.0
 */
@Controller
@RequestMapping("/simple")
public class SimpleController {

    @Autowired
    private SimpleService simpleService;

    @RequestMapping("/print")
    public ModelAndView printHello() {
        //收集参数
        //绑定参数到命令对象
        //调用业务对象
        //选择下一个页面
        ModelAndView mav = new ModelAndView();
        //添加模型数据
        mav.addObject("message", "Hello World!");
        //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
        mav.setViewName("hello");
        return mav;
    }

    /**
     * ExceptionHandler注解打印异常
     *
     * <pre>
     *  打印结果：
     *      ====Exception Handler!====
     *      null
     * </pre>
     */
    @RequestMapping("/exception")
    public void printException() {
        throw new NullPointerException();
    }

    @RequestMapping("/service")
    public void doService() {
        simpleService.doService();
    }

}
