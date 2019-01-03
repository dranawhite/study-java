package com.study.jvm.concurrent;

/**
 * @author dranawhite 2017/9/25
 * @version 1.0
 */
public class ThreadUnion {

    public void run() throws InterruptedException {

        Thread thread = new Thread(() -> {
            try {
                int a = 0;
                for (int i = 0; i < 5; i ++) {
                    a++;
                    System.out.println("a= " + a);
                    Thread.sleep(1000);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.setName("CountA");
        thread.start();
        thread.join();
        int b = 0;
        for ( int i = 0; i < 5; i++) {
            b++;
            System.out.println("b= " + b);
            Thread.sleep(1000);
        }
    }

}
