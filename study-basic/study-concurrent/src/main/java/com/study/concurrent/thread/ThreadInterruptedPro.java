package com.study.concurrent.thread;

import com.dranawhite.common.common.ThreadUnit;

import java.util.concurrent.locks.LockSupport;

/**
 * @author dranawhite
 * @version $Id: ThreadInterruptedPro.java, v 0.1 2019-01-15 18:07 dranawhite Exp $$
 */
public class ThreadInterruptedPro extends Thread {

    @Override
    public void run() {
        System.out.println("Parking!");
        LockSupport.park();
        if (this.isInterrupted()) {
            System.out.println("Oh No! ");
        } else {
            System.out.println("Hit me , ha ha ha!");
        }
    }

    public static void main(String[] args) {
        ThreadInterruptedPro pro = new ThreadInterruptedPro();
        pro.start();

        ThreadUnit.sleep(5);
        System.out.println("Interrupt you, ha ha ha!");
        pro.interrupt();
        System.out.println("alive: " + pro.isAlive());
        System.out.println("interrupt: " + pro.isInterrupted());
    }
}
