package com.study.pattern.visitor;

/**
 *
 * @author dranawhite
 * @version $Id: Visitor.java, v 0.1 2019-01-02 17:11 dranawhite Exp $$
 */
public interface Visitor {

    void compute(ElementOne elementOne);

    void compute(ElementTwo elementTwo);
}
