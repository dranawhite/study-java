package com.study.concurrent.pool;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author dranawhite
 * @version $Id: ThreadPoolPro.java, v 0.1 2019-02-19 9:31 dranawhite Exp $$
 */
public class ThreadPoolPro {

    public static void main(String[] args) throws IOException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue<>(2);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 5, 20,
                TimeUnit.SECONDS, queue);
        for (int i = 0; i < 5; i++) {
            executor.execute(new Task());
        }
        System.in.read();
    }
}

class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello Task!");
    }
}