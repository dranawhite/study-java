package com.study.concurrent.notify;

import com.dranawhite.common.common.ThreadUnit;

import java.util.Queue;

/**
 *
 * @author dranawhite
 * @version $Id: Producer.java, v 0.1 2019-01-23 21:44 dranawhite Exp $$
 */
public class Producer implements Runnable {

    private Object lock;

    private Queue<Integer> queue;

    private static final int MAX_SIZE = 10;

    boolean isFull = false;

    Producer(Object lock, Queue<Integer> queue) {
        this.lock = lock;
        this.queue = queue;
    }

    @Override
    public void run() {
        int index = 0;
        while (true) {
            try {
                synchronized (lock) {
                    if (queue.size() >= MAX_SIZE) {
                        isFull = true;
                    } else {
                        isFull = false;
                    }

                    if (isFull) {
                        System.out.println("Producer wait!");
                        lock.wait();
                    }
                    lock.notify();
                }
                ThreadUnit.sleep(5);
                queue.add(++index);
                System.out.println("Push Data " + index);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
}
