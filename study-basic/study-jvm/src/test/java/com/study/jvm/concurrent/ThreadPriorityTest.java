package com.study.jvm.concurrent;

import org.junit.Before;
import org.junit.Test;

/**
 * @author dranawhite 2017/7/21
 * @version 1.0
 */
public class ThreadPriorityTest {

    private ThreadPriority highThreadPriority;
    private ThreadPriority normThreadPriority;
    private ThreadPriority lowThreadPriority;

    @Before
    public void init() {
        highThreadPriority = new ThreadPriority("HIGH_PRIORITY");
        normThreadPriority = new ThreadPriority("NORM_PRIORITY");
        lowThreadPriority = new ThreadPriority("LOW_PRIORITY");
        highThreadPriority.setPriority(Thread.MAX_PRIORITY);
        normThreadPriority.setPriority(Thread.NORM_PRIORITY);
        lowThreadPriority.setPriority(Thread.MIN_PRIORITY);
    }

    /**
     * 低优先级和高优先级线程一起运行
     *
     * <p>
     * 预期结果：高优先级线程全部跑完后，低优先级线程才会跑
     * </p>
     */
    @Test
    public void testPriority_Together() {
        System.out.println("====预期结果：高优先级线程全部跑完后，低优先级线程才会跑====");
        highThreadPriority.start();
        normThreadPriority.start();
        lowThreadPriority.start();
    }

    /**
     * 低优先级线程先跑一会，然后在运行高优先级线程
     *
     * <p>
     *     预期结果：高优先级线程启动后，低优先级线程暂停，等高优先级线程跑完后，再继续运行
     * </p>
     */
    @Test
    public void testPriority_Grab() {
        System.out.println("====预期结果：高优先级线程启动后，低优先级线程暂停，等高优先级线程跑完后，再继续运行");
        lowThreadPriority.start();
        sleepMillsecond(3);
        normThreadPriority.start();
        sleepMillsecond(2);
        highThreadPriority.start();
    }

    private void sleepMillsecond(int num) {
        try {
            Thread.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
