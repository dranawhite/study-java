/**
 * ymm56.com Inc. Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.study.pattern.visitor;

/**
 *
 * @author liangyuquan
 * @version $Id: VisitorOne.java, v 0.1 2019-01-02 17:11 liangyuquan Exp $$
 */
public class VisitorOne implements Visitor {

    @Override
    public void compute(ElementOne elementOne) {
        System.out.println("V_1 and " + elementOne.getName());
    }

    @Override
    public void compute(ElementTwo elementTwo) {
        System.out.println("V_1 and " + elementTwo.getName());
    }
}
