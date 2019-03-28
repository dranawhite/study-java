package com.study.mybatis.spring;

import java.lang.reflect.Type;
import java.util.List;

/**
 *
 * @author liangyuquan
 * @version $Id: Main.java, v 0.1 2019-03-25 18:27 liangyuquan Exp $$
 */
public class Main {

    public static void main(String[] args) {
        Class clz = List.class;
        Type type = clz.getGenericSuperclass();
        System.out.println("TYPE = " + type.getTypeName());
    }

}
