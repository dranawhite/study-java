package com.study.jvm.generation;

/**
 * @author dranawhite 2017/8/24
 * @version 1.0
 */
class Tuple<T, K, V> {

    private T t;
    private K k;
    private V v;

    public Tuple(T t, K k, V v) {
        this.t = t;
        this.k = k;
        this.v = v;
    }

    /**
     * @return the t
     */
    public T getT() {
        return t;
    }

    /**
     * @return the k
     */
    public K getK() {
        return k;
    }

    /**
     * @return the v
     */
    public V getV() {
        return v;
    }
}
