package com.dranawhite.study.pattern.vs.decoratorandproxy;

import lombok.Setter;

import java.util.Random;

/**
 * 代理模式着重于对代理过程的控制
 *
 * @author dranawhite
 * @version : RunnerProxy.java, v 0.1 2019-08-14 11:10 dranawhite Exp $$
 */
public class RunnerProxy implements IRunner {

    @Setter
    private IRunner runner;

    @Override
    public void run() {
        Random random = new Random();
        int num = random.nextInt(10);
        if (num % 2 == 0) {
            System.out.println("收到慰问金!");
            runner.run();
        } else {
            System.out.println("没收到钱，跑个毛!");
        }
    }
}
