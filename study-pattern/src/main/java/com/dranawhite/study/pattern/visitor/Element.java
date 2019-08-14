package com.dranawhite.study.pattern.visitor;

/**
 * 声明接受哪一类访问者访问
 *
 * @author dranawhite
 * @version $Id: Element.java, v 0.1 2019-01-02 17:12 dranawhite Exp $$
 */
public interface Element {

    void accept(Visitor visitor);
}
