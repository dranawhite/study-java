/**
 * ymm56.com Inc. Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.study.pattern.visitor;

/**
 *
 * @author liangyuquan
 * @version $Id: Visitor.java, v 0.1 2019-01-02 17:11 liangyuquan Exp $$
 */
public interface Visitor {

    void compute(ElementOne elementOne);

    void compute(ElementTwo elementTwo);
}
