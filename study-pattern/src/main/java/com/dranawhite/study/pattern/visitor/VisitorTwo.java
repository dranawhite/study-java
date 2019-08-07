package com.dranawhite.study.pattern.visitor;

/**
 *
 * @author dranawhite
 * @version $Id: VisitorTwo.java, v 0.1 2019-01-02 17:18 dranawhite Exp $$
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
