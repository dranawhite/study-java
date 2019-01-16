package com.study.concurrent;

import com.dranawhite.common.common.ThreadUnit;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author dranawhite
 * @version $Id: ReentrantLockTest.java, v 0.1 2019-01-03 20:33 dranawhite Exp $$
 */
public class ReentrantLockTest {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock(true);
        ReentrantLockTest test = new ReentrantLockTest();

        MThread_1 m1 = test.new MThread_1(lock);
        m1.start();
        MThread_2 m2 = test.new MThread_2(lock);
        m2.start();
        MThread_3 m3 = test.new MThread_3(lock);
        m3.start();

        m1.join();
        m2.join();
        m3.join();
    }

    class MThread_1 extends Thread {

        private ReentrantLock lock;

        public MThread_1(ReentrantLock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            lock.lock();
        }
    }

    class MThread_2 extends Thread {

        private ReentrantLock lock;

        public MThread_2(ReentrantLock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                ThreadUnit.sleep(5);
                lock.lock();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    class MThread_3 extends Thread {

        private ReentrantLock lock;

        public MThread_3(ReentrantLock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                ThreadUnit.sleep(10);
                lock.lock();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
}
