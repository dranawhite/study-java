/**
 * ymm56.com Inc. Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.study.concurrent;

import com.dranawhite.common.util.ThreadUnit;
import com.study.concurrent.synchroner.Counter;

/**
 *
 * @author liangyuquan
 * @version $Id: InterruptTest.java, v 0.1 2019-01-03 19:50 liangyuquan Exp $$
 */
public class InterruptTest {

    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.start();
        ThreadUnit.sleep(20);
        counter.interrupt();
    }
}
