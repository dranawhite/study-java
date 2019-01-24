package com.study.concurrent.notify;

import com.dranawhite.common.common.ThreadUnit;

import java.util.Queue;

/**
 *
 * @author dranawhite
 * @version $Id: Consumer.java, v 0.1 2019-01-23 21:45 dranawhite Exp $$
 */
public class Consumer implements Runnable {

    private Queue<Integer> queue;

    private Object lock;

    boolean isEmpty = false;

    int seconds = 0;

    Consumer(Object lock, Queue<Integer> queue, int seconds) {
        this.lock = lock;
        this.queue = queue;
        this.seconds = seconds;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (lock) {
                    if (queue.size() == 0) {
                        isEmpty = true;
                    } else {
                        isEmpty = false;
                    }
                    if (isEmpty) {
                        System.out.println("Consumer Wait!");
                        lock.wait();
                    }
                    lock.notify();
                }
                ThreadUnit.sleep(seconds);
                int result = queue.poll();
                System.out.println("Got Data " + result);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
