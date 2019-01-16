package com.study.concurrent;

import com.dranawhite.common.common.ThreadUnit;

import com.study.concurrent.synchroner.Counter;

/**
 *
 * @author dranawhite
 * @version $Id: InterruptTest.java, v 0.1 2019-01-03 19:50 dranawhite Exp $$
 */
public class InterruptTest {

    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.start();
        ThreadUnit.sleep(20);
        counter.interrupt();
    }
}
