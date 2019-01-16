package com.study.jvm.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterators;

/**
 * @author dranawhite 2018/3/14
 */
public class SpliteratorPro {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(8,3,2,6,9,0);
        Spliterators.spliterator(list, 0);
    }

}
