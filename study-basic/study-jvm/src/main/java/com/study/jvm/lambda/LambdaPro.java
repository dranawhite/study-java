package com.study.jvm.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author liangyq 2018/3/14
 */
public class LambdaPro {

    private List<Integer> list = Arrays.asList(4, 6, 8, 2, 1, 3);

    /**
     * lambda的形式实现，底层会实现一个内部类，并同时生成一个私有的静态方法用于lambda
     */
    public void lambda() {
        Collections.sort(list, (org, exp) -> Integer.compare(org, exp));
    }

    /**
     * 方法引用的形式实现，底层也是实现一个内部类
     */
    public void reference() {
        Collections.sort(list, Integer::compare);
    }

    /**
     * 匿名内部类的形式
     */
    public void normal() {
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer org, Integer exp) {
                return Integer.compare(org, exp);
            }
        });
    }

}
