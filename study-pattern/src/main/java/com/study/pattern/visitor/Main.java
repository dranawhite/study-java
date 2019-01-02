/**
 * ymm56.com Inc. Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.study.pattern.visitor;

/**
 *
 * @author liangyuquan
 * @version $Id: Main.java, v 0.1 2019-01-02 17:24 liangyuquan Exp $$
 */
public class Main {

    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();
        os.attach(new ElementOne("ElementOne"));
        os.attach(new ElementTwo("ElementTwo"));
        os.compute(new VisitorOne());
        os.compute(new VisitorTwo());
    }
}
