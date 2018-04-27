package com.test.jvm.generation;

/**
 * @author dranawhite 2017/8/24
 * @version 1.0
 */
class SubGene<E> extends Basic<E> {

    private E data;

    public void set(E e) {
        this.data = e;
    }

    public E get() {
        return this.data;
    }

}
