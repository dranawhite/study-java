package com.study.algorithm.stack;

/**
 *
 * @author dranawhite
 * @version : ArrayStack.java, v 0.1 2019-04-10 19:23 dranawhite Exp $$
 */
public class ArrayStack {

    private int capacity = 10;

    private Object[] dataArr = new Object[capacity];

    private int current = 0;

    public boolean push(Object data) {
        if (current == capacity) {
            return false;
        }
        dataArr[current++] = data;
        return true;
    }

    public Object pop() {
        if (current == 0) {
            return null;
        }
        return dataArr[current--];
    }

}