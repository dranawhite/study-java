/**
 * ymm56.com Inc. Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.study.boot.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author liangyq
 * @version $Id: Main.java, v 0.1 2018-08-13 17:47 liangyq Exp $$
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfiguration.class);
        ConfigService configService = (ConfigService) ctx.getBean("configService");
        configService.print();
    }

}
