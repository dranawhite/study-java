package com.study.boot.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <pre>
 *   AnnotationConfigApplicationContext上下文，用于处理Spring Annotation
 * </pre>
 *
 * @author dranawhite
 * @version $Id: Main.java, v 0.1 2018-08-13 17:47 dranawhite Exp $$
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfiguration.class);
        ConfigService configService = (ConfigService) ctx.getBean("configService");
        configService.print();
    }

}
