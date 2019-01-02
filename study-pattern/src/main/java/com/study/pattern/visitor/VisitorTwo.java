/**
 * ymm56.com Inc. Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.study.pattern.visitor;

/**
 *
 * @author liangyuquan
 * @version $Id: VisitorTwo.java, v 0.1 2019-01-02 17:18 liangyuquan Exp $$
 */
public class VisitorTwo implements Visitor {

    @Override
    public void compute(ElementOne elementOne) {
        System.out.println("V_2 and " + elementOne.getName());
    }

    @Override
    public void compute(ElementTwo elementTwo) {
        System.out.println("V_2 and " + elementTwo.getName());
    }
}
