package com.dranawhite.study.pattern.vs.decoratorandproxy;

import lombok.Setter;

/**
 * 装饰器模式着重对功能的加强或者减弱
 *
 * @author dranawhite
 * @version : RunDecorator.java, v 0.1 2019-08-14 11:13 dranawhite Exp $$
 */
public class RunDecorator extends IRunDecorator {

    @Setter
    private IRunner runner;

    @Override
    void flowerRun() {
        System.out.println("看我跑出个花来!");
    }

    @Override
    public void run() {
        flowerRun();
        runner.run();
    }
}
