package com.test.jvm.method;

import com.dranawhite.jvm.memory.FalseSharing;
import org.junit.Test;

/**
 * <pre>
 *    4线程 7个缓存填充    duration = 15054820228
 *    4线程 6个缓存填充    duration = 16119945025
 *    4线程 4个缓存填充    duration = 13843007421
 *    4线程 14个缓存填充   duration =  3323985863
 *    4线程 没有缓存填充   duration = 30350248330
 * </pre>
 *
 * @author dranawhite 2017/9/26
 * @version 1.0
 */
public class FalseSharingTest {

    @Test
    public void testFalseSharing() throws InterruptedException {
        final long start = System.nanoTime();
        FalseSharing.runTest();
        System.out.println("duration = " + (System.nanoTime() - start));
    }

}
