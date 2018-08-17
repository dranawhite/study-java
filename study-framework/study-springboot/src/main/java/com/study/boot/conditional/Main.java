/**
 * ymm56.com Inc. Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.study.boot.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author liangyq
 * @version $Id: Main.java, v 0.1 2018-08-13 18:06 liangyq Exp $$
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        String windows = (String) ctx.getBean("windows");
        System.out.println("Windows = " + windows);
    }
}
