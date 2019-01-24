package com.study.concurrent.synchronize;

import com.dranawhite.common.common.ThreadUnit;

/**
 * synchronized是锁住this，所以示例中是串行的
 *
 * <pre>
 * 运行结果:
 *   Method B!
 *   B Over!
 *   Method A!
 *   A Over!
 * </pre>
 *
 * @author dranawhite
 * @version $Id: SynchronizePro.java, v 0.1 2019-01-24 14:04 dranawhite Exp $$
 */
public class SynchronizePro{

    public synchronized void testA() {
        System.out.println("Method A!");
        ThreadUnit.sleep(10);
        System.out.println("A Over!");
    }

    public synchronized void testB() {
        System.out.println("Method B!");
        ThreadUnit.sleep(10);
        System.out.println("B Over!");
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizePro pro = new SynchronizePro();
        Thread threadA = new Thread(new ThreadA(pro));
        Thread threadB = new Thread(new ThreadB(pro));
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
    }

}

class ThreadA implements Runnable {

    private SynchronizePro pro;

    ThreadA(SynchronizePro pro) {
        this.pro = pro;
    }

    @Override
    public void run() {
        pro.testA();
    }
}

class ThreadB implements Runnable {

    private SynchronizePro pro;

    ThreadB(SynchronizePro pro) {
        this.pro = pro;
    }

    @Override
    public void run() {
        pro.testB();
    }
}