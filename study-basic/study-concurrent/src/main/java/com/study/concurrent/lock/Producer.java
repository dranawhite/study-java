package com.study.concurrent.lock;

import com.dranawhite.common.common.ThreadUnit;

import java.util.Queue;
import java.util.concurrent.locks.LockSupport;

import lombok.Setter;

/**
 *
 * @author dranawhite
 * @version $Id: Producer.java, v 0.1 2019-01-24 10:59 dranawhite Exp $$
 */
public class Producer extends Thread {
    
    private Queue<Integer> queue;

    @Setter
    private Consumer consumer;

    private static final int MAX_SIZE = 10;

    boolean isFull = false;

    Producer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int index = 0;
        while(true) {
            if (queue.size() == MAX_SIZE) {
                isFull = true;
            } else {
                isFull = false;
            }

            if (isFull) {
                System.out.println("Producer Wait!");
                LockSupport.park(this);
            }
            System.out.println("Push Data " + (++index));
            queue.add(index);
            ThreadUnit.sleep(5);
            LockSupport.unpark(consumer);
        }
    }
}
