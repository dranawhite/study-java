package com.study.spring.aop;

/**
 * @author liangyq 2017/8/18
 */
public class ApolopyImpl implements Apolopy {

    @Override
    public void sayAgain() {
        System.out.println("Spring Aspect-引入增强");
    }
}
