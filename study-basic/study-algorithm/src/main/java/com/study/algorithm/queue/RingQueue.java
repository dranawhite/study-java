package com.study.algorithm.queue;

/**
 *
 * @author dranawhite
 * @version : RingQueue.java, v 0.1 2019-04-11 11:03 dranawhite Exp $$
 */
public class RingQueue {

    private int capacity = 16;
    private int mask = 0xFF;

    private Object[] queue = new Object[capacity];

    private int head = 0;
    private int tail = 0;
    private int next = 0;

    public boolean enqueue(Object data) {
        if (head - tail == 1 || head + capacity - tail == 1) {
            return false;
        }
        tail = next++ & mask;
        queue[tail] = data;
        return true;
    }

    public Object dequeue() {
        if (next == 0) {
            return null;
        }
        return queue[head++];
    }

}
