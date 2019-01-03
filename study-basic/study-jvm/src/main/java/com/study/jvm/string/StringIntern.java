/**
 * ymm56.com Inc. Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.study.jvm.string;

import java.io.IOException;
import java.util.Random;

/**
 * JVM参数设置：-Xmx=2g -Xms=2g -Xmn=1500m
 *
 * @author liangyq
 * @version $Id: StringIntern.java, v 0.1 2018-08-21 10:22 liangyq Exp $$
 */
public class StringIntern {
    static final int MAX = 1000 * 10000;
    static final String[] arr = new String[MAX];

    public static void main(String[] args) throws IOException {
        Integer[] DB_DATA = new Integer[10];
        Random random = new Random(10 * 10000);
        for (int i = 0; i < DB_DATA.length; i++) {
            DB_DATA[i] = random.nextInt();
        }
        long t = System.currentTimeMillis();
        for (int i = 0; i < MAX; i++) {

            // 该方式保存堆中对象的引用，在内存中创建10000000个字符串对象
            arr[i] = new String(String.valueOf(DB_DATA[i % DB_DATA.length]));

            // 该方式由于直接保存在常量池中的引用，只剩余6000左右的对象
            arr[i] = new String(String.valueOf(DB_DATA[i % DB_DATA.length])).intern();
        }

        System.out.println((System.currentTimeMillis() - t) + "ms");
        System.gc();
        System.in.read();
    }
}
