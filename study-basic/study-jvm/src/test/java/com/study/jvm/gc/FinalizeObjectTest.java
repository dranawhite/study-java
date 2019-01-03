package com.study.jvm.gc;

import org.junit.Test;

/**
 * GC时，对象的finalize方法只会执行一次
 *
 * @author dranawhite 2017/8/4
 * @version 1.0
 */
public class FinalizeObjectTest {

    @Test
    public void testFinalize() throws InterruptedException {
        FinalizeObject finalizeObject = new FinalizeObject("Test");
        finalizeObject.createObj();
        finalizeObject.gc();
        Thread.sleep(3000L);
        finalizeObject.printResult();
        finalizeObject.gc();
        Thread.sleep(3000L);
        finalizeObject.printResult();
    }

}
