/**
 * ymm56.com Inc. Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.study.concurrent.synchroner;

import com.dranawhite.common.util.ThreadUnit;

/**
 * @author liangyuquan
 * @version $Id: Counter.java, v 0.1 2019-01-03 19:48 liangyuquan Exp $$
 */
public class Counter extends Thread {

    @Override
    public void run() {
        int num = 0;
        try {
            while (true) {
                if (!isInterrupted()) {
                    ThreadUnit.sleep(5);
                    System.out.println(++num);
                } else {
                    throw new InterruptedException("中断一下");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
