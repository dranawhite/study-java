package com.study.concurrent.thread;

import com.dranawhite.common.common.ThreadUnit;

/**
 *
 * @author dranawhite
 * @version $Id: ThreadLocalPro.java, v 0.1 2019-01-15 19:55 dranawhite Exp $$
 */
public class ThreadLocalPro extends Thread {

    private ThreadLocal<Integer> map;

    public ThreadLocalPro(ThreadLocal<Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        map.set(12);
        ThreadUnit.sleep(5);
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<Integer> map = new ThreadLocal<>();
        map.set(11);
        ThreadLocalPro pro = new ThreadLocalPro(map);
        pro.start();
        pro.join();
        System.out.println(map.get());
    }

}
