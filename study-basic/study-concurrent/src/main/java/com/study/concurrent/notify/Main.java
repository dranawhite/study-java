package com.study.concurrent.notify;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * @author dranawhite
 * @version $Id: Main.java, v 0.1 2019-01-23 21:58 dranawhite Exp $$
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Object lock = new Object();
        Queue<Integer> queue = new ArrayDeque<>(10);
        Consumer consumer_2 = new Consumer(lock, queue, 8);
        Thread thread_2 = new Thread(consumer_2);
        thread_2.setName("Consumer");
        thread_2.start();

        Producer producer = new Producer(lock, queue);
        Thread thread = new Thread(producer);
        thread.setName("Producer");
        thread.start();

        System.in.read();
    }

}
