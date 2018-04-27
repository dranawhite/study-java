package com.test.jvm.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author dranawhite.web.jvm 2017/7/4
 * @version 1.0
 */
class UserCaseTracker {

    /**
     * 解析UserCase注解
     * @param cls UserCase注解标注的类
     */
    public void annotation(Class cls) {
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            Annotation annotation = method.getAnnotation(UserCase.class);
            if (annotation != null) {
                UserCase userCase = (UserCase) annotation;
                System.out.println("ID: " + userCase.id());
                System.out.println("DESC: " + userCase.description());
            }
        }
    }

}
