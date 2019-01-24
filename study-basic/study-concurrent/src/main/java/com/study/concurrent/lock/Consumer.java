package com.study.concurrent.lock;

import com.dranawhite.common.common.ThreadUnit;

import java.util.Queue;
import java.util.concurrent.locks.LockSupport;

import lombok.Setter;

/**
 *
 * @author dranawhite
 * @version $Id: Consumer.java, v 0.1 2019-01-24 10:59 dranawhite Exp $$
 */
public class Consumer extends Thread {

    private Queue<Integer> queue;

    @Setter
    private Producer producer;

    boolean isEmpty = false;

    Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            if (queue.size() == 0) {
                isEmpty = true;
            } else {
                isEmpty = false;
            }

            if (isEmpty) {
                System.out.println("Consumer Wait!");
                LockSupport.park(this);
            }
            int result = queue.poll();
            System.out.println("Got Data " + result);
            ThreadUnit.sleep(8);
            LockSupport.unpark(producer);
        }
    }
}
