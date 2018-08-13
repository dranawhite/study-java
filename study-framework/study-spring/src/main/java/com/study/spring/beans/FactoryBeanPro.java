package com.study.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * FactoryBean通过getBean调用时，实际是返回FactoryBean.getObject()
 *
 * @author liangyq 2017/12/22
 */
public class FactoryBeanPro {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext
                ("beans/applicationContext-person.xml");
        Object obj = ctx.getBean("pn");
        //打印结果是com.dranawhite.com.study.spring.beans.bean.Person@77846d2c，而不是PersonFactoryBean
        System.out.println(obj);
    }

}
