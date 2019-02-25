package com.study.concurrent.pool.datasource.pool;

import java.io.IOException;
import java.util.Random;

/**
 * @author dranawhite
 * @version $Id: Main.java, v 0.1 2019-02-19 18:58 dranawhite Exp $$
 */
public class Main implements Runnable {

    private static DranaDataSource dataSource = new DranaDataSource();

    private static Random random = new Random(100);

    static {
        dataSource.initConnectionPool();
    }

    @Override
    public void run() {
        int num = random.nextInt(100);
        String connType = "connType_";
        if (num > 300) {
            connType += 4;
        } else {
            connType += num;
        }
        dataSource.execute(connType);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Random random = new Random(1000);
        for (int i = 0; i < 1000; i++) {
            Thread t = new Thread(new Main());
            t.start();
            // 模拟耗时
            Thread.sleep(random.nextInt(1000));
        }
        System.in.read();
    }
}
