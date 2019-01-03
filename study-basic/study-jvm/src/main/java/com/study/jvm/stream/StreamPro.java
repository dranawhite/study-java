package com.study.jvm.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Jdk 1.8新特性 Stream
 *
 * @author liangyq 2018/3/13
 */
public class StreamPro {

    static List<Integer> list = Arrays.asList(4, 5, 6, 9, 0, 1, 2, 3);

    public static void main(String[] args) {
        list.parallelStream()
                .forEach(num -> System.out.print(num+"\t"));
    }

}
