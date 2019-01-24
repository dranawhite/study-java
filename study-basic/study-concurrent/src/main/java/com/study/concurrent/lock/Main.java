package com.study.concurrent.lock;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * @author dranawhite
 * @version $Id: Main.java, v 0.1 2019-01-24 10:59 dranawhite Exp $$
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new ArrayDeque<>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        producer.setConsumer(consumer);
        consumer.setProducer(producer);

        producer.start();
        consumer.start();

        System.in.read();
    }

}
