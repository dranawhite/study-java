package com.study.boot.web;

/**
 *
 * @author dranawhite
 * @version $Id: ThreadLocalUtils.java, v 0.1 2019-01-15 20:50 dranawhite Exp $$
 */
public final class ThreadLocalUtils {

    private static ThreadLocal<Integer> map = new ThreadLocal<>();

    public static void set(Integer value) {
        map.set(value);
    }

    public static Integer get() {
        return map.get();
    }

    public static void remove() {
        map.remove();
    }
}
