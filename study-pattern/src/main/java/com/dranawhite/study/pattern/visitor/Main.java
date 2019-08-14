package com.dranawhite.study.pattern.visitor;

/**
 * 访问者模式
 * <pre>
 *     是对迭代器模式的扩充，可以充当拦截器的角色
 * </pre>
 *
 * @author dranawhite
 * @version $Id: Main.java, v 0.1 2019-01-02 17:24 dranawhite Exp $$
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
