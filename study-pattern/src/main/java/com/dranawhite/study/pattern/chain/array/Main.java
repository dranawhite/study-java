package com.dranawhite.study.pattern.chain.array;

/**
 * <pre>
 *     职责链模式的数组形式实现
 *     filterChain的添加顺序便是执行顺序
 * </pre>
 *
 * @author dranawhite
 * @version : Main.java, v 0.1 2019-08-12 16:44 dranawhite Exp $$
 */
public class Main {

    public static void main(String[] args) {
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new DirectorFilter());
        filterChain.addFilter(new ManagerFilter());
        filterChain.addFilter(new MasterFilter());
        filterChain.doInternalFilter();
    }
}
