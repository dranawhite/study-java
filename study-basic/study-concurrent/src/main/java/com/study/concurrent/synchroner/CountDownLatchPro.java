package com.study.concurrent.synchroner;

import com.dranawhite.common.exception.DranaSystemException;
import com.dranawhite.common.exception.GenericResultCode;

import java.util.concurrent.CountDownLatch;

/**
 * @author dranawhite
 * @version [1.0, 2018/5/15 15:08]
 */
public class CountDownLatchPro {

    private CountDownLatch latch = new CountDownLatch(2);

    public void countDown() {
        latch.countDown();
    }

    public void await() {
        try {
            latch.await();
        } catch (InterruptedException ex) {
            throw new DranaSystemException("线程中断异常!", GenericResultCode.SYSTEM_ERROR, ex);
        }
    }
}
