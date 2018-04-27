package com.test.jvm.generation;

/**
 * @author dranawhite 2017/8/23
 * @version 1.0
 */
class Basic<E> {

    private E e;
    private InnerGen<E> innerGen;
    private InnerGenII<E> innerGenII;

    public Basic() {
        innerGen = new InnerGen<>();
        innerGenII = new InnerGenII<>();
    }

    public Basic(E e) {
        this();
        this.e = e;
        innerGen.set(e);
        innerGenII.set(e);
    }

    public void set(E e) {
        this.e = e;
        innerGen.set(e);
        innerGenII.set(e);
    }

    public E get() {
        return this.e;
    }

    public E getInner() {
        return innerGen.get();
    }

    public E getInnerII() {
        return innerGenII.get();
    }

    class InnerGen<E> {

        private E data;

        public void set(E data) {
            this.data = data;
        }

        public E get() {
            return this.data;
        }

    }

    class InnerGenII<T> {

        private T data;

        public void set(T data) {
            this.data = data;
        }

        public T get() {
            return this.data;
        }
    }

}
