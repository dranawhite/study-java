package com.dranawhite.study.pattern.vs.decoratorandproxy;

/**
 *
 * @author dranawhite
 * @version : IRunDecorator.java, v 0.1 2019-08-14 11:12 dranawhite Exp $$
 */
public abstract class IRunDecorator implements IRunner {

    /**
     * 花式跑步
     */
    abstract void flowerRun();
}
