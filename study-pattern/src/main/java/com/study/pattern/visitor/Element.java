/**
 * ymm56.com Inc. Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.study.pattern.visitor;

/**
 *
 * @author liangyuquan
 * @version $Id: Element.java, v 0.1 2019-01-02 17:12 liangyuquan Exp $$
 */
public interface Element {

    void accept(Visitor visitor);
}
