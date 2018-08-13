package com.study.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <pre>
 *     使用Java类的方式配置bean
 * </pre>
 *
 * @author dranawhite 2017/12/18
 * @version 1.0
 */
public class AnnoConfigurableLoaderPro {

    public <T> T getBean(String name, Class clz) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext
                (PersonBuilder.class);
        return (T) ctx.getBean(name, clz);
    }

}
